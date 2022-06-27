package alexheal.eshop.pages.mobile;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Step;
import org.openqa.selenium.interactions.Coordinates;

import java.time.Duration;

import static alexheal.eshop.helpers.DriverUtils.byTestId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class BasketPage {
    @Step("click 'Checkout'")
    public BasketPage tapCheckout() {
        $(byTestId("CheckoutButton")).click();
        return this;
    }

    @Step("delete item index - {index}")
    public BasketPage deleteItem(int index) {
        Coordinates totalCoordinates = $x("(//*[@content-desc='TotalLabel'])[" + index + "]").getCoordinates();
        Coordinates priceCoordinates = $x("(//*[@content-desc='PriceLabel'])[" + index + "]").getCoordinates();

        new TouchAction((PerformsTouchActions) WebDriverRunner.getWebDriver())
                .press(PointOption.point(totalCoordinates.onPage()))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
                .moveTo(PointOption.point(priceCoordinates.onPage()))
                .release()
                .perform();

        $(byTestId("DeleteButton")).click();
        return this;
    }

    @Step("verify total header shouldHave {price}")
    public BasketPage verifyTotalHeader(String price) {
        $(byTestId("ListTotalHeaderLabel")).shouldHave(
                Condition.text(price));
        return this;
    }
}
