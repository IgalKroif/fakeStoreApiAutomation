package fakeStoreApi.storeCarts.UPDATE;

import CreateRequest.UpdateCartRequest;
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
public class TestUpdateExistingCart extends UpdateCartRequest {
    Object id = null;
    Object userId = null;
    Object date = null;
    Object productId = null;
    Object quantity = null;

    @RepeatedTest(10)
    @DisplayName("update user ID field test")
    @Tag("PutCart")
    public void updateUserIDFieldTest() {
        this.userId = generateRandInt(1, Integer.MAX_VALUE);
        var response = super.updateExistingCartUsingPut(userId, date, productId, quantity);
        assertNullInBody(response, equalTo(userId), nullValue(), nullValue(), nullValue());
    }

    @RepeatedTest(10)
    @DisplayName("update user ID field using negative numbers test")
    @Tag("PutCart")
    public void updateUserIDFieldNegativeNumbersTest() {
        this.userId = generateRandInt(Integer.MIN_VALUE, -1);
        var response = super.updateExistingCartUsingPut(userId, date, productId, quantity);
        assertNullInBody(response, equalTo(userId), nullValue(), nullValue(), nullValue());
    }

    @RepeatedTest(10)
    @DisplayName("update date field test")
    @Tag("PutCart")
    public void updateDateFieldTest() {
        this.date = generateRandDate();
        var response = super.updateExistingCartUsingPut(userId, date, productId, quantity);
        assertNullInBody(response, nullValue(), equalTo(date), nullValue(), nullValue());
    }

    @RepeatedTest(10)
    @DisplayName("update date field using wrong regex test")
    @Tag("PutCart")
    public void updateDateFieldUsingWrongRegexTest() {
        this.date = generateRandInt(1, Integer.MAX_VALUE);
        var response = super.updateExistingCartUsingPut(userId, date, productId, quantity);
        assertNullInBody(response, nullValue(), equalTo(date), nullValue(), nullValue());
    }

    @RepeatedTest(10)
    @DisplayName("update product ID field test")
    @Tag("PutCart")
    public void updateProductIdFieldTest() {
        this.productId = generateRandInt(1, Integer.MAX_VALUE);
        var response = super.updateExistingCartUsingPut(userId, date, productId, quantity);
        assertNullInBody(response, nullValue(), nullValue(), equalTo(productId), nullValue());
    }

    @RepeatedTest(10)
    @DisplayName("update product ID field using negative numbers test")
    @Tag("PutCart")
    public void updateProductIdFieldUsingNegativeNumbersTest() {
        this.productId = generateRandInt(Integer.MIN_VALUE, -1);
        var response = super.updateExistingCartUsingPut(userId, date, productId, quantity);
        assertNullInBody(response, nullValue(), nullValue(), equalTo(productId), nullValue());
    }

    @RepeatedTest(10)
    @DisplayName("update quantity field test")
    @Tag("PutCart")
    public void updateQuantityFieldTest() {
        this.quantity = generateRandInt(1, Integer.MAX_VALUE);
        var response = super.updateExistingCartUsingPut(userId, date, productId, quantity);
        assertNullInBody(response, nullValue(), equalTo(date), nullValue(), equalTo(quantity));
    }

    @RepeatedTest(10)
    @DisplayName("update quantity field using negative numbers test")
    @Tag("PutCart")
    public void updateQuantityFieldUsingNegativeNumbersTest() {
        this.quantity = generateRandInt(Integer.MIN_VALUE, -1);
        var response = super.updateExistingCartUsingPut(userId, date, productId, quantity);
        assertNullInBody(response, nullValue(), equalTo(date), nullValue(), equalTo(quantity));
    }

    @RepeatedTest(10)
    @DisplayName("update all fields test")
    @Tag("PutCart")
    public void updateAllFieldsTest() {
        this.userId = generateRandInt(1, Integer.MAX_VALUE);
        this.date = generateRandDate();
        this.productId = generateRandInt(1, Integer.MAX_VALUE);
        this.quantity = generateRandInt(1, Integer.MAX_VALUE);
        var response = super.updateExistingCartUsingPut(userId, date, productId, quantity);
        assertNullInBody(response, equalTo(userId), equalTo(date), equalTo(productId), equalTo(quantity));
    }

    @RepeatedTest(10)
    @DisplayName("update no fields test")
    @Tag("PutCart")
    public void updateNoFieldsTest() {
        var response = super.updateExistingCartUsingPut(userId, date, productId, quantity);
        assertNullInBody(response, nullValue(), nullValue(), nullValue(), nullValue());
    }

    @RepeatedTest(10)
    @DisplayName("update all fields with random ID pathParams test")
    @Tag("PutCart")
    public void updateFieldsUsingIdParameterTest() {
        this.id = generateRandInt(1, Integer.MAX_VALUE);
        this.userId = generateRandInt(1, Integer.MAX_VALUE);
        this.date = generateRandDate();
        this.productId = generateRandInt(1, Integer.MAX_VALUE);
        this.quantity = generateRandInt(1, Integer.MAX_VALUE);
        var response = super.updateExistingCartUsingPut(id, userId, date, productId, quantity);
        assertNullInBody(response, equalTo(id), equalTo(userId), equalTo(date), equalTo(productId), equalTo(quantity));
    }

    @RepeatedTest(10)
    @DisplayName("update all fields with random ID pathParams test")
    @Tag("PutCart")
    public void updateFieldsUsingIdParameterUsingNegativeIntegersTest() {
        this.id = generateRandInt(Integer.MIN_VALUE, -1);
        this.userId = generateRandInt(1, Integer.MAX_VALUE);
        this.date = generateRandDate();
        this.productId = generateRandInt(1, Integer.MAX_VALUE);
        this.quantity = generateRandInt(1, Integer.MAX_VALUE);
        var response = super.updateExistingCartUsingPut(id, userId, date, productId, quantity);
        assertNullInBody(response, equalTo(id), equalTo(userId), equalTo(date), equalTo(productId), equalTo(quantity));
    }

    @RepeatedTest(10)
    @DisplayName("patch user ID field test")
    @Tag("PatchCart")
    public void patchUserIDFieldTest() {
        this.userId = generateRandInt(1, Integer.MAX_VALUE);
        var response = super.updateExistingCartUsingPatch(userId, date, productId, quantity);
        assertNullInBody(response, equalTo(userId), nullValue(), nullValue(), nullValue());
    }

    @RepeatedTest(10)
    @DisplayName("patch user ID field using negative numbers test")
    @Tag("PatchCart")
    public void patchUserIDFieldNegativeNumbersTest() {
        this.userId = generateRandInt(Integer.MIN_VALUE, -1);
        var response = super.updateExistingCartUsingPatch(userId, date, productId, quantity);
        assertNullInBody(response, equalTo(userId), nullValue(), nullValue(), nullValue());
    }

    @RepeatedTest(10)
    @DisplayName("patch date field test")
    @Tag("PatchCart")
    public void patchDateFieldTest() {
        this.date = generateRandDate();
        var response = super.updateExistingCartUsingPatch(userId, date, productId, quantity);
        assertNullInBody(response, nullValue(), equalTo(date), nullValue(), nullValue());
    }

    @RepeatedTest(10)
    @DisplayName("patch date field using wrong regex test")
    @Tag("PatchCart")
    public void patchDateFieldUsingWrongRegexTest() {
        this.date = generateRandInt(1, Integer.MAX_VALUE);
        var response = super.updateExistingCartUsingPatch(userId, date, productId, quantity);
        assertNullInBody(response, nullValue(), equalTo(date), nullValue(), nullValue());
    }

    @RepeatedTest(10)
    @DisplayName("patch product ID field test")
    @Tag("PatchCart")
    public void patchProductIdFieldTest() {
        this.productId = generateRandInt(1, Integer.MAX_VALUE);
        var response = super.updateExistingCartUsingPatch(userId, date, productId, quantity);
        assertNullInBody(response, nullValue(), nullValue(), equalTo(productId), nullValue());
    }

    @RepeatedTest(10)
    @DisplayName("patch product ID field using negative numbers test")
    @Tag("PatchCart")
    public void patchProductIdFieldUsingNegativeNumbersTest() {
        this.productId = generateRandInt(Integer.MIN_VALUE, -1);
        var response = super.updateExistingCartUsingPatch(userId, date, productId, quantity);
        assertNullInBody(response, nullValue(), nullValue(), equalTo(productId), nullValue());
    }

    @RepeatedTest(10)
    @DisplayName("patch quantity field test")
    @Tag("PatchCart")
    public void patchQuantityFieldTest() {
        this.quantity = generateRandInt(1, Integer.MAX_VALUE);
        var response = super.updateExistingCartUsingPatch(userId, date, productId, quantity);
        assertNullInBody(response, nullValue(), equalTo(date), nullValue(), equalTo(quantity));
    }

    @RepeatedTest(10)
    @DisplayName("patch quantity field using negative numbers test")
    @Tag("PatchCart")
    public void patchQuantityFieldUsingNegativeNumbersTest() {
        this.quantity = generateRandInt(Integer.MIN_VALUE, -1);
        var response = super.updateExistingCartUsingPatch(userId, date, productId, quantity);
        assertNullInBody(response, nullValue(), equalTo(date), nullValue(), equalTo(quantity));
    }

    @RepeatedTest(10)
    @DisplayName("patch all fields test")
    @Tag("PatchCart")
    public void patchAllFieldsTest() {
        this.userId = generateRandInt(1, Integer.MAX_VALUE);
        this.date = generateRandDate();
        this.productId = generateRandInt(1, Integer.MAX_VALUE);
        this.quantity = generateRandInt(1, Integer.MAX_VALUE);
        var response = super.updateExistingCartUsingPatch(userId, date, productId, quantity);
        assertNullInBody(response, equalTo(userId), equalTo(date), equalTo(productId), equalTo(quantity));
    }

    @RepeatedTest(10)
    @DisplayName("patch no fields test")
    @Tag("PatchCart")
    public void patchNoFieldsTest() {
        var response = super.updateExistingCartUsingPatch(userId, date, productId, quantity);
        assertNullInBody(response, nullValue(), nullValue(), nullValue(), nullValue());
    }

    @RepeatedTest(10)
    @DisplayName("patch all fields with random ID pathParams test")
    @Tag("PatchCart")
    public void patchFieldsUsingIdParameterTest() {
        this.id = generateRandInt(1, Integer.MAX_VALUE);
        this.userId = generateRandInt(1, Integer.MAX_VALUE);
        this.date = generateRandDate();
        this.productId = generateRandInt(1, Integer.MAX_VALUE);
        this.quantity = generateRandInt(1, Integer.MAX_VALUE);
        var response = super.updateExistingCartUsingPatch(id, userId, date, productId, quantity);
        assertNullInBody(response, equalTo(id), equalTo(userId), equalTo(date), equalTo(productId), equalTo(quantity));
    }

    @RepeatedTest(10)
    @DisplayName("patch all fields with random ID pathParams test")
    @Tag("PatchCart")
    public void patchFieldsUsingIdParameterUsingNegativeIntegersTest() {
        this.id = generateRandInt(Integer.MIN_VALUE, -1);
        this.userId = generateRandInt(1, Integer.MAX_VALUE);
        this.date = generateRandDate();
        this.productId = generateRandInt(1, Integer.MAX_VALUE);
        this.quantity = generateRandInt(1, Integer.MAX_VALUE);
        var response = super.updateExistingCartUsingPatch(id, userId, date, productId, quantity);
        assertNullInBody(response, equalTo(id), equalTo(userId), equalTo(date), equalTo(productId), equalTo(quantity));
    }
}