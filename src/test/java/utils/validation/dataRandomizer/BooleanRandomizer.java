package utils.validation.dataRandomizer;

import utils.CONSTANTS.CONSTANTS;

import static CreateRequest.cart.GetCartRequest.faker;

public class BooleanRandomizer implements CONSTANTS {

    public boolean generateRandomBool() {
        return faker.bool().bool();
    }
}
