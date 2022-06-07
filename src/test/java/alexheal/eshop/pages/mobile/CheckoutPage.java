package alexheal.eshop.pages.mobile;

import io.qameta.allure.Step;

import static alexheal.eshop.helpers.DriverUtils.byTestId;
import static com.codeborne.selenide.Selenide.$;

public class CheckoutPage {
    @Step("click 'Place Order'")
    public CheckoutPage tapPlaceOrder() {
        $(byTestId("PlaceOrderButton")).click();

        return this;
    }
}
