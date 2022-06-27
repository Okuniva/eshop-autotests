package alexheal.eshop.pages.mobile;

import io.qameta.allure.Step;

import static alexheal.eshop.helpers.DriverUtils.byTestId;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CatalogPage {
    @Step("click 'Profile'")
    public CatalogPage tapProfile() {
        $(byTestId("PROFILE")).click();
        return this;
    }

    @Step("click 'Filter'")
    public CatalogPage tapFilter() {
        $(byTestId("FilterIcon")).click();
        return this;
    }

    @Step("click 'ShoppingCart'")
    public CatalogPage tapCart() {
        $(byTestId("ShoppingCart")).click();
        return this;
    }

    @Step("verify name - {name} and price - {price}")
    public CatalogPage verifyItem(String name, String price) {
        $(byTestId("ProductName")).shouldHave(text(name));
        $(byTestId("ProductPrice")).shouldHave(text(price));
        return this;
    }

    @Step("verify no products found")
    public CatalogPage verifyNoProductsFound() {
        $(byTestId("NoProductsFoundLabel")).shouldHave(
                text("NO PRODUCTS FOUND"));
        return this;
    }
}
