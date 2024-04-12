package utils.CONSTANTS;

import io.restassured.module.jsv.JsonSchemaValidator;

public interface JSON_SCHEMAS {
    JsonSchemaValidator ALL_CARTS_SCHEMA = JsonSchemaValidator.matchesJsonSchemaInClasspath(
            "SCHEMAS/allCartsSchema.json");
    JsonSchemaValidator SINGLE_CART_SCHEMA = JsonSchemaValidator.matchesJsonSchemaInClasspath(
            "SCHEMAS/singleCartSchema.json");
    JsonSchemaValidator SINGLE_CART_ERROR = JsonSchemaValidator.matchesJsonSchemaInClasspath(
            "SCHEMAS/errorSchemaSingleCart.json");
    JsonSchemaValidator CREATE_CART_SCHEMA = JsonSchemaValidator.matchesJsonSchemaInClasspath(
            "SCHEMAS/createCartSchema.json");
    JsonSchemaValidator UPDATE_CART_SCHEMA = JsonSchemaValidator.matchesJsonSchemaInClasspath(
            "SCHEMAS/updateCartSchema.json");
}