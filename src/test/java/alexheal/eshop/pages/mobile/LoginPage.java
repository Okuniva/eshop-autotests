package alexheal.eshop.pages.mobile;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static alexheal.eshop.helpers.DriverUtils.byTestId;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    @Step("authorization")
    public LoginPage authorization(String email, String password) {
//        $(byTestId("UserNameEntry")).setValue(email);
//        $(byTestId("PasswordEntry")).setValue(password);
        $(byTestId("LoginButton")).click();

        return this;
    }

    @Step("verify info label")
    public LoginPage verifyInfoLabel() {
        $(byTestId("InfoLabel")).as("Info label")
                .shouldHave(Condition.text("ARE YOU REGISTERED?"));

        return this;
    }
}
