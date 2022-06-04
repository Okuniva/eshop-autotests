package alexheal.eshop.pages.mobile;

import alexheal.eshop.helpers.AllureAttachments;
import com.codeborne.selenide.SetValueOptions;
import io.qameta.allure.Step;

import static alexheal.eshop.helpers.DriverUtils.byTestId;
import static com.codeborne.selenide.Selenide.$;

public class CatalogPage {
    @Step("click 'Profile'")
    public CatalogPage tapProfile() {
        $(byTestId("PROFILE")).click();

        return this;
    }
}
