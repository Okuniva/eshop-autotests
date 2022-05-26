package alexheal.eshop.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    @Step("authorization by {email} and {password}")
    public LoginPage authorization(String email, String password) {
        $("#Email").val(email);
        $("#Password").val(password).pressEnter();

        return this;
    }
}
