package utils.Validation.Fields;

import utils.CONSTANTS.CONSTANT_VALIDATION;
import utils.POJO.allCarts.Items;
import utils.POJO.allCarts.Product;

import static utils.Validation.Fields.StaticFieldValidator.validateInt;

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
