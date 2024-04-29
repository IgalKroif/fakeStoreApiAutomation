package CreateRequest.product;

import io.restassured.response.Response;
import utils.pojo.product.Products;

import java.util.concurrent.TimeUnit;

import static Routes.RouteProductsEndpoint.allProducts;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;
import static utils.CONSTANTS.JSON_SCHEMAS.POST_SINGLE_PRODUCT_SCHEMA;
import static utils.reqSpecification.SpecifyRequest.getRequestSpec;
import static utils.resSpecification.SpecifyResponse.getResponseSpec;

public class UpdateProductRequest {

    public Response updateProductUsingPut(int productIdToUpdate ,Products requestBody) {
        Response response = given()
                .spec(getRequestSpec())
                .body(requestBody)
                .when()
                .put(allProducts + "/" + productIdToUpdate);
        response.then().spec(getResponseSpec());
        response.then().time(lessThan(5L), TimeUnit.SECONDS);
        response.then().statusCode(200);
       // response.then().body(POST_SINGLE_PRODUCT_SCHEMA);
        return response;
    }

    public Response updateProductUsingPatch(int productIdToUpdate ,Products requestBody) {
        Response response = given()
                .spec(getRequestSpec())
                .body(requestBody)
                .when()
                .patch(allProducts + "/" + productIdToUpdate);
        response.then().spec(getResponseSpec());
        response.then().time(lessThan(5L), TimeUnit.SECONDS);
        response.then().statusCode(200);
        //response.then().body(POST_SINGLE_PRODUCT_SCHEMA);
        return response;
    }
}
