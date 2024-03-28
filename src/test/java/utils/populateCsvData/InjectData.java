package utils.populateCsvData;

import org.testng.annotations.BeforeTest;

public class InjectData {

    /**
     * Populates valid IDs from a CSV file.
     *
     * @param id - the ID to be populated
     * @return the populated ID
     */
    @BeforeTest
    public static Integer populateValidIds(int id) {return id;}

    /**
     * This method populates invalid IDs from a CSV file.
     *
     * @param id The ID to be populated.
     * @return The populated ID.
     */
    @BeforeTest
    public static Object populateInvalidIds(Object id) {return id;}
}