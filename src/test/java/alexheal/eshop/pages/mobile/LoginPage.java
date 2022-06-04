package alexheal.eshop.pages.mobile;

import alexheal.eshop.helpers.AllureAttachments;
import com.codeborne.selenide.SetValueOptions;
import io.qameta.allure.Step;

import static alexheal.eshop.helpers.DriverUtils.byTestId;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    @Step("authorization")
    public LoginPage authorization(String email, String password) {
        AllureAttachments.removeParameters();

        $(byTestId("UserNameEntry")).setValue(SetValueOptions.withText(email)
                .withDisplayedText(email.substring(0, 2) + "* - email"));
        $(byTestId("PasswordEntry")).setValue(SetValueOptions.withText(password).sensitive());
        $(byTestId("LoginBtn")).click();

        return this;
    }
}
