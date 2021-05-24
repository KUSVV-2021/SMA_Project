package Controller;

import org.junit.jupiter.api.RepeatedTest;

import java.io.IOException;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DVMTest {
    static Logger log = Logger.getLogger(DVMTest.class.getName());

    int i = 0;
    @RepeatedTest(15)
    void getDrinkListTest() throws IOException {
        try {
            DVM.getDrinkList(i++);
        } catch ( Exception e ) {
            assertFalse(e != null);
            return;
        }
        assertTrue(true);
    }        //getDrinkList


}
