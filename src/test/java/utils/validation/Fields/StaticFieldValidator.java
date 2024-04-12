package utils.validation.Fields;

import io.restassured.response.Response;
import org.hamcrest.Matcher;
import utils.pojo.cart.Items;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static utils.validation.dataRandomizer.NumberRandomizer.generateRandInt;

public class StaticFieldValidator {
    /**
     * Validate an integer.
     *
     * @return         	an instance of IntegerValidation
     */
    public static IntegerValidation validateInt() {
        return new IntegerValidation();
    }

    /**
     * Creates and returns a new instance of the StringValidation class.
     *
     * @return a new instance of the StringValidation class
     */
    public static StringValidation validateString() {
        return new StringValidation();
    }

    /**
     * Asserts the response body structure and values against the expected values.
     *
     * @param  response         the response object to check
     * @param  expectedUserId   the expected user id matcher
     * @param  expectedDate     the expected date matcher
     * @param  expectedProductId    the expected product id matcher
     * @param  expectedQuantity  the expected quantity matcher
     */

    public static void assertNullInBody(Response response, Matcher<?> expectedUserId, Matcher<?> expectedDate,
                                        Matcher<?> expectedProductId, Matcher<?> expectedQuantity) {
        var items = response.as(Items.class);
        response.then()
                .body("id", is(oneOf(items.getId(), null)))
                .body("userId", expectedUserId)
                .body("date", expectedDate)
                .body("products", hasSize(greaterThanOrEqualTo(1)))
                .body("products", hasSize(lessThanOrEqualTo(3)))
                .body("products["+generateRandInt(0,3)+"].productId", expectedProductId)
                .body("products["+generateRandInt(0,3)+"].quantity", expectedQuantity);
    }
    public static void assertNullInBody(Response response,Matcher<?> expectedIdParam, Matcher<?> expectedUserId,
                                        Matcher<?> expectedDate, Matcher<?> expectedProductId, Matcher<?> expectedQuantity) {
        var items = response.as(Items.class);
        response.then()
                .body("id", expectedIdParam)
                .body("userId", expectedUserId)
                .body("date", expectedDate)
                .body("products", hasSize(greaterThanOrEqualTo(1)))
                .body("products", hasSize(lessThanOrEqualTo(3)))
                .body("products["+generateRandInt(0,3)+"].productId", expectedProductId)
                .body("products["+generateRandInt(0,3)+"].quantity", expectedQuantity);
    }
    /**
     * Validate the created cart response by checking the user ID, date, products' IDs, and quantities.
     *
     * @param  response            the response object containing the created cart details
     * @param  expectedUserId      the expected user ID to validate
     * @param  expectedDate        the expected date to validate
     * @param  expectedProductId   the expected product ID to validate or null if not provided
     * @param  expectedQuantity    the expected quantity to validate or null if not provided
     */
    public static void validateCreatedCart(Response response, Integer expectedUserId, String expectedDate, Integer expectedProductId, Integer expectedQuantity) {
        var items = response.as(Items.class);

        Integer userId = items.getUserId();
        assertEquals(expectedUserId, userId);
        var date = items.getDate();
        assertThat(date, is(equalTo(expectedDate)));

        // Validate products
        items.getProducts().forEach(product -> {
            if (expectedProductId != null) {
                assertThat(product.getProductId(), is(equalTo(expectedProductId)));
            } else {
                assertNull(product.getProductId());
            }

            if (expectedQuantity != null) {
                assertThat(product.getQuantity(), is(equalTo(expectedQuantity)));
            } else {
                assertNull(product.getQuantity());
            }
        });
    }
}