package fakeStoreApi.storeCarts.GET;

import CreateRequest.cart.GetCartRequest;
import groovy.util.logging.Slf4j;
import io.restassured.filter.log.LogDetail;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.CONSTANTS.JSON_SCHEMAS;
import utils.pojo.cart.Product;
import utils.populateCsvData.InjectData;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static utils.CONSTANTS.CONSTANTS.dateFieldPattern;
import static utils.validation.Errors.ErrorValidator.validateError;
import static utils.validation.Fields.StaticFieldValidator.validateInt;
import static utils.validation.Header.validateHeaders.validateHeaderResponseData;
import static utils.validation.dataRandomizer.NumberRandomizer.generateRandInt;
import static utils.populateCsvData.InjectData.populateInvalidIds;
import static utils.populateCsvData.InjectData.populateValidIds;

@Log4j2
@Slf4j
public class TestSpecificCart extends GetCartRequest implements JSON_SCHEMAS {
    public final Logger logger = LoggerFactory.getLogger(TestSpecificCart.class);

    /**
     * Test to assert valid specific cart IDs.
     *
     * @param cartId The ID of the cart to test.
     * @CSVFileSource(resources = CSVS/CART_IDS.csv, numLinesToSkip = 1)
     * @apiNote This method populates valid IDs from a CSV file and asserts that the response is as expected for each valid ID.
     * @see InjectData#populateValidIds(int)
     */
    @ParameterizedTest
    @CsvFileSource(resources = "/CSVS/CART_IDS.csv", numLinesToSkip = 1)
    public void assertValidSpecificCartIds(int cartId) {
        // Call the testSpecificCart method with the populated valid IDs
        Response response = testSpecificCart(populateValidIds(cartId));
        response.then().log().headers();
        // validates specific header content as well as tries to assert the GMT response Datetime.
        validateHeaderResponseData(response);

        // asserts that the body id field equals the id of the csv param sent in the request CSV.
        response.then().body("id", is(equalTo(cartId)));

        logCart(logger, "Tested cartId: " + cartId + " with status: " + response.getStatusLine());
    }

    private static void logCart(Logger logger, String cartId) {
        logger.info(cartId);
    }

    /**
     * Test specific cart with invalid ID.
     *
     * @param cartId the invalid cart ID
     * @apiNote This method populates invalid IDs from a CSV file
     * and asserts that the response is as expected for each invalid ID.
     * @see InjectData#populateInvalidIds(Object)
     */
    @ParameterizedTest
    @CsvFileSource(resources = "/CSVS/INVALID_CART_ID_DATA.csv", numLinesToSkip = 1)
    public void testSpecificCartWithInvalidId(Object cartId) {
        // Send request with invalid ID and get the response
        Response response = testInvalidSpecificCart(populateInvalidIds(cartId));

        // Get status code and response body
        var statusCode = response.getStatusCode();
        var responseBody = response.getBody().asPrettyString();

        // Check different status code scenarios
        switch (statusCode) {
            case 200 -> assertThat(responseBody, is(nullValue().toString()));
            case 400 -> {
                // Validate error response and body
                validateError().assertErrorResponse(responseBody, "cart id should be provided");
                response.then().body(SINGLE_CART_ERROR);
            }
            case 500 -> assertThat(responseBody, containsStringIgnoringCase("Internal Server Error"));
            default -> response.then().statusCode(404);
        }
        logCart(logger, "Tested cartId: " + cartId + " with status: " + response.getStatusLine());
    }

    @RepeatedTest(10)
    @DisplayName("Assert specific cart ID")
    public void specificCartIdTest() {
        var cartId = generateRandInt();
        Response response = testSpecificCart(cartId);
        response.then().body("id", equalTo(cartId));
        validateUserIdAndCartDate(cartId, response);

        logCart(logger, "Tested cartId: " + cartId + " with status: " + response.getStatusLine());
    }
/**
 * Tests card using a random ID and validates the user ID and cart date.
 * @see #validateUserIdAndCartDate(int, Response)
 * @see utils.validation.dataRandomizer.NumberRandomizer#generateRandInt()
 * */
    @RepeatedTest(10)
    @DisplayName("Assert specific cart with userId and date")
    public void testSpecificCartUserIdAndDate() {
        var cartId = generateRandInt();
        Response response = testSpecificCart(cartId);
        validateUserIdAndCartDate(cartId, response);

        logCart(logger, "Tested cartId: " + cartId + " with status: " + response.getStatusLine());
    }

    /**
     * Test the products in a specific cart by generating a random cart ID, making a request to the API,
     * validating the response, and asserting the products in the cart.
     */
    @RepeatedTest(10)
    public void testProductsInSpecificCart() {
        // Generate a random cart ID
        var cartId = generateRandInt();

        // Make a request to the API with the generated cart ID
        Response response = testSpecificCart(cartId);

        // Get the response body and parse it as JSON
        var responseBody = response.getBody().jsonPath();

        // Get the list of products from the response body
        var products = responseBody.getList("products", Product.class);

        // Get the cart version from the response body
        int cartVersion = responseBody.get("__v");

        // Validate the properties of each product in the cart
        products.forEach(cartProduct -> {
            validateInt().intGreaterEqualTo((Integer) cartProduct.getProductId(), 1, 1, 20);
            validateInt().intGreaterEqualTo((Integer) cartProduct.getQuantity(), 1, 1, Integer.MAX_VALUE);
        });

        // Validate the user ID and cart date in the response
        validateUserIdAndCartDate(cartId, response);

        // Validate the cart version
        validateInt().intLessThanEqualTo(cartVersion, 1);
        validateInt().intGreaterEqualTo(cartVersion, -1, -1, 1);

        // Log the tested cart ID and the status of the response
        logCart(logger, "Tested cartId: " + cartId + " with status: " + response.getStatusLine() + "\n" +
                " asserted products in cart " + " " + products.stream().toList() + "\n");
    }

    private static void validateUserIdAndCartDate(int id, Response response) {
        switch (id) {
        case 1, 2 ->  response.then().body("userId", equalTo(1));
            case 3 -> response.then().body("userId", equalTo(2));
            case 4, 5 -> response.then().body("userId", equalTo(3));
            case 6 -> response.then().body("userId", equalTo(4));
            case 7 -> response.then().body("userId", equalTo(8));
            default -> response.then().log().ifValidationFails(LogDetail.ALL);
        }
        response.then().body("date", matchesPattern(dateFieldPattern));

     var logger = LoggerFactory.getLogger(TestSpecificCart.class);
        logCart(logger, "response userId tested:" + response.getBody().jsonPath().get("userId") + "\n" +
                "response date tested regex of:" + response.getBody().jsonPath().get("date") + " " + "\n");
    }
}