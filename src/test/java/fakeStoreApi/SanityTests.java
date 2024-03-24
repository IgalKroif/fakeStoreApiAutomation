package fakeStoreApi;

import CreateRequest.AllCartRequests;
import groovy.util.logging.Slf4j;
import io.restassured.response.Response;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import utils.CONSTANTS.CONSTANT_VALIDATION;
import utils.POJO.allCarts.Items;
import utils.POJO.allCarts.Product;

import static utils.Validation.Fields.StaticFieldValidator.validateInt;

@Tag("SanityTest")
@Slf4j
public class SanityTests implements CONSTANT_VALIDATION {
    @AfterMethod
    public void clearList() {
        clearLists(ids, userIds, cartDates, productIds, productQuantity);
    }
    private final AllCartRequests assertCart = new AllCartRequests();
    public final Logger logger = LoggerFactory.getLogger(SanityTests.class);
    @Test
    public void testAllCarts() {
        Response response = assertCart.testAllCarts();
        var items = response.as(Items[].class);
        extractAllCarts(items);
        logger.info(
                "ids: " + ids + "\n" +
                "UserIds: " + userIds + "\n" +
                "Added to cart dates: " + cartDates + "\n" +
                "Product Ids: " + productIds + "\n" +
                "Product Quantity: " + productQuantity);
    }

    private static void extractAllCarts(Items[] items) {
        for (Items item : items) {
            validateInt().intGreaterEqualTo(item.getId(), 1);
            ids.add(item.getId());
            userIds.add(item.getUserId());
            cartDates.add(item.getDate());
            for (Product product : item.getProducts()) {
                productIds.add(product.getProductId());
                productQuantity.add(product.getQuantity());
            }
        }
    }
}