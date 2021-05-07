package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping(value = "/")
    public String test(Model model) {
        model.addAttribute("msg", "Hello world");
        return "index";
    }
    @RequestMapping(value = "/window1")
    public String windowFirst(Model model) {
        model.addAttribute("Title", "Window-1");
        return "main/window_1";
    }
    @RequestMapping(value = "/window2")
    public String windowSecond(Model model) {
        model.addAttribute("Title", "Window-2");
        return "main/window_2";
    }
    @RequestMapping(value = "/window3")
    public String windowThird(Model model) {
        model.addAttribute("Title", "Window-3");
        return "main/window_1";
    }
}
