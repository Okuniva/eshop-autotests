package alexheal.eshop.tests.web;

import alexheal.eshop.config.App;
import alexheal.eshop.pages.web.HeaderSection;
import alexheal.eshop.pages.web.HomePage;
import alexheal.eshop.pages.web.LoginPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("auth")
@Feature("auth")
public class AuthTests extends TestBase {
    @Test
    @Owner("ValeevAA")
    @Story("success auth")
    @Description("verify authorization user should have username in header")
    @DisplayName("success authorization demo user test")
    @Severity(SeverityLevel.CRITICAL)
    void successAuthorizationDemoUserTest() {
        new HomePage().openHomePage();

        new HeaderSection().verifyUsername("LOGIN")
                .clickLogin();

        new LoginPage().authorization(App.config.userLogin(), App.config.userPassword());

        new HeaderSection().verifyUsername(App.config.userLogin());
    }
}
