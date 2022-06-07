package alexheal.eshop.pages.mobile;

import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import static alexheal.eshop.helpers.DriverUtils.byTestId;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class CheckoutAlert {
    @Step("click 'Ok'")
    public CheckoutAlert tapOk() {
        $(AppiumBy.id("android:id/button2")).click();
        $(AppiumBy.id("eShopOnContainers.Droid:id/alertTitle"))
                .shouldNotBe(visible);

        return this;
    }

    public CheckoutAlert verifyOrderSuccess() {
        $(AppiumBy.id("eShopOnContainers.Droid:id/alertTitle")).shouldHave(
                text("Checkout"));
        $(AppiumBy.id(("android:id/message"))).shouldHave(
                text("Order sent successfully!"));

        return this;
    }
}
