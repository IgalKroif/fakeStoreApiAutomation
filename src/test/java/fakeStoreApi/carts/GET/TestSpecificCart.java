package fakeStoreApi.carts.GET;

import io.restassured.response.Response;
import CreateRequest.AllCartRequests;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import utils.CONSTANTS.JSON_SCHEMAS;
import utils.Validation.Errors.ErrorTester;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static utils.Validation.Errors.ErrorValidator.validateError;
import static utils.populateCsvData.InjectData.populateInvalidIds;
import static utils.populateCsvData.InjectData.populateValidIds;

public class TestSpecificCart extends AllCartRequests implements JSON_SCHEMAS {
    ErrorTester validateError = new ErrorTester();

    @ParameterizedTest
    @CsvFileSource(resources = "/CSVS/CART_IDS.csv", numLinesToSkip = 1)
    public void assertValidSpecificCartIds(int id) {
        Response response = testSpecificCart(populateValidIds(id));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/CSVS/INVALID_CART_ID_DATA.csv", numLinesToSkip = 1)
    public void testSpecificCartWithInvalidId(Object id) {
        Response response = testInvalidSpecificCart(populateInvalidIds(id));
        var statusCode = response.getStatusCode();
        var responseBody = response.getBody().asPrettyString();
       switch (statusCode) {
           case 200 -> assertThat(responseBody, is(nullValue().toString()));
           case 400 -> {
               validateError().assertErrorResponse(responseBody, "cart id should be provided");
               response.then().body(SINGLE_CART_ERROR);
           }
           case 500 -> assertThat(responseBody, containsStringIgnoringCase("Internal Server Error"));
           default -> response.then().statusCode(404);
       }
    }
}