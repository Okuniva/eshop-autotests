package alexheal.eshop.tests.mobile;

import alexheal.eshop.config.App;
import alexheal.eshop.models.FilterBrand;
import alexheal.eshop.models.FilterType;
import alexheal.eshop.pages.mobile.CatalogPage;
import alexheal.eshop.pages.mobile.FilterPage;
import alexheal.eshop.pages.mobile.LoginPage;
import org.junit.jupiter.api.Test;

public class FilterTest extends TestBase {
    @Test
    void filterByBrandAndTypeTest() {
        new LoginPage().authorization(App.config.userLogin(), App.config.userPassword());
        new CatalogPage().tapFilter();
        new FilterPage().setBrand(FilterBrand.Azure)
                .setType(FilterType.T_Shirt)
                .applyFilter();

        new CatalogPage().verifyItem("AZURE BLACK SWEATSHIRT (M)", "$19.50");
    }
}
