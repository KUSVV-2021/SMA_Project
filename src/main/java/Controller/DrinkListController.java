package Controller;

import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;


@Controller
public class DrinkListController {

    @RequestMapping(value = "/window2")
    public String windowSecond(Model model, int INDEX) throws IOException, ParseException {
        model.addAttribute("Title", "Window-2");
        model.addAttribute("Data", getDrinkList(INDEX));
        return "main/window_2";
    }

    String getDrinkList(int INDEX) throws IOException {
        URL obj = null;

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("INDEX", INDEX);

        StringBuilder postData = new StringBuilder();
        for(Map.Entry<String,Object> param : params.entrySet()) {
            if(postData.length() != 0) postData.append('&');
            postData.append(param.getKey());
            postData.append('=');
            postData.append(param.getValue());
        }
        byte[] postDataBytes = postData.toString().getBytes("UTF-8");

        obj = new URL("http://localhost:8080/MainProject/drink/getDrinkList");

        HttpURLConnection con = (HttpURLConnection)obj.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
        con.setDoOutput(true);
        con.getOutputStream().write(postDataBytes);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while((inputLine = in.readLine()) != null){
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }

    @RequestMapping(value = "/window2/buyDrink")
    public String buyDrink(Model model, int SEQ, int INDEX) throws IOException, ParseException {
        model.addAttribute("Title", "Window-2");
        model.addAttribute("Data", getDrinkList(INDEX));
        model.addAttribute("Buy", buyDrink(SEQ, INDEX));
        return "main/window_2";
    }

    String buyDrink(int SEQ, int INDEX) throws IOException {
        URL obj = null;

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("INDEX", INDEX);
        params.put("D_SEQ", SEQ);

        StringBuilder postData = new StringBuilder();
        for(Map.Entry<String,Object> param : params.entrySet()) {
            if(postData.length() != 0) postData.append('&');
            postData.append(param.getKey());
            postData.append('=');
            postData.append(param.getValue());
        }
        byte[] postDataBytes = postData.toString().getBytes("UTF-8");

        obj = new URL("http://localhost:8080/MainProject/drink/buyDrink");

        HttpURLConnection con = (HttpURLConnection)obj.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
        con.setDoOutput(true);
        con.getOutputStream().write(postDataBytes);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while((inputLine = in.readLine()) != null){
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }

    @RequestMapping(value = "/window2/getDrinkInfoFromOtherDVM")
    public String getDrinkInfoFromOtherDVM(Model model, String D_NAME, int INDEX) throws IOException, ParseException {
        model.addAttribute("Title", "Window-2");
        model.addAttribute("Data", getDrinkList(INDEX));
        model.addAttribute("Other", getDrinkInfoFromOtherDVM(D_NAME, INDEX));
        return "main/window_2";
    }

    String getDrinkInfoFromOtherDVM(String D_NAME, int INDEX) throws IOException {
        URL obj = null;

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("INDEX", INDEX);
        params.put("D_NAME", D_NAME);

        StringBuilder postData = new StringBuilder();
        for(Map.Entry<String,Object> param : params.entrySet()) {
            if(postData.length() != 0) postData.append('&');
            postData.append(param.getKey());
            postData.append('=');
            postData.append(param.getValue());
        }
        byte[] postDataBytes = postData.toString().getBytes("UTF-8");
        System.out.println(postDataBytes.toString());

        obj = new URL("http://localhost:8080/MainProject/drink/getDrinkInfoFromOtherDVM?INDEX"+INDEX+"&D_NAME="+URLEncoder.encode(D_NAME, "UTF-8"));

        HttpURLConnection con = (HttpURLConnection)obj.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
        con.setDoOutput(true);
        con.getOutputStream().write(postDataBytes);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while((inputLine = in.readLine()) != null){
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }

}
