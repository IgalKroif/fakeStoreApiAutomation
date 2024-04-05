package CreateRequest;

import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.testng.annotations.Optional;
import utils.pojo.cart.CreateCart;
import utils.pojo.cart.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static Routes.RouteCartEndPoint.allCarts;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;
import static utils.CONSTANTS.JSON_SCHEMAS.ALL_CARTS_SCHEMA;
import static utils.reqSpecification.SpecifyRequest.getRequestSpec;
import static utils.resSpecification.SpecifyResponse.getResponseSpec;

public class PostCartRequest {

    private CreateCart requestBody(Object userId, Object date, @Optional Object productId, @Optional Object quantity) {
        CreateCart requestBody = new CreateCart();
        List<Product> products = new ArrayList<>();
        products.add(new Product(productId, quantity));
        requestBody.setUserId(userId);
        requestBody.setDate(date);
        requestBody.setProducts(products);

        return requestBody;
    }

    /**
     * Display all carts and products
     *
     * @param  userId    Object representing the user ID
     * @param  date      Object representing the date
     * @param  productId (Optional) Object representing the product ID
     * @param  quantity  (Optional) Object representing the quantity
     * @return           Response object containing the result of adding a new cart with all body fields
     */
    @Tags({@Tag("Carts"), @Tag("ALL_CARTS")})
    @DisplayName("Display all carts and products")
    public Response addNewCartWithAllBodyFields(Object userId, Object date, @Optional Object productId, @Optional Object quantity) {
        Response response = given()
                .spec(getRequestSpec())
                .body(requestBody(userId, date, productId, quantity))
                .when()
                .post(allCarts);
        response.then().spec(getResponseSpec());
        response.then().time(lessThan(3L), TimeUnit.SECONDS);
        response.then().statusCode(200);

        return response;
    }
}
