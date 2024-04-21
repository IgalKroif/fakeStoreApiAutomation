package CreateRequest.product;

import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import utils.CONSTANTS.JSON_SCHEMAS;

import java.util.concurrent.TimeUnit;

import static Routes.RouteProductsEndpoint.allProducts;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;
import static utils.reqSpecification.SpecifyRequest.getRequestSpec;
import static utils.resSpecification.SpecifyResponse.getResponseSpec;

public class GetProductRequest implements JSON_SCHEMAS {
    @Tags({@Tag("Carts"), @Tag("ALL_CARTS")})
    @DisplayName("Display all carts and products")
    public Response requestAllProducts() {
        Response response = given()
                .spec(getRequestSpec())
                .when()
                .get(allProducts);
        response.then().spec(getResponseSpec());
        response.then().time(lessThan(3L), TimeUnit.SECONDS);
        response.then().statusCode(200);
        response.then().body(ALL_PRODUCTS_SCHEMA);

        return response;
    }
}