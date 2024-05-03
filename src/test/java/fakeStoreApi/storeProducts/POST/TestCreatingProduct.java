package fakeStoreApi.storeProducts.POST;

import CreateRequest.product.PostProductRequest;
import groovy.util.logging.Slf4j;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
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
@Slf4j
@Feature("POST METHOD : PRODUCTS ENDPOINT")
public class TestCreatingProduct extends PostProductRequest {
    public Integer randInt = generateRandInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
    public Float randFloat = generateRandFloat() + 0.001F;
    public String randString = generateRandStringName();
    public Boolean randBoolean = generateRandomBool();

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

    @Test
    @Tags(@Tag("Sanity"))
    @DisplayName("Sanity Test: Create Product")
    @Epic("Sanity")
    protected void testCreateProductSanity() {
        Products product = createProduct();
        var response = super.createAProduct(product);
    }

    @RepeatedTest(value = 24, name = "Create Product with all fields {currentRepetition} of {totalRepetitions}")
    @Tags({@Tag("POST"), @Tag("PRODUCTS")})
    @DisplayName("Create Product with all fields")
    @Epic("CREATE PRODUCT WITH ALL FIELDS")
    @Step
    protected void testCreateProductWithAllFields() {
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

    @RepeatedTest(value = 10, name = "Create Product with various IDs {currentRepetition} of {totalRepetitions}")
    @Tags({@Tag("POST"), @Tag("PRODUCTS")})
    @DisplayName("Create Product with various IDs")
    @Epic("CREATE PRODUCT WITH VARIOUS IDS")
    @Step
    protected void testCreateProductWithVariousIds() {
        Products product = createProduct();
        product.setId(randInt);
        var response = super.createAProduct(product);
        var id = response.body().path("id");
        // this API doesn't write to a DB so always 21.
        assertThat(id, is(equalTo(21)));
    }

    @RepeatedTest(value = 10, name = "Create Product with various titles {currentRepetition} of {totalRepetitions}")
    @Tags({@Tag("POST"), @Tag("PRODUCTS")})
    @DisplayName("Create Product with various int titles")
    @Epic("CREATE PRODUCT WITH VARIOUS TITLES")
    @Step
    protected void testCreateProductWithVariousIntTitles() {
        Products product = createProduct();
        product.setTitle(randInt);
        var response = super.createAProduct(product);
        response.then().body("title", equalTo(randInt));
    }

    @RepeatedTest(value = 10, name = "Create Product with various float titles {currentRepetition} of {totalRepetitions}")
    @Tags({@Tag("POST"), @Tag("PRODUCTS")})
    @DisplayName("Create Product with various titles")
    @Epic("CREATE PRODUCT WITH VARIOUS TITLES")
    @Step
    protected void testCreateProductWithVariousStringTitles() {
        Products product = createProduct();
        product.setTitle(randString);
        var response = super.createAProduct(product);
        response.then().body("title", equalTo(randString));
    }

    @RepeatedTest(value = 10, name = "Create Product with various boolean titles {currentRepetition} of {totalRepetitions}")
    @Tags({@Tag("POST"), @Tag("PRODUCTS")})
    @DisplayName("Create Product with various float titles")
    @Epic("CREATE PRODUCT WITH VARIOUS TITLES")
    @Step
    protected void testCreateProductWithVariousFloatTitles() {
        Products product = createProduct();
        product.setTitle(randFloat + 0.001F);
        var response = super.createAProduct(product);
        response.then().body("title", equalTo(randFloat + 0.001F));
    }

    @RepeatedTest(value = 10, name = "Create Product with various boolean titles {currentRepetition} of {totalRepetitions}")
    @Tags({@Tag("POST"), @Tag("PRODUCTS")})
    @DisplayName("Create Product with various boolean titles")
    @Epic("CREATE PRODUCT WITH VARIOUS TITLES")
    @Step
    protected void testCreateProductWithVariousBooleanTitles() {
        Products product = createProduct();
        product.setTitle(randBoolean);
        var response = super.createAProduct(product);
        response.then().body("title", equalTo(randBoolean));
    }

    @RepeatedTest(value = 10, name = "Create Product with various prices {currentRepetition} of {totalRepetitions}")
    @Tags({@Tag("POST"), @Tag("PRODUCTS")})
    @DisplayName("Create Product with various prices")
    @Epic("CREATE PRODUCT WITH VARIOUS PRICES")
    @Step
    protected void testCreateProductWithVariousPrices() {
        Products product = createProduct();
        product.setPrice(randFloat);
        var response = super.createAProduct(product);
        response.then().body("price", equalTo(randFloat));
    }

    @RepeatedTest(value = 10, name = "Create Product with various descriptions {currentRepetition} of {totalRepetitions}")
    @Tags({@Tag("POST"), @Tag("PRODUCTS")})
    @DisplayName("Create Product with various descriptions")
    @Epic("CREATE PRODUCT WITH VARIOUS DESCRIPTIONS")
    @Step
    protected void testCreateProductWithVariousDescriptions() {
        Products product = createProduct();
        product.setDescription(randString);
        var response = super.createAProduct(product);
        response.then().body("description", equalTo(randString));
    }

    @RepeatedTest(value = 10, name = "Create Product with various descriptions {currentRepetition} of {totalRepetitions}")
    @Tags({@Tag("POST"), @Tag("PRODUCTS")})
    @DisplayName("Create Product with various int descriptions")
    @Epic("CREATE PRODUCT WITH VARIOUS DESCRIPTIONS")
    @Step
    protected void testCreateProductWithVariousIntDescriptions() {
        Products product = createProduct();
        product.setDescription(randInt);
        var response = super.createAProduct(product);
        response.then().body("description", equalTo(randInt));
    }

    @RepeatedTest(value = 10, name = "Create Product with various float descriptions {currentRepetition} of {totalRepetitions}")
    @Tags({@Tag("POST"), @Tag("PRODUCTS")})
    @DisplayName("Create Product with various float descriptions")
    @Epic("CREATE PRODUCT WITH VARIOUS DESCRIPTIONS")
    @Step
    protected void testCreateProductWithVariousFloatDescriptions() {
        Products product = createProduct();
        product.setDescription(randFloat + 0.001F);
        var response = super.createAProduct(product);
        response.then().body("description", equalTo(randFloat + 0.001F));
    }

    @RepeatedTest(value = 10, name = "Create Product with various boolean descriptions {currentRepetition} of {totalRepetitions}")
    @Tags({@Tag("POST"), @Tag("PRODUCTS")})
    @DisplayName("Create Product with various boolean descriptions")
    @Epic("CREATE PRODUCT WITH VARIOUS DESCRIPTIONS")
    @Step
    protected void testCreateProductWithVariousBooleanDescriptions() {
        Products product = createProduct();
        product.setDescription(randBoolean);
        var response = super.createAProduct(product);
        response.then().body("description", equalTo(randBoolean));
    }

    @RepeatedTest(value = 10, name = "Create Product with various categories {currentRepetition} of {totalRepetitions}")
    @Tags({@Tag("POST"), @Tag("PRODUCTS")})
    @DisplayName("Create Product with various categories")
    @Epic("CREATE PRODUCT WITH VARIOUS CATEGORIES")
    @Step
    protected void testCreateProductWithVariousCategories() {
        Products product = createProduct();
        product.setCategory(randString);
        var response = super.createAProduct(product);
        response.then().body("category", equalTo(randString));
    }

    @RepeatedTest(value = 10, name = "Create Product with various int categories {currentRepetition} of {totalRepetitions}")
    @Tags({@Tag("POST"), @Tag("PRODUCTS")})
    @DisplayName("Create Product with various int categories")
    @Epic("CREATE PRODUCT WITH VARIOUS CATEGORIES")
    @Step
    protected void testCreateProductWithVariousIntCategories() {
        Products product = createProduct();
        product.setCategory(randInt);
        var response = super.createAProduct(product);
        response.then().body("category", equalTo(randInt));
    }

    @RepeatedTest(value = 10, name = "Create Product with various float categories {currentRepetition} of {totalRepetitions}")
    @Tags({@Tag("POST"), @Tag("PRODUCTS")})
    @DisplayName("Create Product with various float categories")
    @Epic("CREATE PRODUCT WITH VARIOUS CATEGORIES")
    @Step
    protected void testCreateProductWithVariousFloatCategories() {
        Products product = createProduct();
        product.setCategory(randFloat + 0.001F);
        var response = super.createAProduct(product);
        response.then().body("category", equalTo(randFloat + 0.001F));
    }

    @RepeatedTest(value = 10, name = "Create Product with various boolean categories {currentRepetition} of {totalRepetitions}")
    @Tags({@Tag("POST"), @Tag("PRODUCTS")})
    @DisplayName("Create Product with various boolean categories")
    @Epic("CREATE PRODUCT WITH VARIOUS CATEGORIES")
    @Step
    protected void testCreateProductWithVariousBooleanCategories() {
        Products product = createProduct();
        product.setCategory(randBoolean);
        var response = super.createAProduct(product);
        response.then().body("category", equalTo(randBoolean));
    }

    @RepeatedTest(value = 10, name = "Create Product with various images {currentRepetition} of {totalRepetitions}")
    @Tags({@Tag("POST"), @Tag("PRODUCTS")})
    @DisplayName("Create Product with various images")
    @Epic("CREATE PRODUCT WITH VARIOUS IMAGES")
    @Step
    protected void testCreateProductWithVariousImages() {
        Products product = createProduct();
        product.setImage(randString);
        var response = super.createAProduct(product);
        response.then().body("image", equalTo(randString));
    }

    @RepeatedTest(value = 10, name = "Create Product with various int images {currentRepetition} of {totalRepetitions}")
    @Tags({@Tag("POST"), @Tag("PRODUCTS")})
    @DisplayName("Create Product with various int images")
    @Epic("CREATE PRODUCT WITH VARIOUS IMAGES")
    @Step
    protected void testCreateProductWithVariousIntImages() {
        Products product = createProduct();
        product.setImage(randInt);
        var response = super.createAProduct(product);
        response.then().body("image", equalTo(randInt));
    }

    @RepeatedTest(value = 10, name = "Create Product with various float images {currentRepetition} of {totalRepetitions}")
    @Tags({@Tag("POST"), @Tag("PRODUCTS")})
    @DisplayName("Create Product with various float images")
    @Epic("CREATE PRODUCT WITH VARIOUS IMAGES")
    @Step
    protected void testCreateProductWithVariousFloatImages() {
        Products product = createProduct();
        product.setImage(randFloat + 0.001F);
        var response = super.createAProduct(product);
        response.then().body("image", equalTo(randFloat + 0.001F));
    }

    @RepeatedTest(value = 10, name = "Create Product with various boolean images {currentRepetition} of {totalRepetitions}")
    @Tags({@Tag("POST"), @Tag("PRODUCTS")})
    @DisplayName("Create Product with various boolean images")
    @Epic("CREATE PRODUCT WITH VARIOUS IMAGES")
    @Step
    protected void testCreateProductWithVariousBooleanImages() {
        Products product = createProduct();
        product.setImage(randBoolean);
        var response = super.createAProduct(product);
        response.then().body("image", equalTo(randBoolean));
    }

    @Test
    @Tags({@Tag("POST"), @Tag("PRODUCTS")})
    @DisplayName("Create Product with null prices")
    @Epic("CREATE PRODUCT WITH NULL PRICES")
    @Step
    protected void testCreateProductWithNullPrices() {
        Products product = createProduct();
        product.setPrice(null);
        var response = super.createAProduct(product);
        response.then().body("price", equalTo(null));
    }

    @Test
    @Tags({@Tag("POST"), @Tag("PRODUCTS")})
    @DisplayName("Create Product with empty prices")
    @Epic("CREATE PRODUCT WITH EMPTY PRICES")
    @Step
    protected void testCreateProductWithEmptyPrices() {
        Products product = createProduct();
        product.setPrice("");
        var response = super.createAProduct(product);
        response.then().body("price", equalTo(""));
    }

    @Test
    @Tags({@Tag("POST"), @Tag("PRODUCTS")})
    @DisplayName("Create Product with null title")
    @Epic("CREATE PRODUCT WITH NULL TITLE")
    @Step
    protected void testCreateProductWithNullTitle() {
        Products product = createProduct();
        product.setTitle(null);
        var response = super.createAProduct(product);
        response.then().body("title", equalTo(null));
    }

    @Test
    @Tags({@Tag("POST"), @Tag("PRODUCTS")})
    @DisplayName("Create Product with empty title")
    @Epic("CREATE PRODUCT WITH EMPTY TITLE")
    @Step
    protected void testCreateProductWithEmptyTitle() {
        Products product = createProduct();
        product.setTitle("");
        var response = super.createAProduct(product);
        response.then().body("title", equalTo(""));
    }

    @Test
    @Tags({@Tag("POST"), @Tag("PRODUCTS")})
    @DisplayName("Create Product with null description")
    @Epic("CREATE PRODUCT WITH NULL DESCRIPTION")
    @Step
    protected void testCreateProductWithNullDescription() {
        Products product = createProduct();
        product.setDescription(null);
        var response = super.createAProduct(product);
        response.then().body("description", equalTo(null));
    }

    @Test
    @Tags({@Tag("POST"), @Tag("PRODUCTS")})
    @DisplayName("Create Product with empty description")
    @Epic("CREATE PRODUCT WITH EMPTY DESCRIPTION")
    @Step
    protected void testCreateProductWithEmptyDescription() {
        Products product = createProduct();
        product.setDescription("");
        var response = super.createAProduct(product);
        response.then().body("description", equalTo(""));
    }
}