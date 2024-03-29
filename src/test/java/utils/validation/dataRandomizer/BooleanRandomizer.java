package utils.validation.dataRandomizer;

import utils.CONSTANTS.CONSTANTS;

public class BooleanRandomizer implements CONSTANTS {

    public boolean generateRandomBool() {
        return faker.bool().bool();
    }
}
