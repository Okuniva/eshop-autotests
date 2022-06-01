package alexheal.eshop.tests.ui;

import alexheal.eshop.config.App;
import alexheal.eshop.pages.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderTests extends TestBase {
    @Test
    @DisplayName("verify text in order toasts")
    void orderTest() {
        // ToDo add api request to blear basket
        new HomePage().openHomePage();
        new HeaderSection().clickLogin();
        new LoginPage().authorization(App.config.userLogin(), App.config.userPassword());

        new HomePage().addItemToBasket(0);
        new HeaderSection().clickBasket();

        new BasketPage()
                .verifyItems(1, "$8.50")
                .clickCheckout();
        // ToDo add verify shadow CSS
        new CheckoutPage()
                .clickPlaceOrder();
        // ToDo add verify order table
        new OrdersPage()
                .verifyToastText("Updated to status: Submitted")
                .verifyToastText("Updated to status: AwaitingStockValidation")
                .verifyToastText("Updated to status: Validated")
                .verifyToastText("Updated to status: Paid");
    }
}
