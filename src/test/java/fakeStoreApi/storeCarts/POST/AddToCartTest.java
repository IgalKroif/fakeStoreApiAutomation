package fakeStoreApi.storeCarts.POST;

import CreateRequest.cart.PostCartRequest;
import org.junit.jupiter.api.RepeatedTest;
import utils.CONSTANTS.JSON_SCHEMAS;


import static org.hamcrest.Matchers.*;
import static utils.validation.Fields.StaticFieldValidator.assertNullInBody;
import static utils.validation.Fields.StaticFieldValidator.validateCreatedCart;
import static utils.validation.dataRandomizer.NumberRandomizer.generateRandInt;
import static utils.validation.dataRandomizer.StringRandomizer.generateRandDate;

public class AddToCartTest extends PostCartRequest implements JSON_SCHEMAS {

    /**
     * A test to add to the cart using all available fields.
     */
    @RepeatedTest(25)
    public void addToCartUsingAllFieldsTest() {
        var randomUserId = generateRandInt(10, 99_999_999);
        var randomDate = generateRandDate();
        var randomProductId = generateRandInt(1, 1000);
        var randomQuantity = generateRandInt(0, generateRandInt(1, 99_999_999));
        var response = super.addNewCartWithAllBodyFields(randomUserId, randomDate, randomProductId, randomQuantity);
        response.then().body(CREATE_CART_SCHEMA);

        validateCreatedCart(response, randomUserId, randomDate, randomProductId, randomQuantity);
    }

    /**
     * Test for adding to cart using user ID.
     */
    @RepeatedTest(10)
    public void addToCartUsingUserIdTest() {
        var randomUserId = generateRandInt(10, 99_999_999);
        var response = super.addNewCartWithAllBodyFields(randomUserId, 0, 0, 0);
        validateCreatedCart(response, randomUserId, "0", 0, 0);
    }

    /**
     * Test method for adding to cart using a random date.
     */
    @RepeatedTest(10)
    public void addToCartUsingDateTest() {
        var randomDate = generateRandDate();
        var response = super.addNewCartWithAllBodyFields(null, randomDate, null, null);

        validateCreatedCart(response, 0, randomDate, null, null);
    }

    /**
     * Test to add a product to the cart using a random product ID.
     *
     * @return No return value
     * @RepeatedTest(10)
     */
    @RepeatedTest(10)
    public void addToCartUsingProductIdTest() {
        var randomProductId = generateRandInt(1, Integer.MAX_VALUE);
        var response = super.addNewCartWithAllBodyFields(null, null, randomProductId, null);
        System.out.println(randomProductId);
        assertNullInBody(response, nullValue(), nullValue(), equalTo(randomProductId), nullValue());
    }

    /**
     * Test for adding to cart using a specific quantity.
     */
    @RepeatedTest(10)
    public void addToCartUsingQuantityTest() {
        var randomQuantity = generateRandInt(0, generateRandInt(1, 99_999_999));
        var response = super.addNewCartWithAllBodyFields(null, null, null, randomQuantity);

        assertNullInBody(response, nullValue(), nullValue(), nullValue(), equalTo(randomQuantity));
    }

    /**
     * A description of the entire Java function.
     *
     * @return description of return value
     */
    @RepeatedTest(10)
    public void addToCartAllNull() {
        var response = super.addNewCartWithAllBodyFields(null, null, null, null);

        assertNullInBody(response, nullValue(), nullValue(), nullValue(), nullValue());
    }
}