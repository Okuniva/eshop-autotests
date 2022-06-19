pipeline {
    agent any

    triggers {
        cron('H H 1,10,20,28 1-12 *')
    }
    options { timestamps() }

    tools {
        gradle 'Gradle 7.4.1'
    }

    stages {
        stage('Parameters') {
            steps {
                script {
                    properties([
                            parameters([
                                    choice(
                                            choices: ['api', 'web', 'mobile', 'all'],
                                            name: 'TAG'
                                    ),
                                    choice(
                                            choices: ['chrome', 'firefox', 'opera'],
                                            name: 'BROWSER'
                                    ),
                                    string(
                                            defaultValue: '100.0',
                                            name: 'BROWSER_VERSION',
                                            trim: true
                                    ),
                                    choice(
                                            choices: ['1920x1080', '1366x768', '1280x1024', '1280x800', '1024x768'],
                                            name: 'BROWSER_SIZE'
                                    ),
                                    choice(
                                            choices: ['', 'iPhone X', 'iPad Pro', 'Nexus 7'],
                                            name: 'BROWSER_MOBILE'
                                    ),
                                    string(
                                            defaultValue: '5',
                                            name: 'TREADS',
                                            trim: true
                                    ),
                                    string(
                                            defaultValue: 'http://51.132.209.113',
                                            name: 'WEB_URL',
                                            trim: true
                                    ),
                                    string(
                                            defaultValue: 'tempov_KMieFC',
                                            name: 'BS_USERNAME',
                                            trim: true
                                    ),
                                    string(
                                            defaultValue: '5zERpyaB6BLgg7UGtBND',
                                            name: 'BS_ACCESS_KEY',
                                            trim: true
                                    ),
                                    string(
                                            defaultValue: 'selenoid.autotests.cloud',
                                            name: 'REMOTE_DRIVER_URL',
                                            trim: true
                                    ),
                                    string(
                                            defaultValue: 'http://selenoid.autotests.cloud/video',
                                            name: 'REMOTE_DRIVER_VIDEO_STORAGE',
                                            trim: true
                                    ),
                                    string(
                                            defaultValue: '4.1',
                                            name: 'ALLURE_NOTIFICATIONS_VERSION',
                                            description: 'https://github.com/qa-guru/allure-notifications',
                                            trim: true
                                    )
                            ])
                    ])
                }
            }
        }
        stage('Status') {
            steps {
                httpRequest responseHandle: 'NONE', url: "https://${REMOTE_DRIVER_URL}/status", wrapAsMultipart: false
            }
        }
        stage('Build') {
            steps {
                git branch: 'main', url: 'https://github.com/AlexHeal/eshop-autotests'
            }
        }
        stage('Test') {
            steps {
                withAllureUpload(name: '${JOB_NAME} - #${BUILD_NUMBER}', projectId: '1378', results: [[path: 'build/allure-results']], serverId: 'allure-server', tags: 'nightly') {
                    withCredentials([usernamePassword(credentialsId: 'eshop-login-credentials', passwordVariable: 'USER_PASSWORD', usernameVariable: 'USER_LOGIN')]) {
                        withCredentials([usernamePassword(credentialsId: 'eshop-remote-selenoid-credentials', passwordVariable: 'REMOTE_DRIVER_PASSWORD', usernameVariable: 'REMOTE_DRIVER_LOGIN')]) {
                            sh 'gradle clean test -Dtag=${TAG} -DwebUrl=${WEB_URL} -Dbs_username=${BS_USERNAME} -Dbs_access_key=${BS_ACCESS_KEY} -DuserLogin=${USER_LOGIN} -DuserPassword=${USER_PASSWORD} -Dbrowser=${BROWSER} -DbrowserVersion=${BROWSER_VERSION} -DbrowserSize=${BROWSER_SIZE} -Dthreads=${TREADS} -DremoteDriverUrl=https://${REMOTE_DRIVER_LOGIN}:${REMOTE_DRIVER_PASSWORD}@${REMOTE_DRIVER_URL}/wd/hub -DvideoStorage=${REMOTE_DRIVER_VIDEO_STORAGE}'
                        }
                    }
                }
            }
        }
    }
    post {
        always {
            script {
                allure([
                        includeProperties: false,
                        jdk              : '',
                        properties       : [],
                        reportBuildPolicy: 'ALWAYS',
                        results          : [[path: 'build/allure-results']]
                ])
                
                withCredentials([usernamePassword(credentialsId: 'eshop-telegram-credentials', usernameVariable: 'TELEGRAM_CHAT_ID', passwordVariable: 'TELEGRAM_TOKEN')]) {
                    writeFile file: 'notifications/telegram_config.json', text:
                            """{
                            "base": {
                                "project": "${JOB_BASE_NAME}",
                                "environment": "some env",
                                "comment": "some comment",
                                "reportLink": "${BUILD_URL}",
                                "language": "en",
                                "messenger": "telegram",
                                "allureFolder": "allure-report/",
                                "enableChart": true
                            },
                            "telegram": {
                                "token": "${TELEGRAM_TOKEN}",
                                "chat": "${TELEGRAM_CHAT_ID}",
                                "replyTo": ""
                            }
                        }"""
                }

                sh '''cd ..
                    FILE=./allure-notifications-${ALLURE_NOTIFICATIONS_VERSION}.jar
                    if [ ! -f "$FILE" ]; then
                    wget https://github.com/qa-guru/allure-notifications/releases/download/${ALLURE_NOTIFICATIONS_VERSION}/allure-notifications-${ALLURE_NOTIFICATIONS_VERSION}.jar
                    fi
                '''

                sh '''java "-DconfigFile=notifications/telegram_config.json" -jar ../allure-notifications-4.1.jar'''
            }
        }
    }
}

