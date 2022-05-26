package alexheal.eshop.ui;

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
        $(".esh-identity-name").shouldHave(Condition.exactTextCaseSensitive(username));

        return this;
    }
}
