package utils.validation.Fields;

import io.restassured.response.Response;
import org.testng.annotations.Optional;
import utils.CONSTANTS.CONSTANT_VALIDATION;
import utils.pojo.cart.Items;
import utils.pojo.cart.Product;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static utils.validation.Fields.StaticFieldValidator.validateInt;

public class ExtractAllCartItems implements CONSTANT_VALIDATION {
    public Items[] extractAllCarts(Items[] items) {
        for (Items item : items) {
            validateInt().intGreaterEqualTo((Integer) item.getId(), 1);
            ids.add(item.getId());
            userIds.add(item.getUserId());
            cartDates.add(item.getDate());
            for (Product product : item.getProducts()) {
                productIds.add(product.getProductId());
                productQuantity.add(product.getQuantity());
            }
        }
        return new Items[]{new Items()};
    }

    public static void validateCreatedCart(Response response, @Optional int userID, @Optional String dateField, @Optional int productIdField, @Optional int quantityField) {
        var items = response.as(Items.class);
        assertThat(items.getUserId(), is(equalTo(userID)));
        assertThat(items.getDate(), is(equalTo(dateField)));
        assertThat(items.getId(), is(notNullValue()));
        items.getProducts().forEach(product -> {
            assertThat(product.getProductId(), is(equalTo(productIdField)));
            assertThat(product.getQuantity(), is(equalTo(quantityField)));
        });
    }
}
