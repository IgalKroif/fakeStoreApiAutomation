package utils.Validation.dataFaker;

import utils.CONSTANTS.CONSTANTS;

public class BooleanRandomizer implements CONSTANTS {

    public boolean generateRandomBool() {
        return faker.bool().bool();
    }
}
