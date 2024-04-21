package utils.validation.dataRandomizer;

import utils.CONSTANTS.CONSTANTS;

import static CreateRequest.cart.GetCartRequest.faker;

public class NumberRandomizer implements CONSTANTS {

    public static int generateRandInt() {
        return faker.number().numberBetween(1,7);
    }
    public static int generateRandInt(int min, int max) {
        return faker.number().numberBetween(min,max);
    }

    public static double generateRandDouble() {
        return faker.number().randomDouble(32, 1, 10);
    }

    public static long generateRandLong() {
        return faker.number().numberBetween(Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static float generateRandFloat() {
        return (float) faker.number().randomDouble(2, 1, 10);
    }

}
