package utils.CONSTANTS;

import java.util.ArrayList;
import java.util.List;

public interface CONSTANT_VALIDATION {
    List<Object> ids = new ArrayList<>();
    List<Object> userIds = new ArrayList<>();
    List<Object> cartDates = new ArrayList<>();
    List<Object> productIds = new ArrayList<>();
    List<Object> productQuantity = new ArrayList<>();

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