package CreateRequest.cart;

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
import static utils.reqSpecification.SpecifyRequest.getRequestSpec;
import static utils.resSpecification.SpecifyResponse.getResponseSpec;

public class PostCartRequest {

    public static CreateCart requestBody(Object userId, Object date, @Optional Object productId, @Optional Object quantity) {
        CreateCart requestBody = new CreateCart();
        List<Product> products = new ArrayList<>();
        products.add(new Product(productId, quantity));
        products.add(new Product(productId, quantity));
        products.add(new Product(productId, quantity));
        requestBody.setUserId(userId);
        requestBody.setDate(date);
        requestBody.setProducts(products);

        return requestBody;
    }

    /**
     * Create new Carts with all body fields
     *
     * @param  userId     description of parameter
     * @param  date       description of parameter
     * @param  productId  description of parameter
     * @param  quantity   description of parameter
     * @return  response request method.
     */
    @Tags({@Tag("Carts"), @Tag("ALL_CARTS")})
    @DisplayName("Create new Carts with all body fields")
    public Response addNewCartWithAllBodyFields(Object userId, Object date, @Optional Object productId, @Optional Object quantity) {
        Response response = given()
                .spec(getRequestSpec())
                .body(requestBody(userId, date, productId, quantity))
                .when()
                .post(allCarts);
        response.then().spec(getResponseSpec());
        response.then().time(lessThan(5L), TimeUnit.SECONDS);
        response.then().statusCode(200);

        return response;
    }
}
