package fakeStoreApi.storeProducts.GET;

import CreateRequest.product.GetProductRequest;

import groovy.util.logging.Slf4j;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.CONSTANTS.CONSTANTS;
import utils.pojo.product.Products;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static utils.validation.Fields.StaticFieldValidator.validateInt;
import static utils.validation.dataRandomizer.NumberRandomizer.generateRandInt;

@Slf4j
@Feature("GET METHOD : PRODUCTS ENDPOINT")
public class TestSpecificProduct extends GetProductRequest implements CONSTANTS {

    public final Logger logger = LoggerFactory.getLogger(TestSpecificProduct.class);

    @DisplayName("Testing specific product ID")
    @Tags({@Tag("Products"), @Tag("GET")})
    @RepeatedTest(value = 10, name = "Testing specific product ID {currentRepetition} of {totalRepetitions}")
    @Epic("GET SPECIFIC PRODUCT by ID")
    @Step
    public void testSpecificProductId() {
        var response = super.getProducts(generateRandInt(1, 20));

        var product = response.as(Products.class);
        validateInt().intGreaterEqualTo((Integer) product.getId(), 1, 1, 20);
        response.then().body(SINGLE_PRODUCT_SCHEMA);
        logData(response, "Id");
    }

    /**
     * bug exists where id 18 : MBJ Women's Solid Short Sleeve Boat Neck V contains " " at the end, add a list name that
     * contains a space for the validation to pass
     */
    @DisplayName("Testing specific product NAME")
    @Tags({@Tag("Products"), @Tag("GET")})
    @RepeatedTest(value = 10, name = "Testing specific product NAME {currentRepetition} of {totalRepetitions}")
    @Epic("GET SPECIFIC PRODUCT NAME")
    @Step
    public void testSpecificProductName() {
        int randomId = generateRandInt(1, 20);
        var response = super.getProducts(randomId);
        var product = response.as(Products.class);

        // Trimmed product name set for accurate comparison
        assertThat(PRODUCT_NAMES.contains(product.getTitle()))
                .withFailMessage("Unexpected Product Name: " + product.getTitle())
                .isTrue();


        // Assertion with logging for debugging
        assertThat(PRODUCT_NAMES.contains(product.getTitle().toString()))
                .withFailMessage("Unexpected Product Name: " + product.getTitle())
                .isTrue();
        response.then().body(SINGLE_PRODUCT_SCHEMA);
        logData(response, "Name");
    }

    @DisplayName("Testing specific product PRICE")
    @Tags({@Tag("Products"), @Tag("GET")})
    @RepeatedTest(value = 10,name = "Testing specific product PRICE {currentRepetition} of {totalRepetitions}")
    @Epic("GET SPECIFIC PRODUCT PRICE")
    @Step
    public void testSpecificProductPrice() {
        var response = super.getProducts(generateRandInt(1, 20));
        var product = response.as(Products.class);
        if (product.getPrice() instanceof Double) {
            validateInt().doubleGreaterEqualTo((Double) product.getPrice(), 1.00, 1.00, 1000.00);
        } else {
            validateInt().intGreaterEqualTo((Integer) product.getPrice(), 1, 1, 1000);
        }
        response.then().body(SINGLE_PRODUCT_SCHEMA);
        logData(response, "Price");
    }

    @DisplayName("Testing specific product DESCRIPTION")
    @Tags({@Tag("Products"), @Tag("GET")})
    @RepeatedTest(value = 35, name = "Testing specific product DESCRIPTION {currentRepetition} of {totalRepetitions}")
    @Epic("GET SPECIFIC PRODUCT DESCRIPTION")
    @Step
    public void testSpecificProductDescription() {
        var response = super.getProducts(generateRandInt(1, 20));
        var product = response.as(Products.class);
        assertThat(PRODUCT_DESCRIPTIONS.stream()
                .map(Object::toString)
                .anyMatch(description -> description.equals(product.getDescription())))
                .isTrue();
        response.then().body(SINGLE_PRODUCT_SCHEMA);
        logData(response, "Description");
    }

    @DisplayName("Testing specific product CATEGORY")
    @Tags({@Tag("Products"), @Tag("GET")})
    @RepeatedTest(value = 15, name = "Testing specific product CATEGORY {currentRepetition} of {totalRepetitions}")
    @Epic("GET SPECIFIC PRODUCT CATEGORY")
    @Step
    public void testSpecificProductCategory() {
        var response = super.getProducts(generateRandInt(1, 20));
        var product = response.as(Products.class);
        assertThat(PRODUCT_CATEGORIES.stream()
                .map(Object::toString)
                .anyMatch(category -> category.equals(product.getCategory())))
                .isTrue();
        response.then().body(SINGLE_PRODUCT_SCHEMA);
        logData(response, "Category");
    }

    @DisplayName("Testing specific product IMAGE")
    @Tags({@Tag("Products"), @Tag("GET")})
    @RepeatedTest(value = 15,name = "Testing specific product IMAGE {currentRepetition} of {totalRepetitions}")
    @Epic("GET SPECIFIC PRODUCT IMAGE")
    @Step
    public void testSpecificProductImage() {
        var response = super.getProducts(generateRandInt(1, 20));
        var product = response.as(Products.class);
        assertThat(PRODUCT_IMAGES.stream()
                .map(Object::toString)
                .anyMatch(image -> image.equals(product.getImage())))
                .isTrue();
        response.then().body(SINGLE_PRODUCT_SCHEMA);
        logData(response, "Image");
    }

    @DisplayName("Testing specific product RATING AND COUNT")
    @Tags({@Tag("Products"), @Tag("GET")})
    @RepeatedTest(value = 30, name = "Testing specific product RATING AND COUNT {currentRepetition} of {totalRepetitions}")
    @Epic("GET SPECIFIC PRODUCT RATING AND COUNT")
    @Step
    public void testSpecificProductRating() {
        var response = super.getProducts(generateRandInt(1, 20));
        var product = response.as(Products.class);

        if (product.getRating().getRate() instanceof Integer) {
            validateInt().intGreaterEqualTo((Integer) product.getRating().getRate(), 1, 1, 5);
        } else if (product.getRating().getRate() instanceof Double) {
            validateInt().doubleGreaterEqualTo((Double) product.getRating().getRate(), 1.00, 1.00, 5.00);
        }
        validateInt().intGreaterEqualTo((Integer) product.getRating().getCount(), 0, 1, 1000);

        response.then().body(SINGLE_PRODUCT_SCHEMA);
        logData(response, "Rating");
    }

    /**
     * this API returns not body for wrong data in inputs. (should be 400, but it's 200)
     */
    @DisplayName("Testing specific product using positive wrong id!")
    @Tags({@Tag("Products"), @Tag("GET")})
    @RepeatedTest(value = 10, name = "Testing specific product using positive wrong id! {currentRepetition} of {totalRepetitions}")
    @Epic("GET SPECIFIC PRODUCT using positive wrong id!")
    @Step
    public void testSpecificProductWrongId() {
        var response = super.getProducts(generateRandInt(21, 999));
        logData(response, "WrongId");
        assertTrue(response.getBody().asString().isEmpty());
    }

    /**
     * this API returns not body for wrong data in inputs. (should be 400, but it's 200)
     */
    @DisplayName("Testing specific product using negative wrong id!")
    @Tags({@Tag("Products"), @Tag("GET")})
    @RepeatedTest(value = 30, name = "Testing specific product using negative wrong id! {currentRepetition} of {totalRepetitions}")
    @Epic("GET SPECIFIC PRODUCT using negative wrong id!")
    @Step
    public void testSpecificProductNegativeWrongId() {
        var response = super.getProducts(generateRandInt(-1000, 0));
        logData(response, "WrongId");
        assertTrue(response.getBody().asString().isEmpty());
    }

    public void logData(Response response, String name) {
        logger.info("Response data of {} method, response data: {}", name, response.asString());
    }
}