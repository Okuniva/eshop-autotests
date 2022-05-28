package alexheal.eshop.pages;

import alexheal.eshop.config.App;
import alexheal.eshop.helpers.DriverUtils;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
import static org.assertj.core.api.Assertions.assertThat;

public class HomePage {
    @Step("open HomePage")
    public HomePage openHomePage() {
        open(App.config.webUrl());

        return this;
    }

    @Step("Page title should have text 'eShopOnContainers - SPA'")
    public HomePage verifyTitle() {
        String expectedTitle = "eShopOnContainers - SPA";
        String actualTitle = title();

        assertThat(actualTitle).isEqualTo(expectedTitle);

        return this;
    }

    @Step("Console logs should not contain text 'SEVERE'")
    public HomePage verifyConsoleLog() {
        String consoleLogs = DriverUtils.getConsoleLogs();
        String errorText = "SEVERE";

        assertThat(consoleLogs).doesNotContain(errorText);

        return this;
    }
}
