package alexheal.eshop.tests.mobile;

import alexheal.eshop.config.App;
import alexheal.eshop.pages.mobile.CatalogPage;
import alexheal.eshop.pages.mobile.LoginPage;
import alexheal.eshop.pages.mobile.ProfilePage;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

@Story("auth")
public class AuthTest extends TestBase {
    @Test
    @Owner("ValeevAA")
    @Severity(SeverityLevel.CRITICAL)
    void successAuthorizationTest() {
        new LoginPage().authorization(App.config.userLogin(), App.config.userPassword());
        new CatalogPage().tapProfile();
        new ProfilePage().tapLogout();

        new LoginPage().verifyInfoLabel();
    }
}
