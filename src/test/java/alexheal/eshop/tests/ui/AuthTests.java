package alexheal.eshop.tests.ui;

import alexheal.eshop.config.App;
import alexheal.eshop.pages.HeaderSection;
import alexheal.eshop.pages.HomePage;
import alexheal.eshop.pages.LoginPage;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AuthTests extends TestBase {
    @Test
    @Description("verify authorization user should have username in header")
    @DisplayName("success authorization demo user test")
    void successAuthorizationDemoUserTest() {
        new HomePage().openHomePage();
        assertThat(true).isFalse();

        new HeaderSection().verifyUsername("LOGIN");

        new HeaderSection().clickLogin();

        new LoginPage().authorization(App.config.userLogin(), App.config.userPassword());

        new HeaderSection().verifyUsername(App.config.userLogin());
    }
}
