package CreateRequest;

import groovy.util.logging.Slf4j;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import utils.CONSTANTS.JSON_SCHEMAS;
import utils.reqSpecification.REQ_SPEC;
import utils.resSpecification.RES_SPEC;

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
public class AllCartRequests implements REQ_SPEC, RES_SPEC, JSON_SCHEMAS {
    /**
     * This method tests all carts by sending a GET request to the specified endpoint.
     * It asserts that the response time is less than 3 seconds and the status code is 200.
     *
     * @return The response object.
     */
    @Tags({@Tag("Carts"), @Tag("ALL_CARTS")})
    @DisplayName("Display all carts and products")
    public Response testAllCarts() {
        Response response = given()
                .spec(getRequestSpec())
                .when()
                .get(allCarts);
        response.then().spec(getResponseSpec());
        response.then().time(lessThan(3L), TimeUnit.SECONDS);
        response.then().statusCode(200);
        response.then().body(ALL_CARTS_SCHEMA);

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
        response.then().time(lessThan(3L), TimeUnit.SECONDS);
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
        response.then().time(lessThan(3L), TimeUnit.SECONDS);
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