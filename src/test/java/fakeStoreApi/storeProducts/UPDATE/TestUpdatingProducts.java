package fakeStoreApi.storeProducts.UPDATE;

import CreateRequest.product.UpdateProductRequest;
import fakeStoreApi.storeProducts.POST.TestCreatingProduct;
import groovy.util.logging.Slf4j;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.api.*;


import static org.hamcrest.Matchers.equalTo;
import static utils.validation.dataRandomizer.NumberRandomizer.generateRandInt;


@Slf4j
@Feature("PUT / PATCH METHODS : PRODUCTS ENDPOINT")
public class TestUpdatingProducts extends UpdateProductRequest {
    TestCreatingProduct requestBody = new TestCreatingProduct();

    @RepeatedTest(value = 10, name = "Put Product Title {currentRepetition} of {totalRepetitions}")
    @Tags({@Tag("PUT"), @Tag("PRODUCTS")})
    @DisplayName("Put Product Title")
    @Epic("PUT PRODUCT TITLE WITH STRING")
    @Step
    public void testPutProductTitleUsingStrings() {
        var product = requestBody.createProduct();
        String newTitle = requestBody.randString;
        product.setTitle(newTitle);
        var response = super.updateProductUsingPut(generateRandInt(1, 20), product);
        response.then().body("title", equalTo(newTitle));
    }

    @RepeatedTest(value = 10, name = "Put Product Title {currentRepetition} of {totalRepetitions}")
    @Tags({@Tag("PUT"), @Tag("PRODUCTS")})
    @DisplayName("Put Product Title")
    @Epic("PUT PRODUCT TITLE WITH INTEGER")
    @Step
    public void testPutProductTitleUsingIntegers() {
        var product = requestBody.createProduct();
        int newTitle = requestBody.randInt;
        product.setTitle(newTitle);
        var response = super.updateProductUsingPut(generateRandInt(1, 20), product);
        response.then().body("title", equalTo(newTitle));
    }

    @RepeatedTest(value = 10, name = "Put Product Title {currentRepetition} of {totalRepetitions}")
    @Tags({@Tag("PUT"), @Tag("PRODUCTS")})
    @DisplayName("Put Product Title")
    @Epic("PUT PRODUCT TITLE WITH FLOATS")
    @Step
    public void testPutProductTitleUsingFloats() {
        var product = requestBody.createProduct();
        float newTitle = requestBody.randFloat;
        product.setTitle(newTitle);
        var response = super.updateProductUsingPut(generateRandInt(1, 20), product);
        response.then().body("title", equalTo(newTitle));
    }

    @RepeatedTest(value = 10, name = "Put Product Title {currentRepetition} of {totalRepetitions}")
    @Tags({@Tag("PUT"), @Tag("PRODUCTS")})
    @DisplayName("Put Product Title")
    @Epic("PUT PRODUCT TITLE WITH BOOLEAN")
    @Step
    public void testPutProductTitleUsingBooleans() {
        var product = requestBody.createProduct();
        boolean newTitle = requestBody.randBoolean;
        product.setTitle(newTitle);
        var response = super.updateProductUsingPut(generateRandInt(1, 20), product);
        response.then().body("title", equalTo(newTitle));
    }

    @RepeatedTest(value = 10, name = "Put Product Price {currentRepetition} of {totalRepetitions}")
    @Tags({@Tag("PUT"), @Tag("PRODUCTS")})
    @DisplayName("Put Product Price")
    @Epic("PUT PRODUCT PRICE WITH STRING")
    @Step
    public void testPutProductPriceUsingStrings() {
        var product = requestBody.createProduct();
        String newPrice = requestBody.randString;
        product.setImage(newPrice);
        var response = super.updateProductUsingPut(generateRandInt(1, 20), product);
        response.then().body("image", equalTo(newPrice));
    }

    @RepeatedTest(value = 10, name = "Put Product Price {currentRepetition} of {totalRepetitions}")
    @Tags({@Tag("PUT"), @Tag("PRODUCTS")})
    @DisplayName("Put Product Price")
    @Epic("PUT PRODUCT PRICE WITH INTEGER")
    @Step
    public void testPutProductPriceUsingIntegers() {
        var product = requestBody.createProduct();
        int newPrice = requestBody.randInt;
        product.setImage(newPrice);
        var response = super.updateProductUsingPut(generateRandInt(1, 20), product);
        response.then().body("image", equalTo(newPrice));
    }

    @RepeatedTest(value = 10, name = "Put Product Price {currentRepetition} of {totalRepetitions}")
    @Tags({@Tag("PUT"), @Tag("PRODUCTS")})
    @DisplayName("Put Product Price")
    @Epic("PUT PRODUCT PRICE WITH FLOATS")
    @Step
    public void testPutProductPriceUsingFloats() {
        var product = requestBody.createProduct();
        float newPrice = requestBody.randFloat + 0.01F;
        product.setImage(newPrice);
        var response = super.updateProductUsingPut(generateRandInt(1, 20), product);
        response.then().body("image", equalTo(newPrice));
    }

    @RepeatedTest(value = 10, name = "Put Product Price {currentRepetition} of {totalRepetitions}")
    @Tags({@Tag("PUT"), @Tag("PRODUCTS")})
    @DisplayName("Put Product Price")
    @Epic("PUT PRODUCT PRICE WITH BOOLEAN")
    @Step
    public void testPutProductPriceUsingBooleans() {
        var product = requestBody.createProduct();
        boolean newPrice = requestBody.randBoolean;
        product.setImage(newPrice);
        var response = super.updateProductUsingPut(generateRandInt(1, 20), product);
        response.then().body("image", equalTo(newPrice));
    }

    @RepeatedTest(value = 10, name = "Put Product Description {currentRepetition} of {totalRepetitions}")
    @Tags({@Tag("PUT"), @Tag("PRODUCTS")})
    @DisplayName("Put Product Description")
    @Epic("PUT PRODUCT DESCRIPTION WITH STRING")
    @Step
    public void testPutProductDescriptionUsingStrings() {
        var product = requestBody.createProduct();
        String newDescription = requestBody.randString;
        product.setDescription(newDescription);
        var response = super.updateProductUsingPut(generateRandInt(1, 20), product);
        response.then().body("description", equalTo(newDescription));
    }

    @RepeatedTest(value = 10, name = "Put Product Description {currentRepetition} of {totalRepetitions}")
    @Tags({@Tag("PUT"), @Tag("PRODUCTS")})
    @DisplayName("Put Product Description")
    @Epic("PUT PRODUCT DESCRIPTION WITH INTEGER")
    @Step
    public void testPutProductDescriptionUsingIntegers() {
        var product = requestBody.createProduct();
        int newDescription = requestBody.randInt;
        product.setDescription(newDescription);
        var response = super.updateProductUsingPut(generateRandInt(1, 20), product);
        response.then().body("description", equalTo(newDescription));
    }

    @RepeatedTest(value = 10, name = "Put Product Description {currentRepetition} of {totalRepetitions}")
    @Tags({@Tag("PUT"), @Tag("PRODUCTS")})
    @DisplayName("Put Product Description")
    @Epic("PUT PRODUCT DESCRIPTION WITH FLOATS")
    @Step
    public void testPutProductDescriptionUsingFloats() {
        var product = requestBody.createProduct();
        float newDescription = requestBody.randFloat;
        product.setDescription(newDescription);
        var response = super.updateProductUsingPut(generateRandInt(1, 20), product);
        response.then().body("description", equalTo(newDescription));
    }

    @RepeatedTest(value = 10, name = "Put Product Description {currentRepetition} of {totalRepetitions}")
    @Tags({@Tag("PUT"), @Tag("PRODUCTS")})
    @DisplayName("Put Product Description")
    @Epic("PUT PRODUCT DESCRIPTION WITH BOOLEAN")
    @Step
    public void testPutProductDescriptionUsingBooleans() {
        var product = requestBody.createProduct();
        boolean newDescription = requestBody.randBoolean;
        product.setDescription(newDescription);
        var response = super.updateProductUsingPut(generateRandInt(1, 20), product);
        response.then().body("description", equalTo(newDescription));
    }

    @RepeatedTest(value = 10, name = "Put Product Category {currentRepetition} of {totalRepetitions}")
    @Tags({@Tag("PUT"), @Tag("PRODUCTS")})
    @DisplayName("Put Product Category")
    @Epic("PUT PRODUCT CATEGORY WITH STRING")
    @Step
    public void testPutProductCategoryUsingStrings() {
        var product = requestBody.createProduct();
        String newCategory = requestBody.randString;
        product.setCategory(newCategory);
        var response = super.updateProductUsingPut(generateRandInt(1, 20), product);
        response.then().body("category", equalTo(newCategory));
    }

    @RepeatedTest(value = 10, name = "Put Product Category {currentRepetition} of {totalRepetitions}")
    @Tags({@Tag("PUT"), @Tag("PRODUCTS")})
    @DisplayName("Put Product Category")
    @Epic("PUT PRODUCT CATEGORY WITH INTEGER")
    @Step
    public void testPutProductCategoryUsingIntegers() {
        var product = requestBody.createProduct();
        int newCategory = requestBody.randInt;
        product.setCategory(newCategory);
        var response = super.updateProductUsingPut(generateRandInt(1, 20), product);
        response.then().body("category", equalTo(newCategory));
    }

    @RepeatedTest(value = 10, name = "Put Product Category {currentRepetition} of {totalRepetitions}")
    @Tags({@Tag("PUT"), @Tag("PRODUCTS")})
    @DisplayName("Put Product Category")
    @Epic("PUT PRODUCT CATEGORY WITH FLOATS")
    @Step
    public void testPutProductCategoryUsingFloats() {
        var product = requestBody.createProduct();
        float newCategory = requestBody.randFloat;
        product.setCategory(newCategory);
        var response = super.updateProductUsingPut(generateRandInt(1, 20), product);
        response.then().body("category", equalTo(newCategory));
    }

    @RepeatedTest(value = 10, name = "Put Product Category {currentRepetition} of {totalRepetitions}")
    @Tags({@Tag("PUT"), @Tag("PRODUCTS")})
    @DisplayName("Put Product Category")
    @Epic("PUT PRODUCT CATEGORY WITH BOOLEAN")
    @Step
    public void testPutProductCategoryUsingBooleans() {
        var product = requestBody.createProduct();
        boolean newCategory = requestBody.randBoolean;
        product.setCategory(newCategory);
        var response = super.updateProductUsingPut(generateRandInt(1, 20), product);
        response.then().body("category", equalTo(newCategory));
    }

    @RepeatedTest(value = 10, name = "Put Product Image {currentRepetition} of {totalRepetitions}")
    @Tags({@Tag("PUT"), @Tag("PRODUCTS")})
    @DisplayName("Put Product Image")
    @Epic("PUT PRODUCT IMAGE WITH STRING")
    @Step
    public void testPutProductImageUsingStrings() {
        var product = requestBody.createProduct();
        String newImage = requestBody.randString;
        product.setImage(newImage);
        var response = super.updateProductUsingPut(generateRandInt(1, 20), product);
        response.then().body("image", equalTo(newImage));
    }

    @RepeatedTest(value = 10, name = "Put Product Image {currentRepetition} of {totalRepetitions}")
    @Tags({@Tag("PUT"), @Tag("PRODUCTS")})
    @DisplayName("Put Product Image")
    @Epic("PUT PRODUCT IMAGE WITH INTEGER")
    @Step
    public void testPutProductImageUsingIntegers() {
        var product = requestBody.createProduct();
        int newImage = requestBody.randInt;
        product.setImage(newImage);
        var response = super.updateProductUsingPut(generateRandInt(1, 20), product);
        response.then().body("image", equalTo(newImage));
    }

    @RepeatedTest(value = 10, name = "Put Product Image {currentRepetition} of {totalRepetitions}")
    @Tags({@Tag("PUT"), @Tag("PRODUCTS")})
    @DisplayName("Put Product Image")
    @Epic("PUT PRODUCT IMAGE WITH FLOATS")
    @Step
    public void testPutProductImageUsingFloats() {
        var product = requestBody.createProduct();
        float newImage = requestBody.randFloat;
        product.setImage(newImage);
        var response = super.updateProductUsingPut(generateRandInt(1, 20), product);
        response.then().body("image", equalTo(newImage));
    }

    @RepeatedTest(value = 10, name = "Put Product Image {currentRepetition} of {totalRepetitions}")
    @Tags({@Tag("PUT"), @Tag("PRODUCTS")})
    @DisplayName("Put Product Image")
    @Epic("PUT PRODUCT IMAGE WITH BOOLEAN")
    @Step
    public void testPutProductImageUsingBooleans() {
        var product = requestBody.createProduct();
        boolean newImage = requestBody.randBoolean;
        product.setImage(newImage);
        var response = super.updateProductUsingPut(generateRandInt(1, 20), product);
        response.then().body("image", equalTo(newImage));
    }


    @RepeatedTest(value = 10, name = "Patch Product Title {currentRepetition} of {totalRepetitions}")
    @Tags({@Tag("PATCH"), @Tag("PRODUCTS")})
    @DisplayName("Patch Product Title")
    @Epic("PATCH PRODUCT TITLE WITH STRING")
    @Step
    public void testPatchProductTitleUsingStrings() {
        var product = requestBody.createProduct();
        String newTitle = requestBody.randString;
        product.setTitle(newTitle);
        var response = super.updateProductUsingPatch(generateRandInt(1, 20), product);
        response.then().body("title", equalTo(newTitle));
    }

    @RepeatedTest(value = 10, name = "Patch Product Title {currentRepetition} of {totalRepetitions}")
    @Tags({@Tag("PATCH"), @Tag("PRODUCTS")})
    @DisplayName("Patch Product Title")
    @Epic("PATCH PRODUCT TITLE WITH INTEGER")
    @Step
    public void testPatchProductTitleUsingIntegers() {
        var product = requestBody.createProduct();
        int newTitle = requestBody.randInt;
        product.setTitle(newTitle);
        var response = super.updateProductUsingPatch(generateRandInt(1, 20), product);
        response.then().body("title", equalTo(newTitle));
    }

    @RepeatedTest(value = 10, name = "Patch Product Title {currentRepetition} of {totalRepetitions}")
    @Tags({@Tag("PATCH"), @Tag("PRODUCTS")})
    @DisplayName("Patch Product Title")
    @Epic("PATCH PRODUCT TITLE WITH FLOATS")
    @Step
    public void testPatchProductTitleUsingFloats() {
        var product = requestBody.createProduct();
        float newTitle = requestBody.randFloat;
        product.setTitle(newTitle);
        var response = super.updateProductUsingPatch(generateRandInt(1, 20), product);
        response.then().body("title", equalTo(newTitle));
    }

    @RepeatedTest(value = 10, name = "Patch Product Title {currentRepetition} of {totalRepetitions}")
    @Tags({@Tag("PATCH"), @Tag("PRODUCTS")})
    @DisplayName("Patch Product Title")
    @Epic("PATCH PRODUCT TITLE WITH BOOLEAN")
    @Step
    public void testPatchProductTitleUsingBooleans() {
        var product = requestBody.createProduct();
        boolean newTitle = requestBody.randBoolean;
        product.setTitle(newTitle);
        var response = super.updateProductUsingPatch(generateRandInt(1, 20), product);
        response.then().body("title", equalTo(newTitle));
    }

    @RepeatedTest(value = 10, name = "Patch Product Price {currentRepetition} of {totalRepetitions}")
    @Tags({@Tag("PATCH"), @Tag("PRODUCTS")})
    @DisplayName("Patch Product Price")
    @Epic("PATCH PRODUCT PRICE WITH STRING")
    @Step
    public void testPatchProductPriceUsingStrings() {
        var product = requestBody.createProduct();
        String newPrice = requestBody.randString;
        product.setImage(newPrice);
        var response = super.updateProductUsingPatch(generateRandInt(1, 20), product);
        response.then().body("image", equalTo(newPrice));
    }

    @RepeatedTest(value = 10, name = "Patch Product Price {currentRepetition} of {totalRepetitions}")
    @Tags({@Tag("PATCH"), @Tag("PRODUCTS")})
    @DisplayName("Patch Product Price")
    @Epic("PATCH PRODUCT PRICE WITH INTEGER")
    @Step
    public void testPatchProductPriceUsingIntegers() {
        var product = requestBody.createProduct();
        int newPrice = requestBody.randInt;
        product.setImage(newPrice);
        var response = super.updateProductUsingPatch(generateRandInt(1, 20), product);
        response.then().body("image", equalTo(newPrice));
    }

    @RepeatedTest(value = 10, name = "Patch Product Price {currentRepetition} of {totalRepetitions}")
    @Tags({@Tag("PATCH"), @Tag("PRODUCTS")})
    @DisplayName("Patch Product Price")
    @Epic("PATCH PRODUCT PRICE WITH FLOATS")
    @Step
    public void testPatchProductPriceUsingFloats() {
        var product = requestBody.createProduct();
        float newPrice = requestBody.randFloat;
        product.setImage(newPrice);
        var response = super.updateProductUsingPatch(generateRandInt(1, 20), product);
        response.then().body("image", equalTo(newPrice));
    }

    @RepeatedTest(value = 10, name = "Patch Product Price {currentRepetition} of {totalRepetitions}")
    @Tags({@Tag("PATCH"), @Tag("PRODUCTS")})
    @DisplayName("Patch Product Price")
    @Epic("PATCH PRODUCT PRICE WITH BOOLEAN")
    @Step
    public void testPatchProductPriceUsingBooleans() {
        var product = requestBody.createProduct();
        boolean newPrice = requestBody.randBoolean;
        product.setImage(newPrice);
        var response = super.updateProductUsingPatch(generateRandInt(1, 20), product);
        response.then().body("image", equalTo(newPrice));
    }

    @RepeatedTest(value = 10, name = "Patch Product Description {currentRepetition} of {totalRepetitions}")
    @Tags({@Tag("PATCH"), @Tag("PRODUCTS")})
    @DisplayName("Patch Product Description")
    @Epic("PATCH PRODUCT DESCRIPTION WITH STRING")
    @Step
    public void testPatchProductDescriptionUsingStrings() {
        var product = requestBody.createProduct();
        String newDescription = requestBody.randString;
        product.setDescription(newDescription);
        var response = super.updateProductUsingPatch(generateRandInt(1, 20), product);
        response.then().body("description", equalTo(newDescription));
    }

    @RepeatedTest(value = 10, name = "Patch Product Description {currentRepetition} of {totalRepetitions}")
    @Tags({@Tag("PATCH"), @Tag("PRODUCTS")})
    @DisplayName("Patch Product Description")
    @Epic("PATCH PRODUCT DESCRIPTION WITH INTEGER")
    @Step
    public void testPatchProductDescriptionUsingIntegers() {
        var product = requestBody.createProduct();
        int newDescription = requestBody.randInt;
        product.setDescription(newDescription);
        var response = super.updateProductUsingPatch(generateRandInt(1, 20), product);
        response.then().body("description", equalTo(newDescription));
    }

    @RepeatedTest(value = 10, name = "Patch Product Description {currentRepetition} of {totalRepetitions}")
    @Tags({@Tag("PATCH"), @Tag("PRODUCTS")})
    @DisplayName("Patch Product Description")
    @Epic("PATCH PRODUCT DESCRIPTION WITH FLOATS")
    @Step
    public void testPatchProductDescriptionUsingFloats() {
        var product = requestBody.createProduct();
        float newDescription = requestBody.randFloat;
        product.setDescription(newDescription);
        var response = super.updateProductUsingPatch(generateRandInt(1, 20), product);
        response.then().body("description", equalTo(newDescription));
    }

    @RepeatedTest(value = 10, name = "Patch Product Description {currentRepetition} of {totalRepetitions}")
    @Tags({@Tag("PATCH"), @Tag("PRODUCTS")})
    @DisplayName("Patch Product Description")
    @Epic("PATCH PRODUCT DESCRIPTION WITH BOOLEAN")
    @Step
    public void testPatchProductDescriptionUsingBooleans() {
        var product = requestBody.createProduct();
        boolean newDescription = requestBody.randBoolean;
        product.setDescription(newDescription);
        var response = super.updateProductUsingPatch(generateRandInt(1, 20), product);
        response.then().body("description", equalTo(newDescription));
    }

    @RepeatedTest(value = 10, name = "Patch Product Category {currentRepetition} of {totalRepetitions}")
    @Tags({@Tag("PATCH"), @Tag("PRODUCTS")})
    @DisplayName("Patch Product Category")
    @Epic("PATCH PRODUCT CATEGORY WITH STRING")
    @Step
    public void testPatchProductCategoryUsingStrings() {
        var product = requestBody.createProduct();
        String newCategory = requestBody.randString;
        product.setCategory(newCategory);
        var response = super.updateProductUsingPatch(generateRandInt(1, 20), product);
        response.then().body("category", equalTo(newCategory));
    }

    @RepeatedTest(value = 10, name = "Patch Product Category {currentRepetition} of {totalRepetitions}")
    @Tags({@Tag("PATCH"), @Tag("PRODUCTS")})
    @DisplayName("Patch Product Category")
    @Epic("PATCH PRODUCT CATEGORY WITH INTEGER")
    @Step
    public void testPatchProductCategoryUsingIntegers() {
        var product = requestBody.createProduct();
        int newCategory = requestBody.randInt;
        product.setCategory(newCategory);
        var response = super.updateProductUsingPatch(generateRandInt(1, 20), product);
        response.then().body("category", equalTo(newCategory));
    }

    @RepeatedTest(value = 10, name = "Patch Product Category {currentRepetition} of {totalRepetitions}")
    @Tags({@Tag("PATCH"), @Tag("PRODUCTS")})
    @DisplayName("Patch Product Category")
    @Epic("PATCH PRODUCT CATEGORY WITH FLOATS")
    @Step
    public void testPatchProductCategoryUsingFloats() {
        var product = requestBody.createProduct();
        float newCategory = requestBody.randFloat;
        product.setCategory(newCategory);
        var response = super.updateProductUsingPatch(generateRandInt(1, 20), product);
        response.then().body("category", equalTo(newCategory));
    }

    @RepeatedTest(value = 10, name = "Patch Product Category {currentRepetition} of {totalRepetitions}")
    @Tags({@Tag("PATCH"), @Tag("PRODUCTS")})
    @DisplayName("Patch Product Category")
    @Epic("PATCH PRODUCT CATEGORY WITH BOOLEAN")
    @Step
    public void testPatchProductCategoryUsingBooleans() {
        var product = requestBody.createProduct();
        boolean newCategory = requestBody.randBoolean;
        product.setCategory(newCategory);
        var response = super.updateProductUsingPatch(generateRandInt(1, 20), product);
        response.then().body("category", equalTo(newCategory));
    }

    @RepeatedTest(value = 10, name = "Patch Product Image {currentRepetition} of {totalRepetitions}")
    @Tags({@Tag("PATCH"), @Tag("PRODUCTS")})
    @DisplayName("Patch Product Image")
    @Epic("PATCH PRODUCT IMAGE WITH STRING")
    @Step
    public void testPatchProductImageUsingStrings() {
        var product = requestBody.createProduct();
        String newImage = requestBody.randString;
        product.setImage(newImage);
        var response = super.updateProductUsingPatch(generateRandInt(1, 20), product);
        response.then().body("image", equalTo(newImage));
    }

    @RepeatedTest(value = 10, name = "Patch Product Image {currentRepetition} of {totalRepetitions}")
    @Tags({@Tag("PATCH"), @Tag("PRODUCTS")})
    @DisplayName("Patch Product Image")
    @Epic("PATCH PRODUCT IMAGE WITH INTEGER")
    @Step
    public void testPatchProductImageUsingIntegers() {
        var product = requestBody.createProduct();
        int newImage = requestBody.randInt;
        product.setImage(newImage);
        var response = super.updateProductUsingPatch(generateRandInt(1, 20), product);
        response.then().body("image", equalTo(newImage));
    }

    @RepeatedTest(value = 10, name = "Patch Product Image {currentRepetition} of {totalRepetitions}")
    @Tags({@Tag("PATCH"), @Tag("PRODUCTS")})
    @DisplayName("Patch Product Image")
    @Epic("PATCH PRODUCT IMAGE WITH FLOATS")
    @Step
    public void testPatchProductImageUsingFloats() {
        var product = requestBody.createProduct();
        float newImage = requestBody.randFloat;
        product.setImage(newImage);
        var response = super.updateProductUsingPatch(generateRandInt(1, 20), product);
        response.then().body("image", equalTo(newImage));
    }

    @RepeatedTest(value = 10, name = "Patch Product Image {currentRepetition} of {totalRepetitions}")
    @Tags({@Tag("PATCH"), @Tag("PRODUCTS")})
    @DisplayName("Patch Product Image")
    @Epic("PATCH PRODUCT IMAGE WITH BOOLEAN")
    @Step
    public void testPatchProductImageUsingBooleans() {
        var product = requestBody.createProduct();
        boolean newImage = requestBody.randBoolean;
        product.setImage(newImage);
        var response = super.updateProductUsingPatch(generateRandInt(1, 20), product);
        response.then().body("image", equalTo(newImage));
    }
}