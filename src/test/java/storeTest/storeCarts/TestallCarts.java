package storeTest.storeCarts;

import groovy.util.logging.Slf4j;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static Routes.RouteCartEndPoint.allCarts;
import static io.restassured.RestAssured.given;
@Slf4j
public class TestallCarts {
    private static final Logger logger = LoggerFactory.getLogger(TestallCarts.class);

    @Test
    public void testAllCarts() {
        Response response = given()
                .when()
                .get(allCarts);
        response.then().statusCode(200);
        response.then().log().body();
        //logger.info(response.asPrettyString());
    }
}
