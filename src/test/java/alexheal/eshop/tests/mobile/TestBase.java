package alexheal.eshop.tests.mobile;

import alexheal.eshop.helpers.allure.AllureAttachments;
import alexheal.eshop.helpers.AndroidDriver;
import alexheal.eshop.helpers.allure.Layer;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit5.ScreenShooterExtension;
import io.qameta.allure.Epic;
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
@Tag("mobile")
@Feature("mobile")
@Layer("mobile")
public class TestBase {
    @BeforeAll
    public static void beforeAll() {
        addListener("AllureSelenide", new AllureSelenide());

        Configuration.browserSize = null;
        Configuration.browser = AndroidDriver.class.getName();
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
