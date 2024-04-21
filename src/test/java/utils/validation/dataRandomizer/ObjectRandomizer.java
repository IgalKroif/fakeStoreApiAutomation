package utils.validation.dataRandomizer;

import net.datafaker.Faker;

import java.io.Serializable;
import java.util.*;

public class ObjectRandomizer {

    private static final Faker faker = new Faker();

    public static Optional<? extends Serializable> generateRandObject() {
        List<Serializable> characters = Arrays.asList(
                faker.naruto().character(),
                faker.doraemon().character(),
                faker.simpsons().character(),
                faker.futurama().character(),
                faker.harryPotter().character(),
                faker.dog().name(),
                faker.cat().name(),
                faker.name().firstName(),
                faker.name().lastName(),
                faker.name().fullName(),
                faker.name().title(),
                faker.number().digits(10),
                faker.number().numberBetween(0, 1000),
                faker.number().randomDouble(4, 0, 1000),
                faker.bool().bool(),
                faker.hashCode()
        );
        Collections.shuffle(characters); // Shuffle the list to get a random order
        return characters.stream()
                .filter(Objects::nonNull)
                .findAny();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Optional<? extends Serializable> randObject = generateRandObject();
            randObject.ifPresent(System.out::println);
        }
    }
}