package alexheal.eshop.tests.api;

import alexheal.eshop.config.App;
import alexheal.eshop.helpers.allure.AllureRestAssuredFilter;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;

public class Specs {
    public static RequestSpecification request = with()
            .filter(AllureRestAssuredFilter.withCustomTemplates())
            .basePath("/catalog-api/api/v1")
            .log().all();

    public static ResponseSpecification successResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .build();
}
