package utils.validation.Fields;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class IntegerValidation {
    private final Logger logger = LoggerFactory.getLogger(IntegerValidation.class);

    /**
     * Checks if the given integer is greater than or equal to the specified value, and if it falls within the specified range.
     *
     * @param  cartItem  the integer to be checked
     * @param  GTE       the value that the integer should be greater than or equal to
     * @param  betweenValues  an array of two integers representing the range that the integer should fall within (optional)
     */
    public void intGreaterEqualTo(int cartItem, int GTE, int... betweenValues) {
        try {
            assertThat(cartItem).isGreaterThanOrEqualTo(GTE).describedAs("int");
            if (betweenValues.length >= 2) {
                assertThat(cartItem).isBetween(betweenValues[0], betweenValues[1]);
            }

        }catch (AssertionError e) {
            logger.error(e.getMessage(), e);
            throw e;
        }
    }

    public void intGreaterEqualTo(int cartItem, int GTE) {
        assertThat(cartItem).isGreaterThanOrEqualTo(GTE).isInstanceOf(Integer.class);
    }
    public void intLessThanEqualTo(int cartItem, int LTE) {
        assertThat(cartItem).isLessThanOrEqualTo(LTE).isInstanceOf(Integer.class);
    }
}