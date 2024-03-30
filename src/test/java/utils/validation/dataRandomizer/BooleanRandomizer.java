package utils.validation.dataRandomizer;

import utils.CONSTANTS.CONSTANTS;

import static CreateRequest.AllCartRequests.faker;

public class BooleanRandomizer implements CONSTANTS {

    public boolean generateRandomBool() {
        return faker.bool().bool();
    }
}
