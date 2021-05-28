package Controller;

import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.*;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class PrecodeTest {

    @Test
    void getCodeTest() {
        assertNotNull(Precode.getInstance().getCode());
    }

    @Test
    void getDvmIndexTest() {
        assertEquals(-1, Precode.getInstance().getDvmIndex());
    }

    int i = 0;
    @RepeatedTest(20)
    void answerPrecodeInfoTest() throws IOException {
        assertFalse(Precode.answerPrecodeInfo(i++, "").contains("HTTP Status 500 – Internal Server Error"));
    }

    int gpi = 1;
    @RepeatedTest(20)
    void getPrecodeTest() throws IOException, ParseException {
        assertFalse(Precode.getPrecode(gpi++, "").contains("HTTP Status 500 – Internal Server Error"));
    }

}
