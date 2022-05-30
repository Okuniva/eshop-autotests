package alexheal.eshop.pages;

import alexheal.eshop.config.App;
import alexheal.eshop.helpers.DriverUtils;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

public class HomePage {
    @Step("open HomePage")
    public HomePage openHomePage() {
        open(App.config.webUrl());

        return this;
    }

    @Step("page title should have text 'eShopOnContainers - SPA'")
    public HomePage verifyTitle() {
        String expectedTitle = "eShopOnContainers - SPA";
        String actualTitle = title();

        assertThat(actualTitle).isEqualTo(expectedTitle);

        return this;
    }

    @Step("console logs should not contain text 'SEVERE'")
    public HomePage verifyConsoleLog() {
        String consoleLogs = DriverUtils.getConsoleLogs();
        String errorText = "SEVERE";

        assertThat(consoleLogs).doesNotContain(errorText);

        return this;
    }

    @Step("add item {index} to basket")
    public HomePage addItemToBasket(int index) {
        $$(".esh-catalog-item").get(index).hover().click();

        return this;
    }
}
