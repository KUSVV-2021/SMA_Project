package Controller;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class DVMController {

    @RequestMapping(value = "/window2")
    public String windowSecond(Model model, int INDEX) throws IOException, ParseException {
        model.addAttribute("Title", "Window-2");
        MainController.dvm.setItemList(DVM.getDrinkList(INDEX));
        model.addAttribute("Data", MainController.dvm.getItemList());
        return "main/window_2";
    }

    @RequestMapping(value = "/window12")
    public String window12th(Model model, int INDEX) throws IOException {
        model.addAttribute("Title", "Window-12");
        MainController.dvm.setItemList(DVM.getDrinkList(INDEX));
        model.addAttribute("Data", MainController.dvm.getItemList());
        return "main/window_12";
    }

    @RequestMapping(value = "/window14")
    public String window14th(Model model, int INDEX) throws IOException {
        model.addAttribute("Title", "Window-14");
        model.addAttribute("Data", DVM.getDrinkList(INDEX));
        return "main/window_14";
    }

    @RequestMapping(value = "/window2/getDrinkInfoFromOtherDVM")
    public String getDrinkInfoFromOtherDVM(Model model, String D_NAME, int INDEX) throws IOException, ParseException {
        model.addAttribute("Title", "Window-2");
        model.addAttribute("Data", DVM.getDrinkList(INDEX));
        JSONObject jo = Location.getLocationInfo(INDEX);
        try {
            model.addAttribute("Other", DVM.getDrinkInfoFromOtherDVM(D_NAME, INDEX, Float.parseFloat(((JSONObject)jo.get("R")).get("LONGITUDE").toString()), Float.parseFloat(((JSONObject)jo.get("R")).get("LATITUDE").toString())));
        } catch (Exception e) {
            model.addAttribute("Other", "<result='2'>");
        }
        return "main/window_2";
    }

    @RequestMapping(value = "/window2/buyDrink")
    public String buyDrink(Model model, int SEQ, int INDEX) throws IOException, ParseException {
        model.addAttribute("Title", "Window-2");
        model.addAttribute("Data", DVM.getDrinkList(INDEX));
        model.addAttribute("Buy", DVM.buyDrink(SEQ, INDEX));
        return "main/window_2";
    }

    @RequestMapping(value = "/window13/addItemlist")
    public String addItemlist(Model model, String NAME, int PRICE, int INDEX) throws IOException {
        model.addAttribute("Title", "Window-12");
        model.addAttribute("Data", Item.addItemlist(NAME, PRICE, INDEX));
        return "main/window_12";
    }

}
