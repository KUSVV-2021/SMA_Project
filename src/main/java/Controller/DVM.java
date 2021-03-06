package Controller;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class DVM {
    private static DVM dvm;
    private static String itemList;
    private static int seq;

    private DVM(){
        dvm = null;
        itemList = "";
    }

    public static DVM getInstance() {
        if(dvm == null) {
            dvm = new DVM();
        }
        return dvm;
    }

    public void setItemList(String itemList) {
        this.itemList = itemList;
    }

    public String getItemList() {
        return itemList;
    }

    static String getDrinkList(int INDEX) throws IOException {
        if ( INDEX < 1 ) return "";

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

        URL obj = new URL("http://3.35.83.31:9090/drink/getDrinkList");

        HttpURLConnection con = (HttpURLConnection)obj.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
        con.setDoOutput(true);
        con.getOutputStream().write(postDataBytes);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while((inputLine = in.readLine()) != null){
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }

    static String buyDrink(int SEQ, int INDEX) throws IOException {
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

        URL obj = new URL("http://3.35.83.31:9090/drink/buyDrink");

        HttpURLConnection con = (HttpURLConnection)obj.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
        con.setDoOutput(true);
        con.getOutputStream().write(postDataBytes);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while((inputLine = in.readLine()) != null){
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }

    static String getDrinkInfoFromOtherDVM(String D_NAME, int INDEX, float lng, float lat) throws IOException {
        String result = getOtherDVMObject(D_NAME, INDEX);
        JSONParser parser = new JSONParser();
        Object o;
        try {
            o = parser.parse(result);
        } catch (Exception e) {
            return result;
        }
        JSONObject jsonObj = (JSONObject) o;

        JSONArray ja = (JSONArray) ((JSONObject)jsonObj.get("R")).get("list");

        JSONObject index = calculateDistance(ja, lng, lat);

        String returnV = "";
        if (index != null) {
            index.put("D_NAME", D_NAME);
            returnV = index.toString();
        }
        else
            returnV = "";

        return returnV;
    }

    private static String getOtherDVMObject(String D_NAME, int INDEX) throws IOException {
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

        URL obj = new URL("http://3.35.83.31:9090/drink/getDrinkInfoFromOtherDVM");

        HttpURLConnection con = (HttpURLConnection)obj.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
        con.setDoOutput(true);
        con.getOutputStream().write(postDataBytes);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while((inputLine = in.readLine()) != null){
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }

    static JSONObject calculateDistance(JSONArray ja, float lng, float lat) {
        if (ja == null) return null;
        JSONObject index = null;
        float min = 100000;
        for ( Object o1 : ja) {
            JSONObject jo = (JSONObject) o1;
            float m = Math.abs(Float.parseFloat(jo.get("LONGITUDE").toString())-lng)
                    + Math.abs(Float.parseFloat(jo.get("LATITUDE").toString())-lat);
            if (m < min) {
                min = m;
                index = jo;
            }
        }
        return index;
    }

}
