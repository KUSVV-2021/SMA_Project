package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
public class PaymentController {

    @RequestMapping(value = "/window17")
    public String getPaymentList(Model model, int INDEX) throws IOException {
        model.addAttribute("Title", "Window-17");
        model.addAttribute("Data", Payment.getPaymentList(INDEX));
        return "main/window_17";
    }

}
