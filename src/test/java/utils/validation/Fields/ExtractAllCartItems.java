package utils.validation.Fields;

import utils.CONSTANTS.CONSTANT_VALIDATION;
import utils.POJO.cart.Items;
import utils.POJO.cart.Product;

import static utils.validation.Fields.StaticFieldValidator.validateInt;

public class ExtractAllCartItems implements CONSTANT_VALIDATION {
    public Items[] extractAllCarts(Items[] items) {
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
        return new Items[]{new Items()};
    }
}
