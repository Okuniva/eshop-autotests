package alexheal.eshop.pages;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.source;

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
