package alexheal.eshop.pages.web;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class CheckoutPage {
    public CheckoutPage() {
        step("wait header size", () -> {
            $(".esh-app-header")
                    .shouldHave(cssValue("height", "208px"));
        });
    }

    @Step("click 'Place Order'")
    public CheckoutPage clickPlaceOrder() {
        $(byTagAndText("button", "Place Order"))
                .hover().click();

        return this;
    }
}
