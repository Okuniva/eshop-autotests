package alexheal.eshop.tests.mobile;

import alexheal.eshop.drivers.BrowserstackMobileDriver;
import alexheal.eshop.helpers.allure.AllureAttachments;
import alexheal.eshop.helpers.allure.Layer;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit5.ScreenShooterExtension;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

@ExtendWith({ScreenShooterExtension.class})
@Feature("mobile")
@Layer("mobile")
@Tags({@Tag("mobile"), @Tag("all")})
public class TestBase {
    @BeforeAll
    public static void beforeAll() {
        if(!SelenideLogger.hasListener("AllureSelenide"))
            SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        closeWebDriver();
        Configuration.browserSize = null;
        Configuration.browser = BrowserstackMobileDriver.class.getName();
    }

    @BeforeEach
    public void beforeEach() {
        open();
    }

    @AfterEach
    public void afterEach() {
        AllureAttachments.addScreenshotAs("Last screenshot");

        closeWebDriver();
        // ToDo enable get video
        //AllureAttachments.addBSVideo(sessionId);
    }
}
