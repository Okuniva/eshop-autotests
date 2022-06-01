package alexheal.eshop.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;

public class CheckoutPage {
    public CheckoutPage() {
        $(".esh-app-header")
                .shouldHave(cssValue("height", "208px"));
    }

    @Step("click 'Place Order'")
    public CheckoutPage clickPlaceOrder() {
        $(byTagAndText("button", "Place Order"))
                .hover().click();

        return this;
    }
}
