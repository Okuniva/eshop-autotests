package alexheal.eshop.tests.api;

import alexheal.eshop.models.api.catalog.Items;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static alexheal.eshop.tests.api.Specs.request;
import static alexheal.eshop.tests.api.Specs.successResponseSpec;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class CatalogTests {
    @ParameterizedTest
    @CsvSource(value = {
            "10, 0, 14",
            "2147483647, 0, 14",
            "1, 0, 14",
            "10, 1, 14",
            "1, 1, 14",
            "2147483647, 2147483647, 14"
    })
    void successGetItemsTest(int pageSize, int pageIndex, int countResult) {
        String endPoint = String.format("/Catalog/items?pageSize=%d&pageIndex=%d", pageSize, pageIndex);

        Items items = given()
                .spec(request)
                .when()
                .get(endPoint)
                .then()
                .spec(successResponseSpec)
                .extract().as(Items.class);

        assertThat(items.pageSize).isEqualTo(pageSize);
        assertThat(items.pageIndex).isEqualTo(pageIndex);
        assertThat(items.count).isEqualTo(countResult);
        assertThat(items.data).isNotEmpty();
        assertThat(items.data.size()).isLessThanOrEqualTo(pageSize);
    }

}
