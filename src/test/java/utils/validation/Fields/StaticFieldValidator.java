package utils.validation.Fields;

public class StaticFieldValidator {
    /**
     * Validate an integer.
     *
     * @return         	an instance of IntegerValidation
     */
    public static IntegerValidation validateInt() {
        return new IntegerValidation();
    }

    /**
     * Creates and returns a new instance of the StringValidation class.
     *
     * @return a new instance of the StringValidation class
     */
    public static StringValidation validateString() {
        return new StringValidation();
    }
}