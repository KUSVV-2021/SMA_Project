package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Random;

@Controller
public class MainController {

    @RequestMapping(value = "/")
    public String test(Model model) {
        model.addAttribute("Title", "Window-1");
        return "main/window_1";
    }
    @RequestMapping(value = "/window1")
    public String windowFirst(Model model) {
        model.addAttribute("Title", "Window-1");
        return "main/window_1";
    }
    @RequestMapping(value = "/window3")
    public String windowThird(Model model) {
        model.addAttribute("Title", "Window-3");
        return "main/window_3";
    }
    @RequestMapping(value = "/window4")
    public String window4th(Model model, String LONGITUDE, String LATITUDE) {
        model.addAttribute("Title", "Window-4");
        model.addAttribute("LO", LONGITUDE);
        model.addAttribute("LA", LATITUDE);
        return "main/window_4";
    }
    @RequestMapping(value = "/window5")
    public String window5th(Model model) {
        model.addAttribute("Title", "Window-5");
        return "main/window_5";
    }
    @RequestMapping(value = "/window6")
    public String window6th(Model model) {
        model.addAttribute("Title", "Window-6");
        String code = "";
        Random random = new Random();
        code = Integer.toString(random.nextInt() * 100000, 16);
        model.addAttribute("RandomCode", code);
        return "main/window_6";
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
    @RequestMapping(value = "/window12")
    public String window12th(Model model) {
        model.addAttribute("Title", "Window-12");
        return "main/window_12";
    }
    @RequestMapping(value = "/window13")
    public String window13th(Model model) {
        model.addAttribute("Title", "Window-13");
        return "main/window_13";
    }
    @RequestMapping(value = "/window14")
    public String window14th(Model model) {
        model.addAttribute("Title", "Window-14");
        return "main/window_14";
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
    @RequestMapping(value = "/window17")
    public String window17th(Model model) {
        model.addAttribute("Title", "Window-17");
        return "main/window_17";
    }
    @RequestMapping(value = "/window20")
    public String window20th(Model model, int PageNum, String Number) {
        model.addAttribute("Title", "Window-20");
        model.addAttribute("PageNum", PageNum);
        model.addAttribute("Number", Number);
        return "main/window_20";
    }
}
