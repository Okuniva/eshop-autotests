package alexheal.eshop.tests.web;

import alexheal.eshop.pages.web.HomePage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("home")
@Story("home")
public class HomePageTests extends TestBase {
    @Test
    @Owner("ValeevAA")
    @DisplayName("page title should have header text")
    @Severity(SeverityLevel.NORMAL)
    void titleTest() {
        new HomePage().openHomePage()
                .verifyTitle();
    }

    @Test
    @Owner("ValeevAA")
    @DisplayName("page console log should not have errors")
    @Severity(SeverityLevel.NORMAL)
    void consoleShouldNotHaveErrorsTest() {
        new HomePage().openHomePage()
                .verifyConsoleLog();
    }
}
