package Controller;

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
import java.util.HashMap;
import java.util.Map;

@Controller
public class PrecodeController {

    @RequestMapping(value = "/window6")
    public String getPrecode(Model model, int INDEX, String D_NAME) throws IOException, ParseException {
        model.addAttribute("Title", "Window-6");
        DVM.pr.setDvmIndex(INDEX);
        DVM.pr.setCode(getCode(DVM.pr.getDvmIndex(), D_NAME));
        model.addAttribute("RandomCode", DVM.pr.getCode());
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

        obj = new URL("http://3.35.83.31:9090/drink/inputPC");

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
    public String answerPrecodeInfo(Model model, int INDEX, String CODE) throws IOException, ParseException {
        model.addAttribute("Title", "Window-3");
        DVM.pr.setDvmIndex(INDEX);
        DVM.pr.setCode(CODE);
        model.addAttribute("Info", answerPrecodeInfo(DVM.pr.getDvmIndex(), DVM.pr.getCode()));
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

        obj = new URL("http://3.35.83.31:9090/drink/answerPrecodeInfo");

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
