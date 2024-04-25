package CreateRequest.product;

import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.pojo.product.Products;
import utils.pojo.product.Rating;

import java.util.concurrent.TimeUnit;

import static Routes.RouteProductsEndpoint.allProducts;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;
import static utils.reqSpecification.SpecifyRequest.getRequestSpec;
import static utils.resSpecification.SpecifyResponse.getResponseSpec;
import static utils.validation.dataRandomizer.NumberRandomizer.generateRandDouble;
import static utils.validation.dataRandomizer.NumberRandomizer.generateRandInt;
import static utils.validation.dataRandomizer.StringRandomizer.generateRandStringName;

public class PostProductRequest {
    @DisplayName("Create new product")
    public Response createAProduct(Products requestBody) {
        Response response = given()
                .spec(getRequestSpec())
                .body(requestBody)
                .when()
                .post(allProducts);
        response.then().spec(getResponseSpec());
        response.then().time(lessThan(3L), TimeUnit.SECONDS);
        response.then().statusCode(200);
        return response;
    }
}
