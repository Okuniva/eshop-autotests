package alexheal.eshop.tests.mobile;

import alexheal.eshop.config.App;
import alexheal.eshop.pages.mobile.BasketPage;
import alexheal.eshop.pages.mobile.CatalogPage;
import alexheal.eshop.pages.mobile.LoginPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;

@Feature("checkout")
public class CheckoutTest extends TestBase {
    @Test
    @Owner("ValeevAA")
    @Story("delete items")
    @Severity(SeverityLevel.CRITICAL)
    void deleteItemsTest() {
        new LoginPage().authorization(App.config.userLogin(), App.config.userPassword());
        new CatalogPage().tapCart();
        new BasketPage().deleteItem(1)
                .deleteItem(1)
                .verifyTotalHeader("$0.00");
    }
}
