package Controller;

import org.junit.jupiter.api.*;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentTest {

    int i = 0;
    @RepeatedTest(20)
    void getPaymentList() throws IOException {
        assertFalse(Payment.getPaymentList(i++).contains("HTTP Status 500 – Internal Server Error"));
    }

}
