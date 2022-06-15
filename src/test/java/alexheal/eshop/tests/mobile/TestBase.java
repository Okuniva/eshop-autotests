package alexheal.eshop.tests.mobile;

import alexheal.eshop.drivers.BrowserstackMobileDriver;
import alexheal.eshop.helpers.allure.AllureAttachments;
import alexheal.eshop.helpers.allure.Layer;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit5.ScreenShooterExtension;
import io.qameta.allure.Feature;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

@ExtendWith({ScreenShooterExtension.class})
@Feature("mobile")
@Layer("mobile")
@Tag("mobile")
public class TestBase {
    @BeforeAll
    public static void beforeAll() {
        addListener("AllureSelenide", new AllureSelenide());

        Configuration.browser = BrowserstackMobileDriver.class.getName();
        Configuration.browserSize = null;
    }

    @BeforeEach
    public void beforeEach() {
        open();
    }

    @AfterEach
    public void afterEach() {
        AllureAttachments.addScreenshotAs("Last screenshot");

        closeWebDriver();
    }
}
