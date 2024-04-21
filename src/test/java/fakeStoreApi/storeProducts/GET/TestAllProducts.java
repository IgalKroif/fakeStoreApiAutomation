package fakeStoreApi.storeProducts.GET;

import CreateRequest.product.GetProductRequest;
import fakeStoreApi.storeCarts.GET.TestAllCarts;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import utils.CONSTANTS.CONSTANTS;
import utils.pojo.product.Products;
import utils.pojo.product.Rating;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.apache.commons.io.function.IOConsumer.forEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static utils.validation.Fields.StaticFieldValidator.*;

public class TestAllProducts extends GetProductRequest implements CONSTANTS {

    public final Logger logger = LoggerFactory.getLogger(TestAllProducts.class);

    /**
     * Clears the lists of productIds, titles, prices, descriptions, categories, and images.
     */
    @AfterMethod
    public void clearList() {
        clearLists(productIds, titles, prices, descriptions, categories, images);
    }

    @Test
    @DisplayName("Testing all product IDs")
    @Tags({@Tag("Products"), @Tag("GET")})
    public void testAllProductIds() {
        var response = super.getProducts();

        var products = response.as(Products[].class);
      //  Arrays.stream(products).forEach(System.out::println);
        Arrays.stream(products).forEach(product -> {
            productIds.add(product.getId());
        });
        validateInt().intGreaterEqualTo(productIds.size(), 20);
        validateInt().intLessThanEqualTo(productIds.size(), 20);

        logProductIds(productIds, "Ids");
    }

    @Test
    @DisplayName("Testing all product titles")
    @Tags({@Tag("Products"), @Tag("GET")})
    public void testAllProductTitles() {
        var response = super.getProducts();

        var products = response.as(Products[].class);
        Arrays.stream(products).forEach(product -> {
            titles.add(product.getTitle());
            assertStreamedProductField(product, titles, Products::getTitle);
        });
        logProductIds(titles, "Titles");
    }

    @Test
    @DisplayName("Testing all product prices")
    @Tags({@Tag("Products"), @Tag("GET")})
    public void testAllProductPrices() {
        var response = super.getProducts();

        var products = response.as(Products[].class);
        Arrays.stream(products).forEach(product -> {
            prices.add(product.getPrice());
            assertStreamedProductField(product, prices, Products::getPrice);

            if (product.getPrice() instanceof Integer) {
                validateInt().intGreaterEqualTo((Integer) product.getPrice(), 0);
                validateInt().intLessThanEqualTo((Integer) product.getPrice(), 1000);
            } else if (product.getPrice() instanceof Double) {
                validateInt().doubleGreaterEqualTo((Double) product.getPrice(), 0.0);
                validateInt().doubleLessThanEqualTo((Double) product.getPrice(), 1000.0);
            } else {
                throw new AssertionError("Unsupported rating type: " + product.getPrice().getClass().getName());
            }
        });
        logProductIds(prices, "Prices");
    }

    @Test
    @DisplayName("Testing all product descriptions")
    @Tags({@Tag("Products"), @Tag("GET")})
    public void testAllProductDescriptions() {
        var response = super.getProducts();

        var products = response.as(Products[].class);
        Arrays.stream(products).forEach(product -> {
            descriptions.add(product.getDescription());
            assertStreamedProductField(product, descriptions, Products::getDescription);
        });
        descriptions.stream().distinct().forEach(System.out::println);
        logProductIds(descriptions, "Descriptions");
    }

    @Test
    @DisplayName("Testing all product categories")
    @Tags({@Tag("Products"), @Tag("GET")})
    public void testAllProductCategories() {
        var response = super.getProducts();

        var products = response.as(Products[].class);
        Arrays.stream(products).forEach(product -> {
            categories.add(product.getCategory());
            assertStreamedProductField(product, categories, Products::getCategory);
        });
        logProductIds(categories, "Categories");
    }

    @Test
    @DisplayName("Testing all product images")
    @Tags({@Tag("Products"), @Tag("GET")})
    public void testAllProductImages() {
        var response = super.getProducts();

        var products = response.as(Products[].class);
        Arrays.stream(products).forEach(product -> {
            images.add(product.getImage());
            assertStreamedProductField(product, images, Products::getImage);
            assertTrue(images.stream().allMatch(image -> ((String) image).endsWith(".jpg")));
        });
        logProductIds(images, "Images");
    }

    @Test
    @DisplayName("Testing all product ratings")
    @Tags({@Tag("Products"), @Tag("GET")})
    public void testAllProductRatings() {
        var response = super.getProducts();

        var products = response.as(Products[].class);
        Arrays.stream(products).forEach(product -> {
            Rating rating = product.getRating();
            ratings.add(rating);

            if (rating.getRate() instanceof Integer) {
                validateInt().intGreaterEqualTo((Integer) rating.getRate(), 0);
                validateInt().intLessThanEqualTo((Integer) rating.getRate(), 5);
            } else if (rating.getRate() instanceof Double) {
                validateInt().doubleGreaterEqualTo((Double) rating.getRate(), 0.0);
                validateInt().doubleLessThanEqualTo((Double) rating.getRate(), 5.0);
            } else {
                throw new AssertionError("Unsupported rating type: " + rating.getRate().getClass().getName());
            }

            assertStreamedProductField(product, ratings, Products::getRating);
            validateInt().intGreaterEqualTo((Integer) rating.getCount(), 50);
            validateInt().intLessThanEqualTo((Integer) rating.getCount(), 1000);
        });

        // Assert the number of ratings
        validateInt().intLessThanEqualTo(ratings.size(), 20);
        logProductIds(Collections.singletonList(ratings), "Ratings");
    }

    public void logProductIds(List<Object> productList) {
        logger.info("Product List field: {}\nSize of array: {}\n", productList, productList.size());
    }
    public void logProductIds(List<Object> productList, String fieldName) {
        logger.info("Product List{} field: {}\nSize of array: {}\n", fieldName, productList, productList.size());
    }
}