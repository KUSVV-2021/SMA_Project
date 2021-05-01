import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExampleTest {
    private final Example exampleInstance = new Example();

    @Test
    public void addTest() {
        assertEquals(3, exampleInstance.add(1, 2));
    }

    @Test
    public void subTest() {
        assertEquals(-1, exampleInstance.sub(1, 2));
    }
}
