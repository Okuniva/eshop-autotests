package alexheal.eshop.tests.mobile;

import alexheal.eshop.config.App;
import alexheal.eshop.pages.mobile.CatalogPage;
import alexheal.eshop.pages.mobile.LoginPage;
import alexheal.eshop.pages.mobile.ProfilePage;
import org.junit.jupiter.api.Test;

public class AuthTest extends TestBase {
    @Test
    void successAuthorizationDemoUserTest() {
        new LoginPage().authorization(App.config.userLogin(), App.config.userPassword());
        new CatalogPage().tapProfile();
        new ProfilePage().tapLogout();

        new LoginPage().verifyInfoLabel();
    }
}
