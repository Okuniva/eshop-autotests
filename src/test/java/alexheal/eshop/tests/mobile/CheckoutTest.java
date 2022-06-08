package alexheal.eshop.tests.mobile;

import alexheal.eshop.config.App;
import alexheal.eshop.pages.mobile.BasketPage;
import alexheal.eshop.pages.mobile.CatalogPage;
import alexheal.eshop.pages.mobile.LoginPage;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;

public class CheckoutTest extends TestBase {
    @Test
    @Owner("ValeevAA")
    @Severity(SeverityLevel.CRITICAL)
    void deleteItemsTest() {
        new LoginPage().authorization(App.config.userLogin(), App.config.userPassword());
        new CatalogPage().tapCart();
        new BasketPage().deleteItem(1)
                .deleteItem(1)
                .verifyTotalHeader("$0.00");
    }
}
