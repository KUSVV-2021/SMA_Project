package Controller;


import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;


@Controller
public class DVMController {

    @RequestMapping(value = "/window2")
    public String windowSecond(Model model, int INDEX) throws IOException, ParseException {
        model.addAttribute(Attribute.title, "Window-2");
        if (MainController.dvm == null)
            MainController.dvm = DVM.getInstance();
        MainController.dvm.setItemList(DVM.getDrinkList(INDEX));
        model.addAttribute(Attribute.data, MainController.dvm.getItemList());
        return "main/window_2";
    }

    @RequestMapping(value = "/window12")
    public String window12th(Model model, int INDEX) throws IOException {
        model.addAttribute(Attribute.title, "Window-12");
        if (MainController.dvm == null)
            MainController.dvm = DVM.getInstance();
        MainController.dvm.setItemList(DVM.getDrinkList(INDEX));
        model.addAttribute(Attribute.data, MainController.dvm.getItemList());
        return "main/window_12";
    }

    @RequestMapping(value = "/window14")
    public String window14th(Model model, int INDEX) throws IOException {
        model.addAttribute(Attribute.title, "Window-14");
        model.addAttribute(Attribute.data, DVM.getDrinkList(INDEX));
        return "main/window_14";
    }

    @RequestMapping(value = "/window2/getDrinkInfoFromOtherDVM")
    public String getDrinkInfoFromOtherDVM(Model model, String D_NAME, int INDEX) throws IOException, ParseException {
        model.addAttribute(Attribute.title, "Window-2");
        model.addAttribute(Attribute.data, DVM.getDrinkList(INDEX));
        JSONObject jo = Location.getLocationInfo(INDEX);
        try {
            model.addAttribute(Attribute.other,
                    DVM.getDrinkInfoFromOtherDVM(
                            D_NAME, INDEX,
                            Float.parseFloat(((JSONObject)jo.get("R")).get("LONGITUDE").toString()),
                            Float.parseFloat(((JSONObject)jo.get("R")).get("LATITUDE").toString())
                    )
            );
        } catch (Exception e) {
            model.addAttribute(Attribute.other, "<result='2'>");
        }
        return "main/window_2";
    }

    @RequestMapping(value = "/window2/buyDrink")
    public String buyDrink(Model model, int SEQ, int INDEX) throws IOException, ParseException {
        model.addAttribute(Attribute.title, "Window-2");
        model.addAttribute(Attribute.data, DVM.getDrinkList(INDEX));
        model.addAttribute(Attribute.buy, DVM.buyDrink(SEQ, INDEX));
        return "main/window_2";
    }

    @RequestMapping(value = "/window13/addItemlist")
    public String addItemlist(Model model, String NAME, int PRICE, int INDEX) throws IOException {
        model.addAttribute(Attribute.title, "Window-12");
        model.addAttribute(Attribute.data, Item.addItemlist(NAME, PRICE, INDEX));
        return "main/window_12";
    }

}
