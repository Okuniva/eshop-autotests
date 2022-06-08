package alexheal.eshop.tests.web;

import alexheal.eshop.models.FilterBrand;
import alexheal.eshop.models.FilterType;
import alexheal.eshop.pages.web.HomePage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class FilterTests extends TestBase {
    @Test
    @DisplayName("verify filter no results find message")
    void emptyResultTest() {
        new HomePage().openHomePage()
                .setBrand(FilterBrand.Azure)
                .applyFilter()
                .verifyNoResultsFindMessage();
    }

    @Test
    @DisplayName("verify filter by brand")
    void filterByBrandTest() {
        new HomePage().openHomePage()
                .setBrand(FilterBrand.Other)
                .applyFilter()
                .verifyShowingMessage(8, 8, 1, 1);
    }

    @Test
    @DisplayName("verify filter by type")
    @Tag("web_filter")
    void filterByTypeTest() {
        new HomePage().openHomePage()
                .setType(FilterType.Pin)
                .applyFilter()
                .verifyShowingMessage(7, 7, 1, 1);
    }
}
