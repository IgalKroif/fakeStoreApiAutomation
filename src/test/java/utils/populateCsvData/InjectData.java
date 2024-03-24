package utils.populateCsvData;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.testng.annotations.BeforeTest;

public class InjectData {
    /**
     * A description of the entire Java function.
     *
     * @param  id	description of parameter
     * @return         	description of return value
     */
    @BeforeTest
    @ParameterizedTest
    @CsvFileSource(resources = "/CSVS/CART_IDS.csv", numLinesToSkip = 1)
    public static Integer populateValidIds(int id) {
        return id;
    }
     @BeforeTest
    @ParameterizedTest
    @CsvFileSource(resources = "/CSVS/CART_IDS.csv", numLinesToSkip = 1)
    public static Object populateInvalidIds(Object id) {
        return id;
    }
}