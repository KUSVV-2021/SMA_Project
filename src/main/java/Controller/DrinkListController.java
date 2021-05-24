package Controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


@Controller
public class DrinkListController {

    @RequestMapping(value = "/window15/removeItemlist")
    public String removeItemlist(Model model, String D_NAME, int INDEX) throws IOException {
        model.addAttribute("Title", "Window-12");
        model.addAttribute("Data", removeItemlist(D_NAME, INDEX));
        return "main/window_12";
    }

    String removeItemlist(String NAME, int INDEX) throws IOException {
        URL obj = null;

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("D_NAME", NAME);
        params.put("INDEX", INDEX);

        StringBuilder postData = new StringBuilder();
        for(Map.Entry<String,Object> param : params.entrySet()) {
            if(postData.length() != 0) postData.append('&');
            postData.append(param.getKey());
            postData.append('=');
            postData.append(param.getValue());
        }
        byte[] postDataBytes = postData.toString().getBytes("UTF-8");
        System.out.println(postDataBytes.toString());

        obj = new URL("http://3.35.83.31:9090/admin/removeDrink");

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

        return  response.toString();
    }

    @RequestMapping(value = "/window16/changeStock")
    public String changeStock(Model model, String D_NAME, int INDEX, int PRICE, int STOCK) throws IOException {
        model.addAttribute("Title", "Window-12");
        model.addAttribute("Data", changeStock(D_NAME, INDEX, PRICE, STOCK));
        return "main/window_12";
    }

    String changeStock(String NAME, int INDEX, int PRICE, int STOCK) throws IOException {
        URL obj = null;

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("D_NAME", NAME);
        params.put("INDEX", INDEX);
        params.put("PRICE", PRICE);
        params.put("STOCK", STOCK);

        StringBuilder postData = new StringBuilder();
        for(Map.Entry<String,Object> param : params.entrySet()) {
            if(postData.length() != 0) postData.append('&');
            postData.append(param.getKey());
            postData.append('=');
            postData.append(param.getValue());
        }
        byte[] postDataBytes = postData.toString().getBytes("UTF-8");
        System.out.println(postDataBytes.toString());

        obj = new URL("http://3.35.83.31:9090/admin/changeDrink");

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

        return  response.toString();
    }

    @RequestMapping(value = "/window17")
    public String window17th(Model model, int INDEX) throws IOException {
        model.addAttribute("Title", "Window-17");
        model.addAttribute("Data", getSellRecord(INDEX));
        return "main/window_17";
    }

    String getSellRecord(int INDEX) throws IOException {
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
        System.out.println(postDataBytes.toString());

        obj = new URL("http://3.35.83.31:9090/admin/getSellRecord");

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

        return  response.toString();
    }

}


