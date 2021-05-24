package Controller;

import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.*;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class LocationTest {

    int i = 0;
    @RepeatedTest(10)
    void getDrinkListTest() throws IOException, ParseException {
        assertNotNull(Location.getLocationInfo(i++));
    }

}
