package alexheal.eshop.tests.api;

import alexheal.eshop.models.catalog.Items;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static alexheal.eshop.tests.api.Specs.request;
import static alexheal.eshop.tests.api.Specs.successResponseSpec;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;

@Tag("api")
@Tag("catalog")
@Feature("api")
public class CatalogTests {
    @ParameterizedTest(name = "{displayName} [{argumentsWithNames}]")
    @Owner("ValeevAA")
    @Story("positive")
    @DisplayName("success get items")
    @Severity(SeverityLevel.CRITICAL)
    @CsvSource(value = {
            "10, 0, 14",
            "2147483647, 0, 14",
            "1, 0, 14",
            "10, 1, 14",
            "1, 1, 14",
            "2147483647, 2147483647, 14"
    })
    void successGetItemsTest(@Param("pageSize") int pageSize,
                             @Param("pageIndex") int pageIndex,
                             @Param("countResult") int countResult) {
        String instance = format("/Catalog/items?pageSize=%d&pageIndex=%d", pageSize, pageIndex);

        Items items = given()
                .spec(request)
                .when()
                .get(instance)
                .then()
                .spec(successResponseSpec)
                .body(matchesJsonSchemaInClasspath("schema/catalog/catalog_items.json"))
                .extract().as(Items.class);

        assertThat(items.pageSize).isEqualTo(pageSize);
        assertThat(items.pageIndex).isEqualTo(pageIndex);
        assertThat(items.count).isEqualTo(countResult);
        assertThat(items.data).isNotEmpty();
        assertThat(items.data.size()).isLessThanOrEqualTo(pageSize);
    }

    @ParameterizedTest(name = "{displayName} [{argumentsWithNames}]")
    @Owner("ValeevAA")
    @DisplayName("negative 500 server error")
    @Story("negative")
    @Severity(SeverityLevel.BLOCKER)
    @ValueSource(ints = {-Integer.MAX_VALUE, -100, -10, -1, 0})
    void negativeServerErrorTest(@Param("pageSize") int pageSize) {
        String instance = format("/Catalog/items?pageSize=%d", pageSize);

        given()
                .spec(request)
                .when()
                .get(instance)
                .then()
                .statusCode(500)
                .body("developerMessage.Message",
                        is("The number of rows provided for a FETCH clause must be greater then zero."));
    }

    @ParameterizedTest(name = "{displayName} [{argumentsWithNames}]")
    @Owner("ValeevAA")
    @DisplayName("negative page size param 400 error")
    @Story("negative")
    @Severity(SeverityLevel.NORMAL)
    @ValueSource(strings = {"null", "'", "й"})
    void negativePageSizeTest(@Param("pageSize") String pageSize) {
        String instance = format("/Catalog/items?pageSize=%s", pageSize);
        String errorText = format("The value '%s' is not valid.", pageSize);

        given()
                .spec(request)
                .when()
                .get(instance)
                .then()
                .statusCode(400)
                .body("errors.pageSize", hasItem(errorText),
                        "title", is("One or more validation errors occurred."));
    }

    @Test
    @Owner("ValeevAA")
    @DisplayName("negative empty page size param 400 error")
    @Story("negative")
    @Severity(SeverityLevel.MINOR)
    void negativeEmptyPageSizeTest() {
        String instance = format("/Catalog/items?pageSize=%s", "");
        String errorText = format("The value '%s' is invalid.", "");

        given()
                .spec(request)
                .when()
                .get(instance)
                .then()
                .statusCode(400)
                .body("errors.pageSize", hasItem(errorText),
                        "title", is("One or more validation errors occurred."));
    }

    // ToDo add tests for other params
}
