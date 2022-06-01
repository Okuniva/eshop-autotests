package alexheal.eshop.tests.ui;

import alexheal.eshop.models.Brand;
import alexheal.eshop.pages.HomePage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FilterTests extends TestBase {
    @Test
    @DisplayName("verify filter no results find message")
    void emptyResultTest() {
        new HomePage().openHomePage()
                .setBrand(Brand.Azure)
                .applyFilter()
                .verifyNoResultsFindMessage();
    }
}
