package alexheal.eshop.tests.web;

import alexheal.eshop.config.App;
import alexheal.eshop.pages.web.*;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("order")
@Story("order")
public class OrderTests extends TestBase {
    @Test
    @AllureId("10541")
    @Owner("ValeevAA")
    @DisplayName("verify text in order toasts")
    @Severity(SeverityLevel.CRITICAL)
    void orderTest() {
        // ToDo add api request to clear basket
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
