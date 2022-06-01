package alexheal.eshop.tests.ui;

import alexheal.eshop.pages.HomePage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HomePageTests extends TestBase {
    @Test
    @DisplayName("Page title should have header text")
    void titleTest() {
        new HomePage().openHomePage()
                .verifyTitle();
    }

    @Test
    @DisplayName("Page console log should not have errors")
    void consoleShouldNotHaveErrorsTest() {
        new HomePage().openHomePage()
                .verifyConsoleLog();
    }
}
