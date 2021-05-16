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

    @RequestMapping(value = "/window2")
    public String windowSecond(Model model, int INDEX) throws IOException, ParseException {
        model.addAttribute("Title", "Window-2");
        model.addAttribute("Data", getDrinkList(INDEX));
        return "main/window_2";
    }

    @RequestMapping(value = "/window12")
    public String window12th(Model model, int INDEX) throws IOException {
        model.addAttribute("Title", "Window-12");
        model.addAttribute("Data", getDrinkList(INDEX));
        return "main/window_12";
    }

    @RequestMapping(value = "/window14")
    public String window14th(Model model, int INDEX) throws IOException {
        model.addAttribute("Title", "Window-14");
        model.addAttribute("Data", getDrinkList(INDEX));
        return "main/window_14";
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
        JSONObject jo = getLocationInfo(INDEX);
        try {
            model.addAttribute("Other", getDrinkInfoFromOtherDVM(D_NAME, INDEX, Float.parseFloat(((JSONObject)jo.get("R")).get("LONGITUDE").toString()), Float.parseFloat(((JSONObject)jo.get("R")).get("LATITUDE").toString())));
        } catch (Exception e) {
            model.addAttribute("Other", "<result='2'>");
        }
        return "main/window_2";
    }

    private JSONObject getLocationInfo(int index) throws IOException, ParseException {
        URL obj = null;

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("INDEX", index);

        StringBuilder postData = new StringBuilder();
        for(Map.Entry<String,Object> param : params.entrySet()) {
            if(postData.length() != 0) postData.append('&');
            postData.append(param.getKey());
            postData.append('=');
            postData.append(param.getValue());
        }
        byte[] postDataBytes = postData.toString().getBytes("UTF-8");

        obj = new URL("http://localhost:8080/MainProject/drink/getLocationInfo");

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
        JSONParser parser = new JSONParser();
        Object o = parser.parse( response.toString() );
        return (JSONObject) o;
    }

    String getDrinkInfoFromOtherDVM(String D_NAME, int INDEX, float lng, float lat) throws IOException, ParseException {
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

        obj = new URL("http://localhost:8080/MainProject/drink/getDrinkInfoFromOtherDVM");

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
        JSONParser parser = new JSONParser();
        Object o = parser.parse( response.toString() );
        JSONObject jsonObj = (JSONObject) o;

        JSONArray ja = (JSONArray) ((JSONObject)jsonObj.get("R")).get("list");

        JSONObject index = getDistance(ja, lng, lat);
        index.put("D_NAME", D_NAME);

        return index!=null?index.toString():"";
    }

    JSONObject getDistance(JSONArray ja, float lng, float lat) {
        JSONObject index = null;
        float min = 100000;
        for ( Object o1 : ja) {
            JSONObject jo = (JSONObject) o1;
            float m = Math.abs(Float.parseFloat(jo.get("LONGITUDE").toString())-lng)+Math.abs(Float.parseFloat(jo.get("LATITUDE").toString())-lat);
            if (m < min) {
                min = m;
                index = jo;
            }
        }
        return index;
    }

    @RequestMapping(value = "/window6")
    public String window6th(Model model, int INDEX, String D_NAME) throws IOException, ParseException {
        model.addAttribute("Title", "Window-6");
        model.addAttribute("RandomCode", getCode(INDEX, D_NAME));
        return "main/window_6";
    }

    String getCode(int INDEX, String D_NAME) throws IOException, ParseException {
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

        obj = new URL("http://localhost:8080/MainProject/drink/inputPC");

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

        JSONParser parser = new JSONParser();
        Object o = parser.parse( response.toString() );
        JSONObject jsonObj = (JSONObject) o;
        return  ((JSONObject)jsonObj.get("R")).get("code").toString();
    }

    @RequestMapping(value = "/window3/answerPrecodeInfo")
    public String windowThird(Model model, int INDEX, String CODE) throws IOException, ParseException {
        model.addAttribute("Title", "Window-3");
        model.addAttribute("Info", answerPrecodeInfo(INDEX, CODE));
        return "main/window_3";
    }

    String answerPrecodeInfo(int INDEX, String CODE) throws IOException, ParseException {
        URL obj = null;

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("INDEX", INDEX);
        params.put("CODE", CODE);

        StringBuilder postData = new StringBuilder();
        for(Map.Entry<String,Object> param : params.entrySet()) {
            if(postData.length() != 0) postData.append('&');
            postData.append(param.getKey());
            postData.append('=');
            postData.append(param.getValue());
        }
        byte[] postDataBytes = postData.toString().getBytes("UTF-8");
        System.out.println(postDataBytes.toString());

        obj = new URL("http://localhost:8080/MainProject/drink/answerPrecodeInfo");

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

    @RequestMapping(value = "/window13/addItemlist")
    public String window13th(Model model, String NAME, int PRICE, int INDEX) throws IOException {
        model.addAttribute("Title", "Window-12");
        model.addAttribute("Data", addItemlist(NAME, PRICE, INDEX));
        return "main/window_12";
    }

    String addItemlist(String NAME, int PRICE, int INDEX) throws IOException {
        URL obj = null;

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("D_NAME", NAME);
        params.put("D_PRICE", PRICE);
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

        obj = new URL("http://localhost:8080/MainProject/drink/addNewDrink");

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

        obj = new URL("http://localhost:8080/MainProject/admin/removeDrink");

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

        obj = new URL("http://localhost:8080/MainProject/admin/changeDrink");

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

        obj = new URL("http://localhost:8080/MainProject/admin/getSellRecord");

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


