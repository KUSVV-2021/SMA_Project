package Controller;

import org.junit.jupiter.api.*;

import java.io.IOException;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class ItemTest {

    int i = 0, price = 0;
    @RepeatedTest(20)
    void addItemlist() throws IOException {
        assertFalse(Item.addItemlist("", price, i++).contains("HTTP Status 500 – Internal Server Error"));
        price += Math.abs(new Random().nextInt(10000));
        System.out.println("price:"+price);
    }

    int csi = 0, csprice = 0, csstock = 0;
    @RepeatedTest(20)
    void changeStock() throws IOException {
        assertFalse(Item.changeStock("", csprice, csi++, csstock).contains("HTTP Status 500 – Internal Server Error"));
        csprice += Math.abs(new Random().nextInt(10000));
        csstock = Math.abs(new Random().nextInt(10));
        System.out.println("price:"+csprice+",stock:"+csstock);
    }

    int rili = 0;
    @RepeatedTest(20)
    void removeItemlist() throws IOException {
        assertFalse(Item.removeItemlist("", rili++).contains("HTTP Status 500 – Internal Server Error"));
    }
}
