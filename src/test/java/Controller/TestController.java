package Controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.logging.*;
import static org.junit.jupiter. api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Disabled
public class TestController {
    static Logger log = Logger.getLogger(TestController.class.getName());
    @Test
    void basic() {
        assertEquals(2, 1 + 1);
    }

    @ParameterizedTest
    @ValueSource(ints = { 1, 5 })
    void isPositive(int number) {
        assertTrue(number > 0);
    }

    @RepeatedTest(5)
    void repeatedTest() {
        System.out.println("테스트 반복!");
    }
}
