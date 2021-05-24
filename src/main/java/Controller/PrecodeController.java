package Controller;

import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
public class PrecodeController {

    @RequestMapping(value = "/window6")
    public String getPrecode(Model model, int INDEX, String D_NAME) throws IOException, ParseException {
        model.addAttribute("Title", "Window-6");
        Precode precode = Precode.getInstance();
        precode.setDvmIndex(INDEX);
        precode.setCode(Precode.getPrecode(precode.getDvmIndex(), D_NAME));
        model.addAttribute("RandomCode", precode.getCode());
        return "main/window_6";
    }

    @RequestMapping(value = "/window3/answerPrecodeInfo")
    public String answerPrecodeInfo(Model model, int INDEX, String CODE) throws IOException {
        model.addAttribute("Title", "Window-3");
        Precode precode = Precode.getInstance();
        precode.setDvmIndex(INDEX);
        precode.setCode(CODE);
        model.addAttribute("Info", Precode.answerPrecodeInfo(precode.getDvmIndex(), precode.getCode()));
        return "main/window_3";
    }

}
