package utils.Validation.Fields;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class StringValidation {
    private final Logger logger = LoggerFactory.getLogger(StringValidation.class);

    /**
     * Validates the length of a string and checks if it is greater than or equal to a specified value.
     * If additional between values are provided, it also checks if the length is within the specified range.
     *
     * @param  itemAddedDate  the string to be validated
     * @param  GTE            the minimum length required
     * @param  betweenValues   optional additional length values to check if the string length is between them
     * @throws AssertionError if the string length is less than the specified minimum length or if it is not within the specified range
     */
    public void stringLengthGTE(String itemAddedDate, int GTE, int... betweenValues) {
        try {
            assertThat(itemAddedDate.length()).isGreaterThanOrEqualTo(GTE).describedAs("int");
            if (betweenValues.length >= 2) {
                assertThat(itemAddedDate.length()).isBetween(betweenValues[0], betweenValues[1]);
            }
        }catch (AssertionError e) {
            logger.error(e.getMessage(), e);
            throw e;
        }

    }
    /**
     * Checks if the length of the given cart item string is greater than or equal to the specified maximum length.
     *
     * @param  cartItem  the string to be checked
     * @param  maxLength the maximum length allowed for the cart item string
     */

    public void stringLengthGTE(String cartItem, int maxLength) {
        assertThat(cartItem.length()).isEqualTo(maxLength);
        assertThat(cartItem).isNotNull();
    }

    /**
     * Checks if the length of the given string is less than or equal to the specified maximum length.
     *
     * @param  cartItem   the string to be checked
     * @param  maxLength the maximum allowed length
     */
    public void stringLengthLTE(String cartItem, int maxLength) {
        assertThat(cartItem.length()).isLessThanOrEqualTo(maxLength);
        assertThat(cartItem).isNotNull();
    }
}