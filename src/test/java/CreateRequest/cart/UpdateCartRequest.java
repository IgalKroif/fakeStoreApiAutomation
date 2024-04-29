package CreateRequest.cart;

import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.testng.annotations.Optional;
import utils.CONSTANTS.JSON_SCHEMAS;

import java.util.concurrent.TimeUnit;

import static CreateRequest.cart.PostCartRequest.requestBody;
import static Routes.RouteCartEndPoint.cartById;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;
import static utils.reqSpecification.SpecifyRequest.getRequestSpec;
import static utils.resSpecification.SpecifyResponse.getResponseSpec;
import static utils.validation.dataRandomizer.NumberRandomizer.generateRandInt;

public class UpdateCartRequest implements JSON_SCHEMAS {

    /**
     * Update Carts with all body fields
     *
     * @param  userId     description of parameter
     * @param  date       description of parameter
     * @param  productId  description of parameter
     * @param  quantity   description of parameter
     * @return  response request method.
     */
    @Tags({@Tag("Carts"), @Tag("ALL_CARTS")})
    @DisplayName("Update Carts with all body fields")
    public Response updateExistingCartUsingPut(Object userId, Object date, @Optional Object productId, @Optional Object quantity) {
        Response response = given()
                .spec(getRequestSpec())
                .pathParams("id", generateRandInt(1, 7))
                .body(requestBody(userId, date, productId, quantity))
                .when()
                .put(cartById);
        response.then().spec(getResponseSpec());
        response.then().time(lessThan(5L), TimeUnit.SECONDS);
        //response.then().body(UPDATE_CART_SCHEMA);
        response.then().statusCode(200);

        return response;
    }

    @Tags({@Tag("Carts"), @Tag("ALL_CARTS")})
    @DisplayName("Update Carts with all body fields")
    public Response updateExistingCartUsingPut(Object pathParamId, Object userId, Object date, @Optional Object productId, @Optional Object quantity) {
        Response response = given()
                .spec(getRequestSpec())
                .pathParams("id",pathParamId)
                .body(requestBody(userId, date, productId, quantity))
                .when()
                .put(cartById);
        response.then().spec(getResponseSpec());
        response.then().time(lessThan(5L), TimeUnit.SECONDS);
        response.then().statusCode(200);
       // response.then().body(UPDATE_CART_SCHEMA);

        return response;
    }

    @Tags({@Tag("Carts"), @Tag("ALL_CARTS")})
    @DisplayName("Update Carts with all body fields")
    public Response updateExistingCartUsingPatch(Object userId, Object date, @Optional Object productId, @Optional Object quantity) {
        Response response = given()
                .spec(getRequestSpec())
                .pathParams("id", generateRandInt(1, 7))
                .body(requestBody(userId, date, productId, quantity))
                .when()
                .patch(cartById);
        response.then().spec(getResponseSpec());
        response.then().time(lessThan(5L), TimeUnit.SECONDS);
       // response.then().body(UPDATE_CART_SCHEMA);
        response.then().statusCode(200);

        return response;
    }

    @Tags({@Tag("Carts"), @Tag("ALL_CARTS")})
    @DisplayName("Update Carts with all body fields")
    public Response updateExistingCartUsingPatch(Object pathParamId, Object userId, Object date, @Optional Object productId, @Optional Object quantity) {
        Response response = given()
                .spec(getRequestSpec())
                .pathParams("id", pathParamId)
                .body(requestBody(userId, date, productId, quantity))
                .when()
                .patch(cartById);
        response.then().spec(getResponseSpec());
        response.then().time(lessThan(5L), TimeUnit.SECONDS);
    //    response.then().body(UPDATE_CART_SCHEMA);
        response.then().statusCode(200);

        return response;
    }
}