package CreateRequest;

import groovy.util.logging.Slf4j;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import utils.reqSpecification.REQ_SPEC;
import utils.resSpecification.RES_SPEC;

import java.util.concurrent.TimeUnit;

import static Routes.RouteCartEndPoint.allCarts;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

@Slf4j
public class AllCartsRequests implements REQ_SPEC, RES_SPEC {

    /**
     * This method tests all carts by sending a GET request to the specified endpoint.
     * It asserts that the response time is less than 3 seconds and the status code is 200.
     *
     * @return The response object.
     */
    @Tags({@Tag("Carts"), @Tag("SanityTest")})
    @DisplayName("assert items in cart")
    public Response testAllCarts() {
        Response response = given()
                .spec(getRequestSpec())
                .when()
                .get(allCarts);
        response.then().spec(getResponseSpec());
        response.then().time(lessThan(3L), TimeUnit.SECONDS);
        response.then().statusCode(200);

        return response;
    }
}
