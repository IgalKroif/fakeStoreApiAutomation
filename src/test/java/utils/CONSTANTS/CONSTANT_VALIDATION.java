package utils.CONSTANTS;

import java.util.ArrayList;
import java.util.List;

public interface CONSTANT_VALIDATION {
    List<Integer> ids = new ArrayList<>();
    List<Integer> userIds = new ArrayList<>();
    List<String> cartDates = new ArrayList<>();
    List<Integer> productIds = new ArrayList<>();
    List<Integer> productQuantity = new ArrayList<>();

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