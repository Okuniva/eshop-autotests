package alexheal.eshop.pages.mobile;

import alexheal.eshop.models.FilterBrand;
import alexheal.eshop.models.FilterType;
import io.qameta.allure.Step;

import static alexheal.eshop.helpers.DriverUtils.byTestId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class FilterPage {
    @Step("set filter brand - {brand}")
    public FilterPage setBrand(FilterBrand brand) {
        $(byTestId("BrandPicker_Container")).click();
        $x("//*[contains(@text, '" + brand.text + "')]").click();
        return this;
    }

    @Step("set filter type - {type}")
    public FilterPage setType(FilterType type) {
        $(byTestId("TypePicker_Container")).click();
        $x("//*[contains(@text, '" + type.text + "')]").click();
        return this;
    }

    @Step("apply filter")
    public FilterPage applyFilter() {
        $(byTestId("ApplyButton")).click();
        return this;
    }

    @Step("clear filter")
    public FilterPage clearFilter() {
        $(byTestId("ClearButton")).click();
        return this;
    }
}
