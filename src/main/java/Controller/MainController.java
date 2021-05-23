package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Random;

import static java.lang.Math.abs;

@Controller
public class MainController {
    public DVM dvm;

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
    public String window4th(Model model, int DVM_SEQ, String LONGITUDE, String LATITUDE, String D_NAME) {
        model.addAttribute("Title", "Window-4");
        model.addAttribute("LO", LONGITUDE);
        model.addAttribute("LA", LATITUDE);
        model.addAttribute("DVM_SEQ", DVM_SEQ);
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

    @RequestMapping(value = "/window7")
    public String window7th(Model model) {
        model.addAttribute("Title", "Window-7");
        return "main/window_7";
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
    @RequestMapping(value = "/window20")
    public String window20th(Model model, int PageNum, String Number) {
        model.addAttribute("Title", "Window-20");
        model.addAttribute("PageNum", PageNum);
        model.addAttribute("Number", Number);
        return "main/window_20";
    }
    @RequestMapping(value = "/payment")
    public String payment(Model model, int Price) {
        model.addAttribute("Title", "Price");
        model.addAttribute("Price", Price);
        return "main/payment";
    }
}
