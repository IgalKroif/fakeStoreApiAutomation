package fakeStoreApi.carts.GET;

import CreateRequest.AllCartRequests;
import io.restassured.response.Response;
import net.datafaker.Faker;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import utils.CONSTANTS.JSON_SCHEMAS;
import utils.populateCsvData.InjectData;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static utils.Validation.Errors.ErrorValidator.validateError;
import static utils.Validation.Header.validateHeaders.findGmtTime;
import static utils.Validation.Header.validateHeaders.validateHeaderResponseData;
import static utils.populateCsvData.InjectData.populateInvalidIds;
import static utils.populateCsvData.InjectData.populateValidIds;

public class TestSpecificCart extends AllCartRequests implements JSON_SCHEMAS {

    /**
     * Test to assert valid specific cart IDs.
     *
     * @param id The ID of the cart to test.
     * @see InjectData#populateValidIds(int)
     * @apiNote This method populates valid IDs from a CSV file and asserts that the response is as expected for each valid ID.
     */
    @ParameterizedTest
    @CsvFileSource(resources = "/CSVS/CART_IDS.csv", numLinesToSkip = 1)
    public void assertValidSpecificCartIds(int id) {
        SimpleDateFormat gmtDateFormat = findGmtTime();
        // Call the testSpecificCart method with the populated valid IDs
        Response response = testSpecificCart(populateValidIds(id));
        response.then().log().headers();
        validateHeaderResponseData(response);
    }

    /**
     * Test specific cart with invalid ID.
     *
     * @param id the invalid cart ID
     * @see InjectData#populateInvalidIds(Object)
     * @apiNote This method populates invalid IDs from a CSV file
     * and asserts that the response is as expected for each invalid ID.
     */
    @ParameterizedTest
    @CsvFileSource(resources = "/CSVS/INVALID_CART_ID_DATA.csv", numLinesToSkip = 1)
    public void testSpecificCartWithInvalidId(Object id) {
        // Send request with invalid ID and get the response
        Response response = testInvalidSpecificCart(populateInvalidIds(id));

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
    }
    @Test
    public void specificCartIdTest(int id) {
        Response response = testSpecificCart(1);
        response.then().statusCode(200);
    }
}