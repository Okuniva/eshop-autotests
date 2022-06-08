package alexheal.eshop.tests.mobile;

import alexheal.eshop.config.App;
import alexheal.eshop.pages.mobile.*;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Test;

public class OrderTest extends TestBase {
    @Test
    @Owner("ValeevAA")
    void orderTest() {
        new LoginPage().authorization(App.config.userLogin(), App.config.userPassword());
        new CatalogPage().tapCart();
        new BasketPage().verifyTotalHeader("$36.50")
                .tapCheckout();
        // ToDo verify Order Info
        new CheckoutPage().tapPlaceOrder();
        new CheckoutAlert().verifyOrderSuccess()
                .tapOk();
    }
}
