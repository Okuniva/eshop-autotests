package alexheal.eshop.tests.api;

import org.junit.jupiter.api.Test;

import static alexheal.eshop.tests.api.Specs.request;
import static alexheal.eshop.tests.api.Specs.responseSpec;
import static io.restassured.RestAssured.given;

public class CatalogTests {
    @Test
    void getItemsTest() {
        given()
                .spec(request)
                .when()
                .get("/Catalog/items?pageSize=10&pageIndex=0")
                .then()
                .spec(responseSpec);
    }
}
