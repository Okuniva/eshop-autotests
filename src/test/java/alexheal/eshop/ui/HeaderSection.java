package alexheal.eshop.ui;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class HeaderSection {
    public SelenideElement userName = $(".esh-identity-name");

    @Step("click 'Login'")
    public HeaderSection clickLogin() {
        $(byText("LOGIN")).click();

        return this;
    }
}
