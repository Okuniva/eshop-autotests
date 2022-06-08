package alexheal.eshop.tests.ui;

import alexheal.eshop.pages.web.HomePage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HomePageTests extends TestBase {
    @Test
    @DisplayName("page title should have header text")
    void titleTest() {
        new HomePage().openHomePage()
                .verifyTitle();
    }

    @Test
    @DisplayName("page console log should not have errors")
    void consoleShouldNotHaveErrorsTest() {
        new HomePage().openHomePage()
                .verifyConsoleLog();
    }
}
