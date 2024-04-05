package fakeStoreApi.carts.POST;

import CreateRequest.PostCartRequest;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import scala.Int;
import utils.CONSTANTS.JSON_SCHEMAS;
import utils.pojo.cart.Items;

import java.util.Objects;

import static java.util.Objects.isNull;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static utils.CONSTANTS.CONSTANT_VALIDATION.userIds;
import static utils.validation.dataRandomizer.NumberRandomizer.generateRandInt;
import static utils.validation.dataRandomizer.StringRandomizer.generateRandDate;

public class AddToCartTest extends PostCartRequest implements JSON_SCHEMAS {
    @RepeatedTest(25)
    public void addToCartUsingAllFieldsTest() {
        var randomUserId = generateRandInt(10, 99_999_999);
        var randomDate = generateRandDate();
        var randomProductId = generateRandInt(1, 1000);
        var randomQuantity = generateRandInt(0, generateRandInt(1, 99_999_999));
        Response response = addNewCartWithAllBodyFields(randomUserId, randomDate, randomProductId, randomQuantity);
        response.then().body(CREATE_CART_SCHEMA);

        validateCreatedCart(response, randomUserId, randomDate, randomProductId, randomQuantity);
    }

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
    @RepeatedTest(10)
    public void addToCartUsingUserIdTest() {
        var randomUserId = generateRandInt(10, 99_999_999);
        Response response = addNewCartWithAllBodyFields(randomUserId, 0, 0, 0);
        var items = response.as(Items.class);
        System.out.println(items.getDate());
        validateCreatedCart(response, randomUserId, "0", 0, 0);
    }
    @RepeatedTest(10)
    public void addToCartUsingDateTest() {
        var randomDate = generateRandDate();
        Response response = addNewCartWithAllBodyFields(null, randomDate, null, null);

        validateCreatedCart(response, 0, randomDate, null, null);
    }
    @RepeatedTest(10)
    public void addToCartUsingProductIdTest() {
        var randomProductId = generateRandInt(1, Integer.MAX_VALUE);
        Response response = addNewCartWithAllBodyFields(null, null, randomProductId, null);
        System.out.println(randomProductId);
        assertNullInBody(response, nullValue(), nullValue(), equalTo(randomProductId),nullValue());
        // validateCreatedCart(response, null, null, randomProductId, 0);
    }

    private static void assertNullInBody(Response response, Matcher<?> expectedUserId, Matcher<?> expectedDate, Matcher<?> expectedProductId, Matcher<?> expectedQuantity) {
        response.then()
                .body("id", equalTo(11))
                .body("userId", expectedUserId)
                .body("date", expectedDate)
                .body("products", hasSize(1))
                .body("products[0].productId", expectedProductId)
                .body("products[0].quantity", expectedQuantity);
    }

    @RepeatedTest(10)
    public void addToCartUsingQuantityTest() {
        var randomQuantity = generateRandInt(0, generateRandInt(1, 99_999_999));
        Response response = addNewCartWithAllBodyFields(null, null, null, randomQuantity);

        assertNullInBody(response, nullValue(), nullValue(), nullValue(), equalTo(randomQuantity));
    }
}