package fakeStoreApi.storeProducts.UPDATE;

import CreateRequest.product.UpdateProductRequest;
import fakeStoreApi.storeProducts.POST.TestCreatingProduct;
import org.junit.jupiter.api.*;


import static org.hamcrest.Matchers.equalTo;
import static utils.validation.dataRandomizer.NumberRandomizer.generateRandInt;

public class TestUpdatingProducts extends UpdateProductRequest {
    TestCreatingProduct requestBody = new TestCreatingProduct();

    @RepeatedTest(10)
    @Tags({@Tag("PUT"), @Tag("PRODUCTS")})
    @DisplayName("Put Product Title")
    public void testPutProductTitleUsingStrings() {
        var product = requestBody.createProduct();
        String newTitle = requestBody.randString;
        product.setTitle(newTitle);
        var response = super.updateProductUsingPut(generateRandInt(1, 20), product);
        response.then().body("title", equalTo(newTitle));
    }

    @RepeatedTest(10)
    @Tags({@Tag("PUT"), @Tag("PRODUCTS")})
    @DisplayName("Put Product Title")
    public void testPutProductTitleUsingIntegers() {
        var product = requestBody.createProduct();
        int newTitle = requestBody.randInt;
        product.setTitle(newTitle);
        var response = super.updateProductUsingPut(generateRandInt(1, 20), product);
        response.then().body("title", equalTo(newTitle));
    }

    @RepeatedTest(10)
    @Tags({@Tag("PUT"), @Tag("PRODUCTS")})
    @DisplayName("Put Product Title")
    public void testPutProductTitleUsingFloats() {
        var product = requestBody.createProduct();
        float newTitle = requestBody.randFloat;
        product.setTitle(newTitle);
        var response = super.updateProductUsingPut(generateRandInt(1, 20), product);
        response.then().body("title", equalTo(newTitle));
    }

    @RepeatedTest(10)
    @Tags({@Tag("PUT"), @Tag("PRODUCTS")})
    @DisplayName("Put Product Title")
    public void testPutProductTitleUsingBooleans() {
        var product = requestBody.createProduct();
        boolean newTitle = requestBody.randBoolean;
        product.setTitle(newTitle);
        var response = super.updateProductUsingPut(generateRandInt(1, 20), product);
        response.then().body("title", equalTo(newTitle));
    }

    @RepeatedTest(10)
    @Tags({@Tag("PUT"), @Tag("PRODUCTS")})
    @DisplayName("Put Product Price")
    public void testPutProductPriceUsingStrings() {
        var product = requestBody.createProduct();
        String newPrice = requestBody.randString;
        product.setImage(newPrice);
        var response = super.updateProductUsingPut(generateRandInt(1, 20), product);
        response.then().body("image", equalTo(newPrice));
    }

    @RepeatedTest(10)
    @Tags({@Tag("PUT"), @Tag("PRODUCTS")})
    @DisplayName("Put Product Price")
    public void testPutProductPriceUsingIntegers() {
        var product = requestBody.createProduct();
        int newPrice = requestBody.randInt;
        product.setImage(newPrice);
        var response = super.updateProductUsingPut(generateRandInt(1, 20), product);
        response.then().body("image", equalTo(newPrice));
    }

    @RepeatedTest(10)
    @Tags({@Tag("PUT"), @Tag("PRODUCTS")})
    @DisplayName("Put Product Price")
    public void testPutProductPriceUsingFloats() {
        var product = requestBody.createProduct();
        float newPrice = requestBody.randFloat + 0.1F;
        product.setImage(newPrice);
        var response = super.updateProductUsingPut(generateRandInt(1, 20), product);
        response.then().body("image", equalTo(newPrice));
    }

    @RepeatedTest(10)
    @Tags({@Tag("PUT"), @Tag("PRODUCTS")})
    @DisplayName("Put Product Price")
    public void testPutProductPriceUsingBooleans() {
        var product = requestBody.createProduct();
        boolean newPrice = requestBody.randBoolean;
        product.setImage(newPrice);
        var response = super.updateProductUsingPut(generateRandInt(1, 20), product);
        response.then().body("image", equalTo(newPrice));
    }

    @RepeatedTest(10)
    @Tags({@Tag("PUT"), @Tag("PRODUCTS")})
    @DisplayName("Put Product Description")
    public void testPutProductDescriptionUsingStrings() {
        var product = requestBody.createProduct();
        String newDescription = requestBody.randString;
        product.setDescription(newDescription);
        var response = super.updateProductUsingPut(generateRandInt(1, 20), product);
        response.then().body("description", equalTo(newDescription));
    }

    @RepeatedTest(10)
    @Tags({@Tag("PUT"), @Tag("PRODUCTS")})
    @DisplayName("Put Product Description")
    public void testPutProductDescriptionUsingIntegers() {
        var product = requestBody.createProduct();
        int newDescription = requestBody.randInt;
        product.setDescription(newDescription);
        var response = super.updateProductUsingPut(generateRandInt(1, 20), product);
        response.then().body("description", equalTo(newDescription));
    }

    @RepeatedTest(10)
    @Tags({@Tag("PUT"), @Tag("PRODUCTS")})
    @DisplayName("Put Product Description")
    public void testPutProductDescriptionUsingFloats() {
        var product = requestBody.createProduct();
        float newDescription = requestBody.randFloat;
        product.setDescription(newDescription);
        var response = super.updateProductUsingPut(generateRandInt(1, 20), product);
        response.then().body("description", equalTo(newDescription));
    }

    @RepeatedTest(10)
    @Tags({@Tag("PUT"), @Tag("PRODUCTS")})
    @DisplayName("Put Product Description")
    public void testPutProductDescriptionUsingBooleans() {
        var product = requestBody.createProduct();
        boolean newDescription = requestBody.randBoolean;
        product.setDescription(newDescription);
        var response = super.updateProductUsingPut(generateRandInt(1, 20), product);
        response.then().body("description", equalTo(newDescription));
    }

    @RepeatedTest(10)
    @Tags({@Tag("PUT"), @Tag("PRODUCTS")})
    @DisplayName("Put Product Category")
    public void testPutProductCategoryUsingStrings() {
        var product = requestBody.createProduct();
        String newCategory = requestBody.randString;
        product.setCategory(newCategory);
        var response = super.updateProductUsingPut(generateRandInt(1, 20), product);
        response.then().body("category", equalTo(newCategory));
    }

    @RepeatedTest(10)
    @Tags({@Tag("PUT"), @Tag("PRODUCTS")})
    @DisplayName("Put Product Category")
    public void testPutProductCategoryUsingIntegers() {
        var product = requestBody.createProduct();
        int newCategory = requestBody.randInt;
        product.setCategory(newCategory);
        var response = super.updateProductUsingPut(generateRandInt(1, 20), product);
        response.then().body("category", equalTo(newCategory));
    }

    @RepeatedTest(10)
    @Tags({@Tag("PUT"), @Tag("PRODUCTS")})
    @DisplayName("Put Product Category")
    public void testPutProductCategoryUsingFloats() {
        var product = requestBody.createProduct();
        float newCategory = requestBody.randFloat;
        product.setCategory(newCategory);
        var response = super.updateProductUsingPut(generateRandInt(1, 20), product);
        response.then().body("category", equalTo(newCategory));
    }

    @RepeatedTest(10)
    @Tags({@Tag("PUT"), @Tag("PRODUCTS")})
    @DisplayName("Put Product Category")
    public void testPutProductCategoryUsingBooleans() {
        var product = requestBody.createProduct();
        boolean newCategory = requestBody.randBoolean;
        product.setCategory(newCategory);
        var response = super.updateProductUsingPut(generateRandInt(1, 20), product);
        response.then().body("category", equalTo(newCategory));
    }

    @RepeatedTest(10)
    @Tags({@Tag("PUT"), @Tag("PRODUCTS")})
    @DisplayName("Put Product Image")
    public void testPutProductImageUsingStrings() {
        var product = requestBody.createProduct();
        String newImage = requestBody.randString;
        product.setImage(newImage);
        var response = super.updateProductUsingPut(generateRandInt(1, 20), product);
        response.then().body("image", equalTo(newImage));
    }

    @RepeatedTest(10)
    @Tags({@Tag("PUT"), @Tag("PRODUCTS")})
    @DisplayName("Put Product Image")
    public void testPutProductImageUsingIntegers() {
        var product = requestBody.createProduct();
        int newImage = requestBody.randInt;
        product.setImage(newImage);
        var response = super.updateProductUsingPut(generateRandInt(1, 20), product);
        response.then().body("image", equalTo(newImage));
    }

    @RepeatedTest(10)
    @Tags({@Tag("PUT"), @Tag("PRODUCTS")})
    @DisplayName("Put Product Image")
    public void testPutProductImageUsingFloats() {
        var product = requestBody.createProduct();
        float newImage = requestBody.randFloat;
        product.setImage(newImage);
        var response = super.updateProductUsingPut(generateRandInt(1, 20), product);
        response.then().body("image", equalTo(newImage));
    }

    @RepeatedTest(10)
    @Tags({@Tag("PUT"), @Tag("PRODUCTS")})
    @DisplayName("Put Product Image")
    public void testPutProductImageUsingBooleans() {
        var product = requestBody.createProduct();
        boolean newImage = requestBody.randBoolean;
        product.setImage(newImage);
        var response = super.updateProductUsingPut(generateRandInt(1, 20), product);
        response.then().body("image", equalTo(newImage));
    }


    @RepeatedTest(10)
    @Tags({@Tag("PATCH"), @Tag("PRODUCTS")})
    @DisplayName("Patch Product Title")
    public void testPatchProductTitleUsingStrings() {
        var product = requestBody.createProduct();
        String newTitle = requestBody.randString;
        product.setTitle(newTitle);
        var response = super.updateProductUsingPatch(generateRandInt(1, 20), product);
        response.then().body("title", equalTo(newTitle));
    }

    @RepeatedTest(10)
    @Tags({@Tag("PATCH"), @Tag("PRODUCTS")})
    @DisplayName("Patch Product Title")
    public void testPatchProductTitleUsingIntegers() {
        var product = requestBody.createProduct();
        int newTitle = requestBody.randInt;
        product.setTitle(newTitle);
        var response = super.updateProductUsingPatch(generateRandInt(1, 20), product);
        response.then().body("title", equalTo(newTitle));
    }

    @RepeatedTest(10)
    @Tags({@Tag("PATCH"), @Tag("PRODUCTS")})
    @DisplayName("Patch Product Title")
    public void testPatchProductTitleUsingFloats() {
        var product = requestBody.createProduct();
        float newTitle = requestBody.randFloat;
        product.setTitle(newTitle);
        var response = super.updateProductUsingPatch(generateRandInt(1, 20), product);
        response.then().body("title", equalTo(newTitle));
    }

    @RepeatedTest(10)
    @Tags({@Tag("PATCH"), @Tag("PRODUCTS")})
    @DisplayName("Patch Product Title")
    public void testPatchProductTitleUsingBooleans() {
        var product = requestBody.createProduct();
        boolean newTitle = requestBody.randBoolean;
        product.setTitle(newTitle);
        var response = super.updateProductUsingPatch(generateRandInt(1, 20), product);
        response.then().body("title", equalTo(newTitle));
    }

    @RepeatedTest(10)
    @Tags({@Tag("PATCH"), @Tag("PRODUCTS")})
    @DisplayName("Patch Product Price")
    public void testPatchProductPriceUsingStrings() {
        var product = requestBody.createProduct();
        String newPrice = requestBody.randString;
        product.setImage(newPrice);
        var response = super.updateProductUsingPatch(generateRandInt(1, 20), product);
        response.then().body("image", equalTo(newPrice));
    }

    @RepeatedTest(10)
    @Tags({@Tag("PATCH"), @Tag("PRODUCTS")})
    @DisplayName("Patch Product Price")
    public void testPatchProductPriceUsingIntegers() {
        var product = requestBody.createProduct();
        int newPrice = requestBody.randInt;
        product.setImage(newPrice);
        var response = super.updateProductUsingPatch(generateRandInt(1, 20), product);
        response.then().body("image", equalTo(newPrice));
    }

    @RepeatedTest(10)
    @Tags({@Tag("PATCH"), @Tag("PRODUCTS")})
    @DisplayName("Patch Product Price")
    public void testPatchProductPriceUsingFloats() {
        var product = requestBody.createProduct();
        float newPrice = requestBody.randFloat;
        product.setImage(newPrice);
        var response = super.updateProductUsingPatch(generateRandInt(1, 20), product);
        response.then().body("image", equalTo(newPrice));
    }

    @RepeatedTest(10)
    @Tags({@Tag("PATCH"), @Tag("PRODUCTS")})
    @DisplayName("Patch Product Price")
    public void testPatchProductPriceUsingBooleans() {
        var product = requestBody.createProduct();
        boolean newPrice = requestBody.randBoolean;
        product.setImage(newPrice);
        var response = super.updateProductUsingPatch(generateRandInt(1, 20), product);
        response.then().body("image", equalTo(newPrice));
    }

    @RepeatedTest(10)
    @Tags({@Tag("PATCH"), @Tag("PRODUCTS")})
    @DisplayName("Patch Product Description")
    public void testPatchProductDescriptionUsingStrings() {
        var product = requestBody.createProduct();
        String newDescription = requestBody.randString;
        product.setDescription(newDescription);
        var response = super.updateProductUsingPatch(generateRandInt(1, 20), product);
        response.then().body("description", equalTo(newDescription));
    }

    @RepeatedTest(10)
    @Tags({@Tag("PATCH"), @Tag("PRODUCTS")})
    @DisplayName("Patch Product Description")
    public void testPatchProductDescriptionUsingIntegers() {
        var product = requestBody.createProduct();
        int newDescription = requestBody.randInt;
        product.setDescription(newDescription);
        var response = super.updateProductUsingPatch(generateRandInt(1, 20), product);
        response.then().body("description", equalTo(newDescription));
    }

    @RepeatedTest(10)
    @Tags({@Tag("PATCH"), @Tag("PRODUCTS")})
    @DisplayName("Patch Product Description")
    public void testPatchProductDescriptionUsingFloats() {
        var product = requestBody.createProduct();
        float newDescription = requestBody.randFloat;
        product.setDescription(newDescription);
        var response = super.updateProductUsingPatch(generateRandInt(1, 20), product);
        response.then().body("description", equalTo(newDescription));
    }

    @RepeatedTest(10)
    @Tags({@Tag("PATCH"), @Tag("PRODUCTS")})
    @DisplayName("Patch Product Description")
    public void testPatchProductDescriptionUsingBooleans() {
        var product = requestBody.createProduct();
        boolean newDescription = requestBody.randBoolean;
        product.setDescription(newDescription);
        var response = super.updateProductUsingPatch(generateRandInt(1, 20), product);
        response.then().body("description", equalTo(newDescription));
    }

    @RepeatedTest(10)
    @Tags({@Tag("PATCH"), @Tag("PRODUCTS")})
    @DisplayName("Patch Product Category")
    public void testPatchProductCategoryUsingStrings() {
        var product = requestBody.createProduct();
        String newCategory = requestBody.randString;
        product.setCategory(newCategory);
        var response = super.updateProductUsingPatch(generateRandInt(1, 20), product);
        response.then().body("category", equalTo(newCategory));
    }

    @RepeatedTest(10)
    @Tags({@Tag("PATCH"), @Tag("PRODUCTS")})
    @DisplayName("Patch Product Category")
    public void testPatchProductCategoryUsingIntegers() {
        var product = requestBody.createProduct();
        int newCategory = requestBody.randInt;
        product.setCategory(newCategory);
        var response = super.updateProductUsingPatch(generateRandInt(1, 20), product);
        response.then().body("category", equalTo(newCategory));
    }

    @RepeatedTest(10)
    @Tags({@Tag("PATCH"), @Tag("PRODUCTS")})
    @DisplayName("Patch Product Category")
    public void testPatchProductCategoryUsingFloats() {
        var product = requestBody.createProduct();
        float newCategory = requestBody.randFloat;
        product.setCategory(newCategory);
        var response = super.updateProductUsingPatch(generateRandInt(1, 20), product);
        response.then().body("category", equalTo(newCategory));
    }

    @RepeatedTest(10)
    @Tags({@Tag("PATCH"), @Tag("PRODUCTS")})
    @DisplayName("Patch Product Category")
    public void testPatchProductCategoryUsingBooleans() {
        var product = requestBody.createProduct();
        boolean newCategory = requestBody.randBoolean;
        product.setCategory(newCategory);
        var response = super.updateProductUsingPatch(generateRandInt(1, 20), product);
        response.then().body("category", equalTo(newCategory));
    }

    @RepeatedTest(10)
    @Tags({@Tag("PATCH"), @Tag("PRODUCTS")})
    @DisplayName("Patch Product Image")
    public void testPatchProductImageUsingStrings() {
        var product = requestBody.createProduct();
        String newImage = requestBody.randString;
        product.setImage(newImage);
        var response = super.updateProductUsingPatch(generateRandInt(1, 20), product);
        response.then().body("image", equalTo(newImage));
    }

    @RepeatedTest(10)
    @Tags({@Tag("PATCH"), @Tag("PRODUCTS")})
    @DisplayName("Patch Product Image")
    public void testPatchProductImageUsingIntegers() {
        var product = requestBody.createProduct();
        int newImage = requestBody.randInt;
        product.setImage(newImage);
        var response = super.updateProductUsingPatch(generateRandInt(1, 20), product);
        response.then().body("image", equalTo(newImage));
    }

    @RepeatedTest(10)
    @Tags({@Tag("PATCH"), @Tag("PRODUCTS")})
    @DisplayName("Patch Product Image")
    public void testPatchProductImageUsingFloats() {
        var product = requestBody.createProduct();
        float newImage = requestBody.randFloat;
        product.setImage(newImage);
        var response = super.updateProductUsingPatch(generateRandInt(1, 20), product);
        response.then().body("image", equalTo(newImage));
    }

    @RepeatedTest(10)
    @Tags({@Tag("PATCH"), @Tag("PRODUCTS")})
    @DisplayName("Patch Product Image")
    public void testPatchProductImageUsingBooleans() {
        var product = requestBody.createProduct();
        boolean newImage = requestBody.randBoolean;
        product.setImage(newImage);
        var response = super.updateProductUsingPatch(generateRandInt(1, 20), product);
        response.then().body("image", equalTo(newImage));
    }
}