package fakeStoreApi.storeCarts.POST;

import CreateRequest.cart.PostCartRequest;
import groovy.util.logging.Slf4j;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.api.RepeatedTest;
import utils.CONSTANTS.JSON_SCHEMAS;


import static org.hamcrest.Matchers.*;
import static utils.validation.Fields.StaticFieldValidator.assertNullInBody;
import static utils.validation.Fields.StaticFieldValidator.validateCreatedCart;
import static utils.validation.dataRandomizer.NumberRandomizer.generateRandInt;
import static utils.validation.dataRandomizer.StringRandomizer.generateRandDate;

@Slf4j
@Feature("POST METHOD : CARTS ENDPOINT")
public class AddToCartTest extends PostCartRequest implements JSON_SCHEMAS {

    /**
     * A test to add to the cart using all available fields.
     */
    @RepeatedTest(value = 25, name = "Add to cart with all fields {currentRepetition} of {totalRepetitions}")
    @Epic("ADD TO CART USING ALL FIELDS")
    @Step
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
    @RepeatedTest(value = 10, name = "Add to cart with user ID {currentRepetition} of {totalRepetitions}")
    @Epic("ADD TO CART USING USER ID")
    @Step
    public void addToCartUsingUserIdTest() {
        var randomUserId = generateRandInt(10, 99_999_999);
        var response = super.addNewCartWithAllBodyFields(randomUserId, 0, 0, 0);
        validateCreatedCart(response, randomUserId, "0", 0, 0);
    }

    /**
     * Test method for adding to cart using a random date.
     */
    @RepeatedTest(value = 10, name = "Add to cart with date {currentRepetition} of {totalRepetitions}")
    @Epic("ADD TO CART USING DATE")
    @Step
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
    @RepeatedTest(value = 10, name = "Add to cart with product ID {currentRepetition} of {totalRepetitions}")
    @Epic("ADD TO CART USING PRODUCT ID")
    public void addToCartUsingProductIdTest() {
        var randomProductId = generateRandInt(1, Integer.MAX_VALUE);
        var response = super.addNewCartWithAllBodyFields(null, null, randomProductId, null);
        System.out.println(randomProductId);
        assertNullInBody(response, nullValue(), nullValue(), equalTo(randomProductId), nullValue());
    }

    /**
     * Test for adding to cart using a specific quantity.
     */
    @RepeatedTest(value = 10, name = "Add to cart with quantity {currentRepetition} of {totalRepetitions}")
    @Epic("ADD TO CART USING QUANTITY")
    @Step
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
    @RepeatedTest(value = 10, name = "Add to cart with all null {currentRepetition} of {totalRepetitions}")
    @Epic("ADD TO CART WITH ALL NULL")
    @Step
    public void addToCartAllNull() {
        var response = super.addNewCartWithAllBodyFields(null, null, null, null);

        assertNullInBody(response, nullValue(), nullValue(), nullValue(), nullValue());
    }
}