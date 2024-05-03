package fakeStoreApi.storeCarts.UPDATE;

import CreateRequest.cart.UpdateCartRequest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;


import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;
import static utils.validation.Fields.StaticFieldValidator.assertNullInBody;
import static utils.validation.dataRandomizer.NumberRandomizer.generateRandInt;
import static utils.validation.dataRandomizer.StringRandomizer.generateRandDate;


@Tag("Carts")
@DisplayName("Test update using PUT | PATCH for carts")
@Tag("PutCart")
@Feature("PUT / PATCH METHOD : CARTS ENDPOINT")
public class TestUpdateExistingCart extends UpdateCartRequest {
    Object id = null;
    Object userId = null;
    Object date = null;
    Object productId = null;
    Object quantity = null;

    @RepeatedTest(value = 10, name = "update user ID field {currentRepetition} of {totalRepetitions}")
    @DisplayName("update user ID field test")
    @Tag("PutCart")
    @Epic("PUT METHOD, CART")
    @Step
    public void updateUserIDFieldTest() {
        this.userId = generateRandInt(1, Integer.MAX_VALUE);
        var response = super.updateExistingCartUsingPut(userId, date, productId, quantity);
        assertNullInBody(response, equalTo(userId), nullValue(), nullValue(), nullValue());
    }

    @RepeatedTest(value = 10, name = "update user ID field {currentRepetition} of {totalRepetitions}")
    @DisplayName("update user ID field using negative numbers test")
    @Tag("PutCart")
    @Epic("PUT METHOD, CART")
    @Step
    public void updateUserIDFieldNegativeNumbersTest() {
        this.userId = generateRandInt(Integer.MIN_VALUE, -1);
        var response = super.updateExistingCartUsingPut(userId, date, productId, quantity);
        assertNullInBody(response, equalTo(userId), nullValue(), nullValue(), nullValue());
    }

    @RepeatedTest(value = 10, name = "update date field {currentRepetition} of {totalRepetitions}")
    @DisplayName("update date field test")
    @Tag("PutCart")
    @Epic("PUT METHOD, CART")
    @Step
    public void updateDateFieldTest() {
        this.date = generateRandDate();
        var response = super.updateExistingCartUsingPut(userId, date, productId, quantity);
        assertNullInBody(response, nullValue(), equalTo(date), nullValue(), nullValue());
    }

    @RepeatedTest(value = 10, name = "update date field using wrong regex {currentRepetition} of {totalRepetitions}")
    @DisplayName("update date field using wrong regex test")
    @Tag("PutCart")
    @Epic("PUT METHOD, CART")
    @Step
    public void updateDateFieldUsingWrongRegexTest() {
        this.date = generateRandInt(1, Integer.MAX_VALUE);
        var response = super.updateExistingCartUsingPut(userId, date, productId, quantity);
        assertNullInBody(response, nullValue(), equalTo(date), nullValue(), nullValue());
    }

    @RepeatedTest(value = 10, name = "update product ID field {currentRepetition} of {totalRepetitions}")
    @DisplayName("update product ID field test")
    @Tag("PutCart")
    @Epic("PUT METHOD, CART")
    @Step
    public void updateProductIdFieldTest() {
        this.productId = generateRandInt(1, Integer.MAX_VALUE);
        var response = super.updateExistingCartUsingPut(userId, date, productId, quantity);
        assertNullInBody(response, nullValue(), nullValue(), equalTo(productId), nullValue());
    }

    @RepeatedTest(value = 10, name = "update product ID field using negative numbers {currentRepetition} of {totalRepetitions}")
    @DisplayName("update product ID field using negative numbers test")
    @Tag("PutCart")
    @Epic("PUT METHOD, CART")
    @Step
    public void updateProductIdFieldUsingNegativeNumbersTest() {
        this.productId = generateRandInt(Integer.MIN_VALUE, -1);
        var response = super.updateExistingCartUsingPut(userId, date, productId, quantity);
        assertNullInBody(response, nullValue(), nullValue(), equalTo(productId), nullValue());
    }

    @RepeatedTest(value = 10, name = "update quantity field {currentRepetition} of {totalRepetitions}")
    @DisplayName("update quantity field test")
    @Tag("PutCart")
    @Epic("PUT METHOD, CART")
    @Step
    public void updateQuantityFieldTest() {
        this.quantity = generateRandInt(1, Integer.MAX_VALUE);
        var response = super.updateExistingCartUsingPut(userId, date, productId, quantity);
        assertNullInBody(response, nullValue(), equalTo(date), nullValue(), equalTo(quantity));
    }

    @RepeatedTest(value = 10, name = "update quantity field using negative numbers {currentRepetition} of {totalRepetitions}")
    @DisplayName("update quantity field using negative numbers test")
    @Tag("PutCart")
    @Epic("PUT METHOD, CART")
    @Step
    public void updateQuantityFieldUsingNegativeNumbersTest() {
        this.quantity = generateRandInt(Integer.MIN_VALUE, -1);
        var response = super.updateExistingCartUsingPut(userId, date, productId, quantity);
        assertNullInBody(response, nullValue(), equalTo(date), nullValue(), equalTo(quantity));
    }

    @RepeatedTest(value = 10, name = "update all fields {currentRepetition} of {totalRepetitions}")
    @DisplayName("update all fields test")
    @Tag("PutCart")
    @Epic("PUT METHOD, CART")
    @Step
    public void updateAllFieldsTest() {
        this.userId = generateRandInt(1, Integer.MAX_VALUE);
        this.date = generateRandDate();
        this.productId = generateRandInt(1, Integer.MAX_VALUE);
        this.quantity = generateRandInt(1, Integer.MAX_VALUE);
        var response = super.updateExistingCartUsingPut(userId, date, productId, quantity);
        response.then().body(UPDATE_CART_SCHEMA);
        assertNullInBody(response, equalTo(userId), equalTo(date), equalTo(productId), equalTo(quantity));
    }

    @RepeatedTest(value = 10, name = "update no fields {currentRepetition} of {totalRepetitions}")
    @DisplayName("update no fields test")
    @Tag("PutCart")
    @Epic("PUT METHOD, CART")
    @Step
    public void updateNoFieldsTest() {
        var response = super.updateExistingCartUsingPut(userId, date, productId, quantity);
        assertNullInBody(response, nullValue(), nullValue(), nullValue(), nullValue());
    }

    @RepeatedTest(value = 10, name = "update all fields with random ID pathParams {currentRepetition} of {totalRepetitions}")
    @DisplayName("update all fields with random ID pathParams test")
    @Tag("PutCart")
    @Epic("PUT METHOD, CART")
    @Step
    public void updateFieldsUsingIdParameterTest() {
        this.id = generateRandInt(1, Integer.MAX_VALUE);
        this.userId = generateRandInt(1, Integer.MAX_VALUE);
        this.date = generateRandDate();
        this.productId = generateRandInt(1, Integer.MAX_VALUE);
        this.quantity = generateRandInt(1, Integer.MAX_VALUE);
        var response = super.updateExistingCartUsingPut(id, userId, date, productId, quantity);
        response.then().body(UPDATE_CART_SCHEMA);
        assertNullInBody(response, equalTo(id), equalTo(userId), equalTo(date), equalTo(productId), equalTo(quantity));
    }

    @RepeatedTest(value = 10, name = "update all fields with random ID pathParams using negative integers {currentRepetition} of {totalRepetitions}")
    @DisplayName("update all fields with random ID pathParams test")
    @Tag("PutCart")
    public void updateFieldsUsingIdParameterUsingNegativeIntegersTest() {
        this.id = generateRandInt(Integer.MIN_VALUE, -1);
        this.userId = generateRandInt(1, Integer.MAX_VALUE);
        this.date = generateRandDate();
        this.productId = generateRandInt(1, Integer.MAX_VALUE);
        this.quantity = generateRandInt(1, Integer.MAX_VALUE);
        var response = super.updateExistingCartUsingPut(id, userId, date, productId, quantity);
        response.then().body(UPDATE_CART_SCHEMA);
        assertNullInBody(response, equalTo(id), equalTo(userId), equalTo(date), equalTo(productId), equalTo(quantity));
    }

    @RepeatedTest(value = 10, name = "patch user ID field {currentRepetition} of {totalRepetitions}")
    @DisplayName("patch user ID field test")
    @Tag("PatchCart")
    @Epic("PATCH METHOD, CART")
    @Step
    public void patchUserIDFieldTest() {
        this.userId = generateRandInt(1, Integer.MAX_VALUE);
        var response = super.updateExistingCartUsingPatch(userId, date, productId, quantity);

        assertNullInBody(response, equalTo(userId), nullValue(), nullValue(), nullValue());
    }

    @RepeatedTest(value = 10, name = "patch user ID field using negative numbers {currentRepetition} of {totalRepetitions}")
    @DisplayName("patch user ID field using negative numbers test")
    @Tag("PatchCart")
    @Epic("PATCH METHOD, CART")
    @Step
    public void patchUserIDFieldNegativeNumbersTest() {
        this.userId = generateRandInt(Integer.MIN_VALUE, -1);
        var response = super.updateExistingCartUsingPatch(userId, date, productId, quantity);
        assertNullInBody(response, equalTo(userId), nullValue(), nullValue(), nullValue());
    }

    @RepeatedTest(value = 10, name = "patch date field {currentRepetition} of {totalRepetitions}")
    @DisplayName("patch date field test")
    @Tag("PatchCart")
    @Epic("PATCH METHOD, CART")
    @Step
    public void patchDateFieldTest() {
        this.date = generateRandDate();
        var response = super.updateExistingCartUsingPatch(userId, date, productId, quantity);
        assertNullInBody(response, nullValue(), equalTo(date), nullValue(), nullValue());
    }

    @RepeatedTest(value = 10, name = "patch date field using wrong regex {currentRepetition} of {totalRepetitions}")
    @DisplayName("patch date field using wrong regex test")
    @Tag("PatchCart")
    @Epic("PATCH METHOD, CART")
    @Step
    public void patchDateFieldUsingWrongRegexTest() {
        this.date = generateRandInt(1, Integer.MAX_VALUE);
        var response = super.updateExistingCartUsingPatch(userId, date, productId, quantity);
        assertNullInBody(response, nullValue(), equalTo(date), nullValue(), nullValue());
    }

    @RepeatedTest(value = 10, name = "patch product ID field {currentRepetition} of {totalRepetitions}")
    @DisplayName("patch product ID field test")
    @Tag("PatchCart")
    @Epic("PATCH METHOD, CART")
    @Step
    public void patchProductIdFieldTest() {
        this.productId = generateRandInt(1, Integer.MAX_VALUE);
        var response = super.updateExistingCartUsingPatch(userId, date, productId, quantity);
        assertNullInBody(response, nullValue(), nullValue(), equalTo(productId), nullValue());
    }

    @RepeatedTest(value = 10, name = "patch product ID field using negative numbers {currentRepetition} of {totalRepetitions}")
    @DisplayName("patch product ID field using negative numbers test")
    @Tag("PatchCart")
    @Epic("PATCH METHOD, CART")
    @Step
    public void patchProductIdFieldUsingNegativeNumbersTest() {
        this.productId = generateRandInt(Integer.MIN_VALUE, -1);
        var response = super.updateExistingCartUsingPatch(userId, date, productId, quantity);
        assertNullInBody(response, nullValue(), nullValue(), equalTo(productId), nullValue());
    }

    @RepeatedTest(value = 10, name = "patch quantity field {currentRepetition} of {totalRepetitions}")
    @DisplayName("patch quantity field test")
    @Tag("PatchCart")
    @Epic("PATCH METHOD, CART")
    @Step
    public void patchQuantityFieldTest() {
        this.quantity = generateRandInt(1, Integer.MAX_VALUE);
        var response = super.updateExistingCartUsingPatch(userId, date, productId, quantity);
        assertNullInBody(response, nullValue(), equalTo(date), nullValue(), equalTo(quantity));
    }

    @RepeatedTest(value = 10, name = "patch quantity field using negative numbers {currentRepetition} of {totalRepetitions}")
    @DisplayName("patch quantity field using negative numbers test")
    @Tag("PatchCart")
    @Epic("PATCH METHOD, CART")
    @Step
    public void patchQuantityFieldUsingNegativeNumbersTest() {
        this.quantity = generateRandInt(Integer.MIN_VALUE, -1);
        var response = super.updateExistingCartUsingPatch(userId, date, productId, quantity);
        assertNullInBody(response, nullValue(), equalTo(date), nullValue(), equalTo(quantity));
    }

    @RepeatedTest(value = 10, name = "patch all fields {currentRepetition} of {totalRepetitions}")
    @DisplayName("patch all fields test")
    @Tag("PatchCart")
    @Epic("PATCH METHOD, CART")
    @Step
    public void patchAllFieldsTest() {
        this.userId = generateRandInt(1, Integer.MAX_VALUE);
        this.date = generateRandDate();
        this.productId = generateRandInt(1, Integer.MAX_VALUE);
        this.quantity = generateRandInt(1, Integer.MAX_VALUE);
        var response = super.updateExistingCartUsingPatch(userId, date, productId, quantity);
        response.then().body(UPDATE_CART_SCHEMA);
        assertNullInBody(response, equalTo(userId), equalTo(date), equalTo(productId), equalTo(quantity));
    }

    @RepeatedTest(value = 10, name = "patch no fields {currentRepetition} of {totalRepetitions}")
    @DisplayName("patch no fields test")
    @Tag("PatchCart")
    @Epic("PATCH METHOD, CART")
    @Step
    public void patchNoFieldsTest() {
        var response = super.updateExistingCartUsingPatch(userId, date, productId, quantity);
        assertNullInBody(response, nullValue(), nullValue(), nullValue(), nullValue());
    }

    @RepeatedTest(value = 10, name = "patch all fields with random ID pathParams {currentRepetition} of {totalRepetitions}")
    @DisplayName("patch all fields with random ID pathParams test")
    @Tag("PatchCart")
    @Epic("PATCH METHOD, CART")
    @Step
    public void patchFieldsUsingIdParameterTest() {
        this.id = generateRandInt(1, Integer.MAX_VALUE);
        this.userId = generateRandInt(1, Integer.MAX_VALUE);
        this.date = generateRandDate();
        this.productId = generateRandInt(1, Integer.MAX_VALUE);
        this.quantity = generateRandInt(1, Integer.MAX_VALUE);
        var response = super.updateExistingCartUsingPatch(id, userId, date, productId, quantity);
        response.then().body(UPDATE_CART_SCHEMA);
        assertNullInBody(response, equalTo(id), equalTo(userId), equalTo(date), equalTo(productId), equalTo(quantity));
    }

    @RepeatedTest(value = 10, name = "patch all fields with random ID pathParams using negative integers {currentRepetition} of {totalRepetitions}")
    @DisplayName("patch all fields with random ID pathParams test")
    @Tag("PatchCart")
    @Epic("PATCH METHOD, CART")
    @Step
    public void patchFieldsUsingIdParameterUsingNegativeIntegersTest() {
        this.id = generateRandInt(Integer.MIN_VALUE, -1);
        this.userId = generateRandInt(1, Integer.MAX_VALUE);
        this.date = generateRandDate();
        this.productId = generateRandInt(1, Integer.MAX_VALUE);
        this.quantity = generateRandInt(1, Integer.MAX_VALUE);
        var response = super.updateExistingCartUsingPatch(id, userId, date, productId, quantity);
        response.then().body(UPDATE_CART_SCHEMA);
        assertNullInBody(response, equalTo(id), equalTo(userId), equalTo(date), equalTo(productId), equalTo(quantity));
    }
}