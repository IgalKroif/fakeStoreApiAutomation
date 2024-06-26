package CreateRequest.cart;

import groovy.util.logging.Slf4j;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import net.datafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.testng.annotations.Optional;
import utils.CONSTANTS.JSON_SCHEMAS;
import utils.reqSpecification.REQ_SPEC;
import utils.resSpecification.RES_SPEC;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static Routes.RouteCartEndPoint.allCarts;
import static Routes.RouteCartEndPoint.cartById;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static utils.validation.Header.validateHeaders.validateHeaderResponseData;
import static utils.populateCsvData.InjectData.populateInvalidIds;
import static utils.populateCsvData.InjectData.populateValidIds;

@Slf4j
public class GetCartRequest implements REQ_SPEC, RES_SPEC, JSON_SCHEMAS {
    Map<String, Object> mapQueryParams = new HashMap<>();
    public static Faker faker = new Faker();
    public static String byAsc = "asc" , byDesc = "desc";

    /**
     * This method tests all carts by sending a GET request to the specified endpoint.
     * It asserts that the response time is less than 3 seconds and the status code is 200.
     *
     * @return The response object.
     */
    @Tags({@Tag("Carts"), @Tag("ALL_CARTS")})
    @DisplayName("Display all carts and products")
    @Step
    public Response testAllCarts() {
        Response response = given()
                .spec(getRequestSpec())
                .when()
                .get(allCarts);
        response.then().spec(getResponseSpec());
        response.then().time(lessThan(5L), TimeUnit.SECONDS);
        response.then().statusCode(200);
        response.then().body(ALL_CARTS_SCHEMA);

        return response;
    }

    @Tags({@Tag("Carts"), @Tag("ALL_CARTS")})
    @DisplayName("Display all carts and products using sort and limit")
    public Response testAllCarts(@Optional String sort, @Optional int limit) {
        mapQueryParams.put("sort", sort);
        mapQueryParams.put("limit", limit);
        Response response = given()
                .spec(getRequestSpec())
                .queryParams(mapQueryParams)
                .when()
                .get(allCarts);
        response.then().spec(getResponseSpec());
        response.then().time(lessThan(5L), TimeUnit.SECONDS);
        response.then().statusCode(200);
        response.then().body(ALL_CARTS_SCHEMA);

        return response;
    }
    public static String expectedErrorMessage = "date format is not correct. it should be in yyyy-mm-dd format";
    @Tags({@Tag("Carts"), @Tag("ALL_CARTS")})
    @DisplayName("Display all carts and products using start and end dates format YYYY-MM-DD")
    public Response testAllCarts(@Optional String startDate, @Optional String endDate) {

        mapQueryParams.put("startdate", startDate);
        mapQueryParams.put("enddate", endDate);
        Response response = given()
                .spec(getRequestSpec())
                .queryParams(mapQueryParams)
                .when()
                .get(allCarts);

        response.then().spec(getResponseSpec());
        response.then().time(lessThan(5L), TimeUnit.SECONDS);
        response.then().body(ALL_CARTS_SCHEMA);

        assertThat(startDate, matchesRegex("\\d{4}-\\d{2}-\\d{2}"));
        assertThat(endDate, matchesRegex("\\d{4}-\\d{2}-\\d{2}"));

        return response;
    }


    /**
     * Retrieves a specific cart with products using the provided ID.
     *
     * @param  id  the ID of the cart to retrieve
     * @return     the response containing the specific cart with products
     */
    @Tags({@Tag("Carts"), @Tag("SINGLE_CART")})
    @DisplayName("Display specific cart with products")
    public Response testSpecificCart(int id) {
        Response response = given()
                .pathParams("id", populateValidIds(id))
                .spec(getRequestSpec())
                .when()
                .get(cartById);
        response.then().spec(getResponseSpec());
        response.then().time(lessThan(5L), TimeUnit.SECONDS);
        response.then().statusCode(200);
        response.then().body(SINGLE_CART_SCHEMA);
        validateHeaderResponseData(response);
        return response;
    }
    public Response testInvalidSpecificCart(Object id) {
        Response response = given()
                .pathParams("id", populateInvalidIds(id))
                .spec(getRequestSpec())
                .when()
                .get(cartById);
        response.then().time(lessThan(5L), TimeUnit.SECONDS);
        response.then().log().status().and().statusCode(is(oneOf(200,400)));
        response.then().log().headers();
        var statusCode = response.getStatusCode();
        if (statusCode == 200) {
            var responseBody = response.getBody().asPrettyString();
            assertThat(responseBody, is(nullValue().toString()));
            System.out.println("ResponseBody is: " + responseBody + " As expected because of invalid ID: " + id);
        }
        return response;
    }
}