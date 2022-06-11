package alexheal.eshop.tests.api;

import alexheal.eshop.config.App;
import alexheal.eshop.helpers.AndroidDriver;
import alexheal.eshop.helpers.allure.AllureAttachments;
import alexheal.eshop.helpers.allure.Layer;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit5.ScreenShooterExtension;
import io.qameta.allure.Feature;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

@Tag("api")
@Feature("api")
@Layer("api")
public class TestBase {
    @BeforeAll
    public static void beforeAll() {
        RestAssured.baseURI = App.config.apiUrl();
    }
}
