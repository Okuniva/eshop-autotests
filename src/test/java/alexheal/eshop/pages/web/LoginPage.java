package alexheal.eshop.pages.web;

import alexheal.eshop.helpers.AllureAttachments;
import com.codeborne.selenide.SetValueOptions;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    @Step("authorization")
    public LoginPage authorization(String email, String password) {
        AllureAttachments.removeParameters();

        $("#Email").setValue(SetValueOptions.withText(email)
                .withDisplayedText(email.substring(0, 2) + "* - email"));
        $("#Password").setValue(SetValueOptions.withText(password).sensitive())
                .pressEnter();

        return this;
    }
}
