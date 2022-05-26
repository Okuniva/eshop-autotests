package alexheal.eshop.tests;

import alexheal.eshop.config.App;
import alexheal.eshop.ui.HeaderSection;
import alexheal.eshop.ui.HomePage;
import alexheal.eshop.ui.LoginPage;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AuthTests extends TestBase {
    @Test
    @Description("verify authorization user should have username in header")
    @DisplayName("success authorization demo user test")
    void successAuthorizationDemoUserTest() {
        new HomePage().openHomePage();
        new HeaderSection().clickLogin();
        new LoginPage().authorization(App.config.userLogin(), App.config.userPassword());

        new HeaderSection().userName.shouldHave(Condition.exactTextCaseSensitive(App.config.userLogin()));
    }
}
