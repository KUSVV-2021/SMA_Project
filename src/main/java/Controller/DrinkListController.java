package Controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.crypto.Data;
import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;


@Controller
public class DrinkListController {

    @RequestMapping(value = "/window2")
    public String windowSecond(Model model) throws IOException, ParseException {
        model.addAttribute("Title", "Window-2");
        model.addAttribute("Data", actionAPI());
        return "main/window_2";
    }

    String actionAPI() throws IOException {
        URL obj = null;

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("INDEX", 1);

        StringBuilder postData = new StringBuilder();
        for(Map.Entry<String,Object> param : params.entrySet()) {
            if(postData.length() != 0) postData.append('&');
            postData.append(param.getKey());
            postData.append('=');
            postData.append(param.getValue());
        }
        byte[] postDataBytes = postData.toString().getBytes("UTF-8");

        obj = new URL("http://localhost:9080/MainProject/drink/getDrinkList");

        HttpURLConnection con = (HttpURLConnection)obj.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
        con.setDoOutput(true);
        con.getOutputStream().write(postDataBytes);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream(), "UTF-8"));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while((inputLine = in.readLine()) != null){
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }
}
