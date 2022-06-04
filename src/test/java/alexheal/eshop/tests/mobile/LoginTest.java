package alexheal.eshop.tests.mobile;

import alexheal.eshop.config.App;
import alexheal.eshop.pages.mobile.CatalogPage;
import alexheal.eshop.pages.mobile.LoginPage;
import org.junit.jupiter.api.Test;

public class LoginTest extends TestBase {
    @Test
    void loginTest() {
        new LoginPage().authorization(App.config.userLogin(), App.config.userPassword());
        new CatalogPage().tapProfile();
    }
}
