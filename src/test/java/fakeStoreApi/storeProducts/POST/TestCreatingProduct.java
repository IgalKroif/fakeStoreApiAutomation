package fakeStoreApi.storeProducts.POST;

import CreateRequest.product.PostProductRequest;
import org.junit.jupiter.api.*;
import utils.pojo.product.Products;
import utils.pojo.product.Rating;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static utils.validation.dataRandomizer.BooleanRandomizer.generateRandomBool;
import static utils.validation.dataRandomizer.NumberRandomizer.*;
import static utils.validation.dataRandomizer.StringRandomizer.generateRandStringName;

@DisplayName("Create Product Test Class")
public class TestCreatingProduct extends PostProductRequest {
    Integer randInt = generateRandInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
    Float randFloat = generateRandFloat();
    String randString = generateRandStringName();
    Boolean randBoolean = generateRandomBool();

    public Products createProduct() {
        Products product = new Products();
        product.setId(1);
        product.setTitle("Example Product");
        product.setPrice(19.99);
        product.setDescription("This is an example product description.");
        product.setCategory("Example Category");
        product.setImage("https://example.com/image.jpg");
        product.setRating(new Rating(4.5, 100)); // Assuming Rating has a constructor Rating(double rate, int count)
        return product;
    }

    public Products createProduct(Object id, Object title, Object price, Object description, Object category, Object image, Object rating, Object count) {
        Products product = new Products();
        product.setId(id);
        product.setTitle(title);
        product.setPrice(price);
        product.setDescription(description);
        product.setCategory(category);
        product.setImage(image);
        product.setRating(new Rating(rating, count));
        return product;
    }

    @RepeatedTest(10)
    @Tags(@Tag("Sanity"))
    @DisplayName("Sanity Test: Create Product")
    public void testCreateProductSanity() {
        var response = super.createAProduct(createProduct());
        // Add assertions based on the response if needed
    }
    @RepeatedTest(24)
    @Tags({@Tag("POST"), @Tag("PRODUCTS")})
    @DisplayName("Create Product with all fields")
    public void testCreateProductWithAllFields() {
        var response = super.createAProduct(createProduct(
                generateRandInt(),
                generateRandFloat(),
                generateRandFloat(),
                generateRandStringName(),
                generateRandStringName(),
                generateRandStringName(),
                generateRandStringName(),
                generateRandInt()
        ));
    }

    @RepeatedTest(10)
    @Tags({@Tag("POST"), @Tag("PRODUCTS")})
    @DisplayName("Create Product with various IDs")
    public void testCreateProductWithVariousIds() {
        Products product = createProduct();
        product.setId(randInt);
        var response = super.createAProduct(product);
        var id = response.body().path("id");
        // this API doesnt write to a DB so always 21.
        assertThat(id, is(equalTo(21)));
        // Add assertions based on the response if needed
    }

    @RepeatedTest(10)
    @Tags({@Tag("POST"), @Tag("PRODUCTS")})
    @DisplayName("Create Product with various int titles")
    public void testCreateProductWithVariousIntTitles() {
        Products product = createProduct();
        product.setTitle(randInt);
        var response = super.createAProduct(product);
        response.then().body("title", equalTo(randInt));
    }

    @RepeatedTest(10)
    @Tags({@Tag("POST"), @Tag("PRODUCTS")})
    @DisplayName("Create Product with various titles")
    public void testCreateProductWithVariousStringTitles() {
        Products product = createProduct();
        product.setTitle(randString);
        var response = super.createAProduct(product);
        response.then().body("title", equalTo(randString));
    }

    @RepeatedTest(10)
    @Tags({@Tag("POST"), @Tag("PRODUCTS")})
    @DisplayName("Create Product with various float titles")
    public void testCreateProductWithVariousFloatTitles() {
        Products product = createProduct();
        product.setTitle(randFloat);
        var response = super.createAProduct(product);
        response.then().body("title", equalTo(randFloat));
    }

    @RepeatedTest(10)
    @Tags({@Tag("POST"), @Tag("PRODUCTS")})
    @DisplayName("Create Product with various boolean titles")
    public void testCreateProductWithVariousBooleanTitles() {
        Products product = createProduct();
        product.setTitle(randBoolean);
        var response = super.createAProduct(product);
        response.then().body("title", equalTo(randBoolean));
    }

    @RepeatedTest(10)
    @Tags({@Tag("POST"), @Tag("PRODUCTS")})
    @DisplayName("Create Product with various prices")
    public void testCreateProductWithVariousPrices() {
        Products product = createProduct();
        product.setPrice(randFloat);
        var response = super.createAProduct(product);
        response.then().body("price", equalTo(randFloat));
    }

    @RepeatedTest(10)
    @Tags({@Tag("POST"), @Tag("PRODUCTS")})
    @DisplayName("Create Product with various descriptions")
    public void testCreateProductWithVariousDescriptions() {
        Products product = createProduct();
        product.setDescription(randString);
        var response = super.createAProduct(product);
        response.then().body("description", equalTo(randString));
    }

    @RepeatedTest(10)
    @Tags({@Tag("POST"), @Tag("PRODUCTS")})
    @DisplayName("Create Product with various int descriptions")
    public void testCreateProductWithVariousIntDescriptions() {
        Products product = createProduct();
        product.setDescription(randInt);
        var response = super.createAProduct(product);
        response.then().body("description", equalTo(randInt));
    }

    @RepeatedTest(10)
    @Tags({@Tag("POST"), @Tag("PRODUCTS")})
    @DisplayName("Create Product with various float descriptions")
    public void testCreateProductWithVariousFloatDescriptions() {
        Products product = createProduct();
        product.setDescription(randFloat);
        var response = super.createAProduct(product);
        response.then().body("description", equalTo(randFloat));
    }

    @RepeatedTest(10)
    @Tags({@Tag("POST"), @Tag("PRODUCTS")})
    @DisplayName("Create Product with various boolean descriptions")
    public void testCreateProductWithVariousBooleanDescriptions() {
        Products product = createProduct();
        product.setDescription(randBoolean);
        var response = super.createAProduct(product);
        response.then().body("description", equalTo(randBoolean));
    }

    @RepeatedTest(10)
    @Tags({@Tag("POST"), @Tag("PRODUCTS")})
    @DisplayName("Create Product with various categories")
    public void testCreateProductWithVariousCategories() {
        Products product = createProduct();
        product.setCategory(randString);
        var response = super.createAProduct(product);
        response.then().body("category", equalTo(randString));
    }

    @RepeatedTest(10)
    @Tags({@Tag("POST"), @Tag("PRODUCTS")})
    @DisplayName("Create Product with various int categories")
    public void testCreateProductWithVariousIntCategories() {
        Products product = createProduct();
        product.setCategory(randInt);
        var response = super.createAProduct(product);
        response.then().body("category", equalTo(randInt));
    }

    @RepeatedTest(10)
    @Tags({@Tag("POST"), @Tag("PRODUCTS")})
    @DisplayName("Create Product with various float categories")
    public void testCreateProductWithVariousFloatCategories() {
        Products product = createProduct();
        product.setCategory(randFloat);
        var response = super.createAProduct(product);
        response.then().body("category", equalTo(randFloat));
    }

    @RepeatedTest(10)
    @Tags({@Tag("POST"), @Tag("PRODUCTS")})
    @DisplayName("Create Product with various boolean categories")
    public void testCreateProductWithVariousBooleanCategories() {
        Products product = createProduct();
        product.setCategory(randBoolean);
        var response = super.createAProduct(product);
        response.then().body("category", equalTo(randBoolean));
    }

    @RepeatedTest(10)
    @Tags({@Tag("POST"), @Tag("PRODUCTS")})
    @DisplayName("Create Product with various images")
    public void testCreateProductWithVariousImages() {
        Products product = createProduct();
        product.setImage(randString);
        var response = super.createAProduct(product);
        response.then().body("image", equalTo(randString));
    }

    @RepeatedTest(10)
    @Tags({@Tag("POST"), @Tag("PRODUCTS")})
    @DisplayName("Create Product with various int images")
    public void testCreateProductWithVariousIntImages() {
        Products product = createProduct();
        product.setImage(randInt);
        var response = super.createAProduct(product);
        response.then().body("image", equalTo(randInt));
    }

    @RepeatedTest(10)
    @Tags({@Tag("POST"), @Tag("PRODUCTS")})
    @DisplayName("Create Product with various float images")
    public void testCreateProductWithVariousFloatImages() {
        Products product = createProduct();
        product.setImage(randFloat);
        var response = super.createAProduct(product);
        response.then().body("image", equalTo(randFloat));
    }

    @RepeatedTest(10)
    @Tags({@Tag("POST"), @Tag("PRODUCTS")})
    @DisplayName("Create Product with various boolean images")
    public void testCreateProductWithVariousBooleanImages() {
        Products product = createProduct();
        product.setImage(randBoolean);
        var response = super.createAProduct(product);
        response.then().body("image", equalTo(randBoolean));
    }

    @Test
    @Tags({@Tag("POST"), @Tag("PRODUCTS")})
    @DisplayName("Create Product with null prices")
    public void testCreateProductWithNullPrices() {
        Products product = createProduct();
        product.setPrice(null);
        var response = super.createAProduct(product);
        response.then().body("price", equalTo(null));
    }

    @Test
    @Tags({@Tag("POST"), @Tag("PRODUCTS")})
    @DisplayName("Create Product with empty prices")
    public void testCreateProductWithEmptyPrices() {
        Products product = createProduct();
        product.setPrice("");
        var response = super.createAProduct(product);
        response.then().body("price", equalTo(""));
    }

    @Test
    @Tags({@Tag("POST"), @Tag("PRODUCTS")})
    @DisplayName("Create Product with null title")
    public void testCreateProductWithNullTitle() {
        Products product = createProduct();
        product.setTitle(null);
        var response = super.createAProduct(product);
        response.then().body("title", equalTo(null));
    }

    @Test
    @Tags({@Tag("POST"), @Tag("PRODUCTS")})
    @DisplayName("Create Product with empty title")
    public void testCreateProductWithEmptyTitle() {
        Products product = createProduct();
        product.setTitle("");
        var response = super.createAProduct(product);
        response.then().body("title", equalTo(""));
    }

    @Test
    @Tags({@Tag("POST"), @Tag("PRODUCTS")})
    @DisplayName("Create Product with null description")
    public void testCreateProductWithNullDescription() {
        Products product = createProduct();
        product.setDescription(null);
        var response = super.createAProduct(product);
        response.then().body("description", equalTo(null));
    }

    @Test
    @Tags({@Tag("POST"), @Tag("PRODUCTS")})
    @DisplayName("Create Product with empty description")
    public void testCreateProductWithEmptyDescription() {
        Products product = createProduct();
        product.setDescription("");
        var response = super.createAProduct(product);
        response.then().body("description", equalTo(""));
    }
}