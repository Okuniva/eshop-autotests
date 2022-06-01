package alexheal.eshop.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static java.time.Duration.ofSeconds;

public class OrdersPage {
    public OrdersPage verifyToastText(String expectedToast) {
        $("#toast-container").as("toast")
                .shouldHave(text(expectedToast), ofSeconds(60));
        return this;
    }
}
