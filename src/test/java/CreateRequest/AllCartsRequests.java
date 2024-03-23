package CreateRequest;

import groovy.util.logging.Slf4j;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import utils.reqSpecification.REQ_SPEC;
import utils.resSpecification.RES_SPEC;

import static Routes.RouteCartEndPoint.allCarts;
import static io.restassured.RestAssured.given;

@Slf4j
public class AllCartsRequests implements REQ_SPEC, RES_SPEC {

    @Tags({@Tag("Carts"), @Tag("SanityTest")})
    @DisplayName("assert items in cart")
    public Response testAllCarts() {
        Response response = given()
                .spec(getRequestSpec())
                .when()
                .get(allCarts);
        response.then().spec(getResponseSpec());
        response.then().statusCode(200);
        return response;
    }
}
