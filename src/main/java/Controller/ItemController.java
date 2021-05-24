package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
@Controller
public class ItemController {

    @RequestMapping(value = "/window16/changeStock")
    public String changeStock(Model model, String D_NAME, int INDEX, int PRICE, int STOCK) throws IOException {
        model.addAttribute("Title", "Window-12");
        model.addAttribute("Data", Item.changeStock(D_NAME, INDEX, PRICE, STOCK));
        return "main/window_12";
    }

    @RequestMapping(value = "/window15/removeItemlist")
    public String removeItemlist(Model model, String D_NAME, int INDEX) throws IOException {
        model.addAttribute("Title", "Window-12");
        model.addAttribute("Data", Item.removeItemlist(D_NAME, INDEX));
        return "main/window_12";
    }

}
