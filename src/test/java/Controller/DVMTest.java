package Controller;

import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class DVMTest {

    @Test
    void getItemListTest() {
        assertNotNull(DVM.getInstance().getItemList());
    }

    int i = 0;
    @RepeatedTest(10)
    void getDrinkListTest() throws IOException {
        assertFalse(DVM.getDrinkList(i++).contains("HTTP Status 500 – Internal Server Error"));
    }        //getDrinkList

    int bdi = 1, bdj = 1;
    @RepeatedTest(150)
    void buyDrink() throws IOException {
        assertFalse(DVM.buyDrink(bdi, bdj).contains("HTTP Status 500 – Internal Server Error"));
        if ( bdi%20 == 0 ) {
            bdj++;
            bdi = 0;
        }
    }

    int gdifodi = 1;
    @RepeatedTest(20)
    void getDrinkInfoFromOtherDVM() throws IOException, ParseException {
        Random random = new Random();
        float lng = 3+(random.nextFloat()*3);
        float lat = 3+(random.nextFloat()*3);
        System.out.println("lng:lat = " +lng+ ":" +lat);
        assertTrue(DVM.getDrinkInfoFromOtherDVM("", gdifodi++, lng, lat) != null);
    }
}
