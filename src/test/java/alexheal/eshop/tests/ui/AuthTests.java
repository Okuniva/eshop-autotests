package alexheal.eshop.tests.ui;

import alexheal.eshop.config.App;
import alexheal.eshop.pages.web.HeaderSection;
import alexheal.eshop.pages.web.HomePage;
import alexheal.eshop.pages.web.LoginPage;
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

        new HeaderSection().verifyUsername("LOGIN")
                .clickLogin();

        new LoginPage().authorization(App.config.userLogin(), App.config.userPassword());

        new HeaderSection().verifyUsername(App.config.userLogin());
    }
}
