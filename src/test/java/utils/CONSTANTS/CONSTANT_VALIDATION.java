package utils.CONSTANTS;

import utils.pojo.product.Rating;

import java.util.ArrayList;
import java.util.List;

public interface CONSTANT_VALIDATION {
    List<Object> ids = new ArrayList<>();
    List<Object> userIds = new ArrayList<>();
    List<Object> cartDates = new ArrayList<>();
    List<Object> productIds = new ArrayList<>();
    List<Object> productQuantity = new ArrayList<>();

    List<Object> titles = new ArrayList<>();
    List<Object> prices = new ArrayList<>();
    List<Object> descriptions = new ArrayList<>();
    List<Object> categories = new ArrayList<>();
    List<Object> images = new ArrayList<>();
    List<Rating> ratings = new ArrayList<>();

    /**
     * Clears the given lists.
     *
     * @param  lists  the lists to be cleared
     */

    default void clearLists(List<?>... lists) {
        for (List<?> list : lists) {
            list.clear();
        }
    }
}