package alexheal.eshop.pages;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;

public class BasketPage {
    public BasketPage() {
        $(".esh-app-header")
                .shouldHave(cssValue("height", "208px"));
        $(byTagAndText("h1", "[ Shopping Bag ]"))
                .shouldBe(visible);
    }

    @Step("click 'Checkout'")
    public BasketPage clickCheckout() {
        $(byTagAndText("button", "Checkout"))
                .hover().click(ClickOptions.usingDefaultMethod());

        return this;
    }

    public BasketPage verifyItems(int count, String price) {
        SelenideElement checkoutInfo = $(".esh-basket-checkout").as("checkoutInfo");
        checkoutInfo.shouldHave(Condition.text("(" + count + " items)"));
        checkoutInfo.shouldHave(Condition.text(price));

        return this;
    }
}
