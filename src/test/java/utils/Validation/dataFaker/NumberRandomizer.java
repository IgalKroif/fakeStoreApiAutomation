package utils.Validation.dataFaker;

import net.datafaker.Faker;
import org.junit.jupiter.api.Test;
import utils.CONSTANTS.CONSTANTS;

public class NumberRandomizer implements CONSTANTS {

    public int generateRandInt() {
        return faker.number().numberBetween(1,7);
    }

    public double generateRandDouble() {
        return faker.number().randomDouble(32, 1, 10);
    }

    public long generateRandLong() {
        return faker.number().numberBetween(Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public float generateRandFloat() {
        return (float) faker.number().randomDouble(2, 1, 10);
    }

    @Test
    public void test() {
        System.out.println(generateRandInt());
        System.out.println(generateRandDouble());
        System.out.println(generateRandLong());
        System.out.println(generateRandFloat());
    }
}
