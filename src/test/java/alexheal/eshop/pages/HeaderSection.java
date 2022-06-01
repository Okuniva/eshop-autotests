package alexheal.eshop.pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class HeaderSection {
    @Step("click 'Login'")
    public HeaderSection clickLogin() {
        $(".esh-identity-name").click();

        return this;
    }

    public HeaderSection verifyUsername(String username) {
        $(".esh-identity-name").as("username")
                .shouldHave(Condition.exactTextCaseSensitive(username));

        return this;
    }

    @Step("click 'Basket'")
    public HeaderSection clickBasket() {
        $(".esh-basketstatus-image").click();

        return this;
    }
}
