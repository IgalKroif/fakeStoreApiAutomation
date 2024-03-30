package utils.validation.dataRandomizer;

import utils.CONSTANTS.CONSTANTS;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import static CreateRequest.AllCartRequests.faker;

public class StringRandomizer implements CONSTANTS {

    public String generateRandStringName() {
        List<String> characters = Arrays.asList(
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
                faker.name().title()
        );
        return characters.stream()
                .filter(Objects::nonNull)
                .findFirst()
                .orElse("");
    }
    public String generateRandQuote() {
        List<String> quotes = Arrays.asList(
                faker.babylon5().quote(),
                faker.community().quote(),
                faker.harryPotter().quote(),
                faker.futurama().quote(),
                faker.simpsons().quote(),
                faker.hitchhikersGuideToTheGalaxy().quote(),
                faker.matz().quote(),
                faker.greekPhilosopher().quote(),
                faker.gameOfThrones().quote(),
                faker.elderScrolls().quote(),
                faker.onePiece().quote(),
                faker.fallout().quote(),
                faker.cowboyBebop().quote()
        );
        return quotes.stream()
                .filter(Objects::nonNull)
                .findFirst()
                .orElse("");
    }

    public String generateRandColors() {
        return faker.color().name();
    }

    public char generateRandomChar() {
        Random random = new Random();
        return (char) (random.nextInt(26) + 'a');
    }
    //@Test
    public void test() {
      for (int i = 0; i < 10; i++) {
         // System.out.println(generateRandStringName());
          //System.out.println(generateRandQuote());
          System.out.println(generateRandColors());
          System.out.println(generateRandomChar());
      }
    }
}
