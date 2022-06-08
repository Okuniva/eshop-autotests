package alexheal.eshop.tests.web;

import alexheal.eshop.models.FilterBrand;
import alexheal.eshop.models.FilterType;
import alexheal.eshop.pages.web.HomePage;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("filter")
public class FilterTests extends TestBase {
    @Test
    @Owner("ValeevAA")
    @DisplayName("verify filter no results find message")
    void emptyResultTest() {
        new HomePage().openHomePage()
                .setBrand(FilterBrand.Azure)
                .applyFilter()
                .verifyNoResultsFindMessage();
    }

    @Test
    @Owner("ValeevAA")
    @DisplayName("verify filter by brand")
    void filterByBrandTest() {
        new HomePage().openHomePage()
                .setBrand(FilterBrand.Other)
                .applyFilter()
                .verifyShowingMessage(8, 8, 1, 1);
    }

    @Test
    @Owner("ValeevAA")
    @DisplayName("verify filter by type")
    void filterByTypeTest() {
        new HomePage().openHomePage()
                .setType(FilterType.Pin)
                .applyFilter()
                .verifyShowingMessage(7, 7, 1, 1);
    }
}
