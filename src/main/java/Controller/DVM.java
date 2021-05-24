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
    private static DVM dvm = null;
    private static String itemList;
    private static int seq;

    private DVM(){
        itemList = "";       //음료정보들 초기화
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

        obj = new URL("http://3.35.83.31:9090/drink/getDrinkList");

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

    static String buyDrink(int SEQ, int INDEX) throws IOException {
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

        obj = new URL("http://3.35.83.31:9090/drink/buyDrink");

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

    static String getDrinkInfoFromOtherDVM(String D_NAME, int INDEX, float lng, float lat) throws IOException, ParseException {
        JSONArray ja = getOtherDVMObject(D_NAME, INDEX);

        JSONObject index = calculateDistance(ja, lng, lat);
        index.put("D_NAME", D_NAME);

        return index!=null?index.toString():"";
    }

    private static JSONArray getOtherDVMObject(String D_NAME, int INDEX) throws IOException, ParseException {
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

        obj = new URL("http://3.35.83.31:9090/drink/getDrinkInfoFromOtherDVM");

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

        return (JSONArray) ((JSONObject)jsonObj.get("R")).get("list");
    }

    static JSONObject calculateDistance(JSONArray ja, float lng, float lat) {
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

}
