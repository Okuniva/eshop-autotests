package alexheal.eshop.tests.mobile;

import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static alexheal.eshop.helpers.DriverUtils.byTestId;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class LoginTest extends TestBase {
    @Test
    void loginTest() {
        $(byTestId("UserNameEntry")).setValue("123");
        $(byTestId("PasswordEntry")).setValue("123");
        $(byTestId("LoginBtn")).click();
        $(byTestId("PROFILE")).shouldBe(Condition.visible);
    }
}
