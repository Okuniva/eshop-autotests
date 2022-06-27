package alexheal.eshop.pages.web;

import alexheal.eshop.config.App;
import alexheal.eshop.helpers.DriverUtils;
import alexheal.eshop.models.FilterBrand;
import alexheal.eshop.models.FilterType;
import com.codeborne.selenide.ClickOptions;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

public class HomePage {
    @Step("open HomePage")
    public HomePage openHomePage() {
        open(App.config.webUrl());
        $(".esh-app-header")
                .shouldHave(cssValue("height", "464px"));
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

    @Step("set filter brand - {brand}")
    public HomePage setBrand(FilterBrand brand) {
        $("#brand").selectOptionByValue(brand.value);
        return this;
    }

    @Step("set filter type - {type}")
    public HomePage setType(FilterType type) {
        $("#type").selectOptionByValue(type.value);
        return this;
    }

    @Step("apply filter")
    public HomePage applyFilter() {
        $(byTagAndText("button", "Apply"))
                .hover().click(ClickOptions.usingDefaultMethod());
        return this;
    }

    @Step("verify showing message")
    public HomePage verifyShowingMessage(int showingProducts, int allProducts, int currentPage, int allPages) {
        $(byTagAndText("span", String.format("Showing %d of %d products - Page %d - %d",
                showingProducts, allProducts, currentPage, allPages)))
                .shouldBe(visible);
        return this;
    }

    @Step("verify username - {username}")
    public HomePage verifyNoResultsFindMessage() {
        $(byTagAndText("span", "THERE ARE NO RESULTS THAT MATCH YOUR SEARCH"))
                .shouldBe(visible);
        return this;
    }


}
