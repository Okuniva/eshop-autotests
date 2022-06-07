package alexheal.eshop.pages.mobile;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static alexheal.eshop.helpers.DriverUtils.byTestId;
import static com.codeborne.selenide.Selenide.$;

public class BasketPage {
    @Step("click 'Checkout'")
    public BasketPage tapCheckout() {
        $(byTestId("CheckoutButton")).click();

        return this;
    }

    public BasketPage verifyTotalHeader(String price) {
        $(byTestId("ListTotalHeaderLabel")).shouldHave(
                Condition.text(price));

        return this;
    }
}
