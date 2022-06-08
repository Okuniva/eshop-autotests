package alexheal.eshop.tests.api;

import alexheal.eshop.config.App;
import alexheal.eshop.helpers.AllureRestAssuredFilter;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;

public class Specs {
    public static RequestSpecification request = with()
            .filter(AllureRestAssuredFilter.withCustomTemplates())
            .baseUri(App.config.apiUrl())
            .basePath("/catalog-api/api/v1")
            .log().all();
//            .contentType(ContentType.JSON);

    public static ResponseSpecification successResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .build();
}
