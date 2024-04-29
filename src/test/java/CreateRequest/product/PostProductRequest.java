package CreateRequest.product;

import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import utils.CONSTANTS.JSON_SCHEMAS;
import utils.pojo.product.Products;
import java.util.concurrent.TimeUnit;

import static Routes.RouteProductsEndpoint.allProducts;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;
import static utils.reqSpecification.SpecifyRequest.getRequestSpec;
import static utils.resSpecification.SpecifyResponse.getResponseSpec;

public class PostProductRequest implements JSON_SCHEMAS {
    @DisplayName("Create new product")
    public Response createAProduct(Products requestBody) {
        Response response = given()
                .spec(getRequestSpec())
                .body(requestBody)
                .when()
                .post(allProducts);
        response.then().spec(getResponseSpec());
        response.then().time(lessThan(5L), TimeUnit.SECONDS);
        response.then().statusCode(200);
        //response.then().body(POST_SINGLE_PRODUCT_SCHEMA);
        return response;
    }
}
