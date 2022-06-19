<a href="https://dot.net/architecture">
   <img src="img/logo/eShop.png" alt="eShop logo" title="eShopOnContainers" align="right" height="60" />
</a>

# Autotest for Microsoft eshop projects
### Web UI & API - <a target="_blank" href="https://github.com/dotnet-architecture/eShopOnContainers">eShopOnContainers</a>

> The app deployed with kubernetes on MS Azure, good demonstration about enterprise microservice architecture

### Mobile - <a target="_blank" href="https://github.com/dotnet-architecture/eshop-mobile-client">eshop mobile client</a>

> Cross-platform mobile eshop client that supports Android, iOS, UWP. Current autotests used build from this pull request <a target="_blank" href="https://github.com/dotnet-architecture/eshop-mobile-client/pull/23">pull request</a>

// readme in progress

##  Technology stack

<p align="center">
<a href="https://www.jenkins.io/"><img src="img/logo/Jenkins.svg" width="50" height="50" alt="Jenkins"/></a>
<a href="https://aerokube.com/selenoid/"><img src="img/logo/Selenoid.svg" width="50" height="50" alt="Selenoid"/></a>
<a href="https://www.jetbrains.com/idea/"><img src="img/logo/Idea.svg" width="50" height="50" alt="IDEA"/></a>
<a href="https://www.java.com/"><img src="img/logo/Java.svg" width="50" height="50" alt="Java"/></a>
<a href="https://github.com/"><img src="img/logo/GitHub.svg" width="50" height="50" alt="Github"/></a>
<a href="https://junit.org/junit5/"><img src="img/logo/Junit5.svg" width="50" height="50" alt="JUnit 5"/></a>
<a href="https://gradle.org/"><img src="img/logo/Gradle.svg" width="50" height="50" alt="Gradle"/></a>
<a href="https://selenide.org/"><img src="img/logo/Selenide.svg" width="50" height="50" alt="Selenide"/></a>
<a href="https://github.com/allure-framework/allure2/"><img src="img/logo/Allure.svg" width="50" height="50" alt="Allure"/></a>
<a href="https://appium.io/"><img src="img/logo/Appium.svg" width="50" height="50" alt="Appium"/></a>
<a href="https://qameta.io/"><img src="img/logo/AllureTestOps.svg" width="50" height="50" alt="AllureTestOps"/></a>
<a href="https://rest-assured.io/"><img src="img/logo/RestAssured.svg" width="50" height="50" alt="RestAssured"/></a>
<a href="https://www.atlassian.com/ru/software/jira"><img src="img/logo/Jira.svg" width="50" height="50" alt="Jira"/></a>
<a href="https://browserstack.com/"><img src="img/logo/Browserstack.svg" width="50" height="50" alt="Browserstack"/></a>
</p>

<details open><summary><h2>:arrows_counterclockwise: Shared part</h2></summary>

<h3> 
<img src="img/logo/Jenkins.svg" width="25" height="25"  alt="Jenkins"/> Jenkins <a target="_blank" href="https://jenkins.autotests.cloud/job/eshop-autotests/">pipeline.</a> For access to jenkins contact with me.
</h3>

### build with param screen
*For launch remote tests it's necessary to click the option <code><strong>*Собрать с параметрами*</strong></code>, then to fill build settings and to click the button <code><strong>*Собрать*</strong></code>.*
<p align="center">
<a href="https://jenkins.autotests.cloud/job/eshop-autotests/">
<img src="img/screens/JenkinsParam.png" alt="Jenkins"/></a>
</p>

After tests execution, in the panel <code><strong>*История сборок*</strong></code> in the row with build number
icons <img width="2%" title="Allure Report" src="img/logo/Allure.svg"><code><strong>*Allure Report*</strong></code>
and <img width="2%" title="Allure TestOps" src="img/logo/AllureTestOps.svg"><code><strong>*Allure TestOps*</strong></code> will appear.

*Icon <img width="2%" title="Allure Report" src="img/logo/Allure.svg"><code><strong>*Allure Report*</strong></code> opens
html-report in Allure Report.*

*Icon <img width="2%" title="Allure TestOps" src="img/logo/AllureTestOps.svg"><code><strong>*Allure TestOps*</strong></code> opens
html-report in Allure TestOps.*

<p align="center">
<a href="https://jenkins.autotests.cloud/job/eshop-autotests/">
<img src="img/screens/JenkinsMain.png" alt="Jenkins"/></a>
</p>

</details>

<details open><summary><h2>:globe_with_meridians: Web UI part</h2></summary>

<h3> :white_check_mark: Covered functionality</h3>
    <ul>
        <li>[X] Auth Tests </li>
        <li>[X] Filter Tests </li>
        <li>[X] HomePage Tests </li>
    </ul>


## <img width="4%" title="Allure Report" src="img/logo/Allure.svg"> Tests results report in [Allure Report](https://alexheal.github.io/eshop-artefacts/)

### :pushpin: Common information

*Allure report main page contains next information blocks:*
> - [x] <code><strong>*ALLURE REPORT*</strong></code> -  date and time of tests launch, total number of executed cases and the diagram with indication of percentage and number of successful, failed and broken tests
>- [x] <code><strong>*TREND*</strong></code> - displays trend of passing tests from one build to another
>- [x] <code><strong>*SUITES*</strong></code> - displays the distribution of tests results by tests suites
>- [x] <code><strong>*ENVIRONMENT*</strong></code> - displays test environment where tests were launched
>- [x] <code><strong>*CATEGORIES*</strong></code> - displays the distribution of failed tests by types of defects
>- [x] <code><strong>*FEATURES BY STORIES*</strong></code> - displays the distribution of tests by functionality, which they check
>- [x] <code><strong>*EXECUTORS*</strong></code> - displays the executor of the current build (link to Jenkins build)

<p align="center">
  <img src="img/screens/AllureMain.png" alt="Allure Report" width="900">
</p>

## <img width="4%" title="Allure TestOPS" src="img/logo/AllureTestOps.svg"> [Allure TestOps](https://allure.autotests.cloud/launch/13303) integration

### :pushpin: Overview dashboard

<p align="center">
  <img src="img/screens/AllureTOMain.png" alt="dashboards" width="900">
</p>

## <img width="4%" title="Telegram" src="img/logo/Telegram.svg"> Telegram notifications using a bot

> After the pipeline is completed, created <code>Telegram</code>-bot automatically handles and sends a message with a test run report.

<p align="center">
<img title="Telegram Notifications" src="img/screens/WebTelegram.png">
</p>

## <img width="4%" title="Selenoid" src="img/logo/Selenoid.svg"> Example of test execution in Selenoid

> A video is attached to each test in the allure report.

https://user-images.githubusercontent.com/24870446/174431817-6defe430-2753-4078-b9a2-e51bf9b8d2e9.mp4

</details>


