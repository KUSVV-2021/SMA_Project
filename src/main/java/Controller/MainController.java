package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    public static DVM dvm;

    @RequestMapping(value = "/")
    public String test(Model model) {
        model.addAttribute(Attribute.title, "Window-1");
        return "main/window_1";
    }
    @RequestMapping(value = "/window1")
    public String windowFirst(Model model) {
        model.addAttribute(Attribute.title, "Window-1");
        dvm = DVM.getInstance();
        return "main/window_1";
    }
    @RequestMapping(value = "/window3")
    public String windowThird(Model model) {
        model.addAttribute(Attribute.title, "Window-3");
        return "main/window_3";
    }
    @RequestMapping(value = "/window4")
    public String window4th(Model model, int DVM_SEQ, int STOCK, String LONGITUDE, String LATITUDE, String D_NAME) {
        model.addAttribute(Attribute.title, "Window-4");
        model.addAttribute(Attribute.lo, LONGITUDE);
        model.addAttribute(Attribute.la, LATITUDE);
        model.addAttribute(Attribute.dvm_seq, DVM_SEQ);
        model.addAttribute(Attribute.stock, STOCK);
        model.addAttribute(Attribute.d_name, D_NAME);
        return "main/window_4";
    }
    @RequestMapping(value = "/window5")
    public String window5th(Model model) {
        model.addAttribute(Attribute.title, "Window-5");
        return "main/window_5";
    }


    @RequestMapping(value = "/window8")
    public String window8th(Model model, String Drink) {
        model.addAttribute(Attribute.title, "Window-8");
        model.addAttribute(Attribute.drink, Drink);
        return "main/window_8";
    }

    @RequestMapping(value = "/window13")
    public String window13th(Model model) {
        model.addAttribute(Attribute.title, "Window-13");
        return "main/window_13";
    }
    @RequestMapping(value = "/window15")
    public String window15th(Model model, String Drink) {
        model.addAttribute(Attribute.title, "Window-15");
        model.addAttribute(Attribute.drink, Drink);
        return "main/window_15";
    }
    @RequestMapping(value = "/window16")
    public String window16th(Model model, String Drink) {
        model.addAttribute(Attribute.title, "Window-16");
        model.addAttribute(Attribute.drink, Drink);
        return "main/window_16";
    }
    @RequestMapping(value = "/payment")
    public String payment(Model model, int Price) {
        model.addAttribute(Attribute.title, Attribute.price);
        model.addAttribute(Attribute.price, Price);
        return "main/payment";
    }
    @RequestMapping(value = "/unit-test")
    public String unitTest(Model model) {
        model.addAttribute(Attribute.title, "unit-test");
        dvm = DVM.getInstance();
        return "main/unit_test";
    }
}
