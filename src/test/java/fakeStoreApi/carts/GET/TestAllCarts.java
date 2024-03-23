package fakeStoreApi.carts.GET;

import CreateRequest.AllCartsRequests;
import groovy.util.logging.Slf4j;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import utils.CONSTANTS.CONSTANT_VALIDATION;
import utils.POJO.allCarts.Items;
import utils.POJO.allCarts.Product;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static utils.Validation.Fields.StaticFieldValidator.validateInt;
import static utils.Validation.Fields.StaticFieldValidator.validateString;

/**
 * The type Test all carts.
 */
@Slf4j
public class TestAllCarts extends AllCartsRequests implements CONSTANT_VALIDATION {
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
        response.then().statusCode(200);
        var items = response.as(Items[].class);

        for (Items item : items) {
            ids.add(item.getId());
            assertThat(item.getId()).isGreaterThan(0);
            validateInt().intGreaterEqualTo(item.getId(), 1, 1, 7);
        }
        logger.info("ids: " + ids + "\n" + "id array size:" + ids.size() + "\n");
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
        response.then().statusCode(200);
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
        response.then().statusCode(200);
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
        response.then().statusCode(200);

        // Retrieve the items from the response and iterate over them
        var items = response.as(Items[].class);
        for (Items item : items) {
            // Iterate over the products in each item and add their product IDs to the productIds list
            for (Product product : item.getProducts()) {
                productIds.add(product.getProductId());

                // Validate the product ID
                var productId = product.getProductId();
                validateInt().intGreaterEqualTo(productId, 1);
                validateInt().intLessThanEqualTo(productId, 100);
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
        response.then().statusCode(200);
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
                validateInt().intGreaterEqualTo(quantity, 1);
                // Validate that the quantity is less than or equal to 100
                validateInt().intLessThanEqualTo(quantity, 1000);
            }
        }
        // Log the added quantities and the size of the array
        logger.info("Cart added quantities: " + productQuantity + "\n" +
                "Size of array: " + productQuantity.size() + "\n");
    }
}