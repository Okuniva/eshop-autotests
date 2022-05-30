package alexheal.eshop.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.withTextCaseInsensitive;
import static com.codeborne.selenide.Selenide.$;

public class BasketPage {
    @Step("click 'Checkout'")
    public BasketPage clickCheckout() {
        $(byTagAndText("button", "Checkout")).hover().click();

        return this;
    }

    public BasketPage verifyItems(int count, String price) {
        SelenideElement checkoutInfo = $(".esh-basket-checkout");
        checkoutInfo.shouldHave(Condition.text("(" + count + " items)"));
        checkoutInfo.shouldHave(Condition.text(price));

        return this;
    }
}
