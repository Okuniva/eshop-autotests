package alexheal.eshop.pages.mobile;

import alexheal.eshop.pages.web.HeaderSection;
import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import static alexheal.eshop.helpers.DriverUtils.byTestId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ProfilePage {
    @Step("click 'Logout'")
    public ProfilePage tapLogout() {
        $(byTestId("Logout")).click();

        return this;
    }
}
