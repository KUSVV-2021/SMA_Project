package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    public static DVM dvm;

    @RequestMapping(value = "/")
    public String test(Model model) {
        model.addAttribute("Title", "Window-1");
        return "main/window_1";
    }
    @RequestMapping(value = "/window1")
    public String windowFirst(Model model) {
        model.addAttribute("Title", "Window-1");
        dvm = DVM.getInstance();
        return "main/window_1";
    }
    @RequestMapping(value = "/window3")
    public String windowThird(Model model) {
        model.addAttribute("Title", "Window-3");
        return "main/window_3";
    }
    @RequestMapping(value = "/window4")
    public String window4th(Model model, int DVM_SEQ, int STOCK, String LONGITUDE, String LATITUDE, String D_NAME) {
        model.addAttribute("Title", "Window-4");
        model.addAttribute("LO", LONGITUDE);
        model.addAttribute("LA", LATITUDE);
        model.addAttribute("DVM_SEQ", DVM_SEQ);
        model.addAttribute("STOCK", STOCK);
        model.addAttribute("D_NAME", D_NAME);
        return "main/window_4";
    }
    @RequestMapping(value = "/window5")
    public String window5th(Model model) {
        model.addAttribute("Title", "Window-5");
        return "main/window_5";
    }


    @RequestMapping(value = "/window8")
    public String window8th(Model model, String Drink) {
        model.addAttribute("Title", "Window-8");
        model.addAttribute("Drink", Drink);
        return "main/window_8";
    }

    @RequestMapping(value = "/window13")
    public String window13th(Model model) {
        model.addAttribute("Title", "Window-13");
        return "main/window_13";
    }
    @RequestMapping(value = "/window15")
    public String window15th(Model model, String Drink) {
        model.addAttribute("Title", "Window-15");
        model.addAttribute("Drink", Drink);
        return "main/window_15";
    }
    @RequestMapping(value = "/window16")
    public String window16th(Model model, String Drink) {
        model.addAttribute("Title", "Window-16");
        model.addAttribute("Drink", Drink);
        return "main/window_16";
    }
    @RequestMapping(value = "/payment")
    public String payment(Model model, int Price) {
        model.addAttribute("Title", "Price");
        model.addAttribute("Price", Price);
        return "main/payment";
    }
    @RequestMapping(value = "/unit-test")
    public String unitTest(Model model) {
        model.addAttribute("Title", "unit-test");
        dvm = DVM.getInstance();
        return "main/unit_test";
    }
}
