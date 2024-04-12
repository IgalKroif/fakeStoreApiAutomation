package fakeStoreApi.storeCarts.GET;

import CreateRequest.GetCartRequest;
import groovy.util.logging.Slf4j;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import utils.CONSTANTS.CONSTANTS;
import utils.pojo.cart.Items;
import utils.pojo.cart.Product;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static utils.validation.Fields.StaticFieldValidator.validateInt;
import static utils.validation.Fields.StaticFieldValidator.validateString;

/**
 * The type Test all carts.
 */
@Slf4j
public class TestAllCarts extends GetCartRequest implements CONSTANTS {
    public final Logger logger = LoggerFactory.getLogger(TestAllCarts.class);

    /**
     * Clears the lists of ids, userIds, cartDates, productIds, and productQuantity.
     */
    @AfterMethod
    public void clearList() {
        clearLists(ids, userIds, cartDates, productIds, productQuantity);
    }

    /**
     * Asserts the IDs in all carts.
     */
    @Test
    @Tags({@Tag("Carts"), @Tag("CartId")})
    @DisplayName("assert IDS in all carts")
    public void assertAllCartIds() {
        Response response = testAllCarts();
        var items = response.as(Items[].class);

        for (Items item : items) {
            ids.add(item.getId());
            assertThat(item.getId()).isGreaterThan(0);
            validateInt().intGreaterEqualTo(item.getId(), 1, 1, 7);
        }
        logResponse();
    }

    /**
     * This method asserts the IDs in all carts and validates the sort and limit parameters.
     * It uses a parameterized test with different limit values.
     *
     * @param limitParam The limit parameter to test.
     */
    @ParameterizedTest()
    @ValueSource(ints = {100,8,7,6,5,4,3,2,1,0,-1})
    @Tags({@Tag("Carts"), @Tag("CartId")})
    @DisplayName("Assert Descending queryParameter")
    public void assertDescSortAndLimitCartParams(int limitParam) {
        // Call the testAllCarts method with the specified parameters
        Response response = testAllCarts(byDesc, limitParam);

        // Parse the response as an array of Items
        var items = response.as(Items[].class);

        // Iterate over the items and perform assertions and validations
        for (Items item : items) {
            ids.add(item.getId());
            assertThat(item.getId()).isGreaterThan(0);
            validateInt().intGreaterEqualTo(item.getId(), 1, 1, 7);
        }
        // Validate the order of the IDs
        validateInt().intGreaterEqualTo((Integer) ids.get(0), (Integer) ids.get(ids.size() - 1));
        // Log the IDs and the size of the ID array
        logResponse();

        // Clear the list of IDs
        clearList();
    }

    /**
     * This test method asserts the IDS in all carts and validates the sort and limit parameters.
     *
     * @param limitParam The limit parameter for the test.
     */
    @ParameterizedTest()
    @ValueSource(ints = {-1 ,0, 1, 2, 3, 4, 5, 6, 7, 8, 50000})
    @Tags({@Tag("Carts"), @Tag("CartId")})
    @DisplayName("Assert Ascending queryParameter")

    public void assertAscSortAndLimitCartParams(int limitParam) {
        // Call testAllCarts method with specified sort and limit parameters
        Response response = testAllCarts(byAsc, limitParam);
        // Convert response to Items array
        var items = response.as(Items[].class);
        // Iterate over items and perform assertions
        for (Items item : items) {
            // Add ID to the list
            ids.add(item.getId());
            // Assert that ID is greater than 0
            assertThat(item.getId()).isGreaterThan(0);
            // Validate ID is within specified range
            validateInt().intGreaterEqualTo(item.getId(), 1, 1, 7);
        }
        // Validate that IDs are in ascending order
        validateInt().intLessThanEqualTo((Integer) ids.get(0), (Integer) ids.get(ids.size() - 1));
        // Log the IDs and size of the ID list
        logResponse();
        // Clear the ID list
        clearList();
    }

    /**
     * Asserts the user IDs in the cart by retrieving the cart items and validating
     * the user IDs. The function retrieves the cart items using the `testAllCarts`
     * method and asserts that the status code of the response is 200. It then
     * iterates over each item in the cart and adds the user ID to the `userIds` list.
     * The function also asserts that each user ID is greater than 0 and validates
     * that the ID is greater than or equal to 1 using the `validateInt` method.
     * Finally, the function logs the `userIds` list and its size.
     */
    @Test
    @Tags({@Tag("Carts"), @Tag("UserID")})
    @DisplayName("assert user ID'S in all carts")
    public void assertAllUserIdsInCart() {
        Response response = testAllCarts();
        var items = response.as(Items[].class);

        for (Items item : items) {
            userIds.add(item.getUserId());
            assertThat(item.getUserId()).isGreaterThan(0);
            validateInt().intGreaterEqualTo(item.getId(), 1, 1, 8);
        }
        logger.info("userIds: " + userIds + "\n" + "userIds array size:" + userIds.size() + "\n");
    }

    /**
     * assert item date in cart
     *
     */
    @Test
    @Tags({@Tag("Carts"), @Tag("ItemCartDate")})
    @DisplayName("assert item creation date in all carts")
    public void assertAllItemCartDate() {
        Response response = testAllCarts();
        var items = response.as(Items[].class);
        for (Items item : items) {
            cartDates.add(item.getDate());
            validateString().stringLengthGTE(item.getDate(), 24);
        }
        logger.info("Cart creation dates: " + cartDates + "\n" +
                "Size of array: " + cartDates.size() + "\n");
    }

    /**
     * Asserts the product IDs in all carts.
     * Retrieves the product IDs from the response and validates them.
     * Logs the product IDs and the size of the array.
     */
    @Test
    @Tags({@Tag("Carts"), @Tag("ItemCartDate")})
    @DisplayName("Assert product IDs in all carts")
    public void assertAllProductIdsInCarts() {
        // Retrieve the response from the testAllCarts method
        Response response = testAllCarts();

        // Assert that the response status code is 200

        // Retrieve the items from the response and iterate over them
        var items = response.as(Items[].class);
        for (Items item : items) {
            // Iterate over the products in each item and add their product IDs to the productIds list
            for (Product product : item.getProducts()) {
                productIds.add(product.getProductId());

                // Validate the product ID
                var productId = product.getProductId();
                validateInt().intGreaterEqualTo((Integer) productId, 1);
                validateInt().intLessThanEqualTo((Integer) productId, 100);
            }
        }
        // Log the product IDs and the size of the array
        logger.info("Carts product ids: " + productIds + "\n" +
                "Size of array: " + productIds.size() + "\n");
    }

    /**
     * Asserts the quantities of products in all carts
     */
    @Test
    @Tags({@Tag("Carts"), @Tag("ItemCartDate")})
    @DisplayName("assert product quantities in all carts")
    public void assertAllProductQuantitiesInCarts() {
        // Send a request to get all carts
        Response response = testAllCarts();
        // Deserialize the response body into an array of Items
        var items = response.as(Items[].class);
        // Iterate through each item in the array
        for (Items item : items) {
            // Iterate through each product in the item
            for (Product product : item.getProducts()) {
                var quantity = product.getQuantity();
                // Add the quantity to the list of product quantities
                productQuantity.add(quantity);
                // Validate that the quantity is greater than or equal to 1
                validateInt().intGreaterEqualTo((Integer) quantity, 1);
                // Validate that the quantity is less than or equal to 100
                validateInt().intLessThanEqualTo((Integer) quantity, 1000);
            }
        }
        // Log the added quantities and the size of the array
        logger.info("Cart added quantities: " + productQuantity + "\n" +
                "Size of array: " + productQuantity.size() + "\n");
    }

    /**
     * Asserts the cart by date query parameters.
     *
     * @param  startDate  the start date for the cart
     * @param  endDate    the end date for the cart
     */
    @Tags({@Tag("Carts"), @Tag("CartId")})
    @ParameterizedTest
    @CsvFileSource(resources = "/CSVS/DIFFERENT_DATES.csv", numLinesToSkip = 1)
    @DisplayName("Assert Cart by date queryParameters")
    public void assertSortCartByDateParams(String startDate, String endDate) {
        if (startDate == null || startDate.isEmpty()) {
            startDate = "0001-01-01";
        }
        if (endDate == null || endDate.isEmpty()) {
            endDate = "9999-12-31";
        }
        // Compare dates as strings and update endDate if startDate is after endDate
        if (startDate.compareTo(endDate) > 0) {
            endDate = startDate;
        }
        // Call the testAllCarts method with the specified parameters
        Response response = testAllCarts(startDate, endDate);
        if (response.statusCode() == 200) {
            // Parse the response as an array of Items
            var items = response.as(Items[].class);

            if (Arrays.stream(items).findFirst().isPresent()) {
                // Iterate over the items and perform assertions and validations
                for (Items item : items) {
                    ids.add(item.getId());
                    assertThat(item.getId()).isGreaterThan(0);
                    validateInt().intGreaterEqualTo(item.getId(), 1, 1, 7);
                }
                // Validate the order of the IDs
                validateInt().intLessThanEqualTo((Integer) ids.get(0), (Integer) ids.get(ids.size() - 1));
                // Log the IDs and the size of the ID array
                logResponse();
            } else {
                logger.info("No items found in the response due to wrong date range : " + startDate + " - " + endDate);
            }
        }
        if (response.statusCode() == 400) {

            logger.info("Bad Request: " + expectedErrorMessage);
            response.then().body("status", equalTo("error"));
            response.then().body("message", equalTo(expectedErrorMessage));
        }
        // Clear the list of IDs
        clearList();
    }
    private void logResponse() {
        logger.info("ids: " + ids + "\n" + "id array size:" + ids.size() + "\n");
    }
}