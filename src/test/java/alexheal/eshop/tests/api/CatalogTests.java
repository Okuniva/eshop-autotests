package alexheal.eshop.tests.api;

import alexheal.eshop.models.api.catalog.Items;
import org.junit.jupiter.api.Test;

import static alexheal.eshop.tests.api.Specs.request;
import static alexheal.eshop.tests.api.Specs.responseSpec;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class CatalogTests {
    @Test
    void getItemsTest() {
        Items items = given()
                .spec(request)
                .when()
                .get("/Catalog/items?pageSize=10&pageIndex=0")
                .then()
                .spec(responseSpec)
                .extract().as(Items.class);

        assertThat(items.count).isEqualTo(14);
    }
}
