import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JsonParserClass {

    public String sUrl;
    private String countryCode, countryName,timeZone, ip;
    JsonObject rootobj;

    public JsonParserClass(String sUrl) {
        this.sUrl = sUrl;
    }

    public String getsUrl() {
        return sUrl;
    }

    private void jsonWork() throws IOException {

        URL url = new URL(getsUrl());
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();
        JsonParser jp = new JsonParser(); //from gson
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); //Convert the input stream to a json element
        rootobj = root.getAsJsonObject(); //May be an array, may be an object.
    }

    public String getCountryCode() throws IOException {
        jsonWork();
        return rootobj.get("country_code").getAsString();
    }

    public String getIp() throws IOException {
        jsonWork();
        return rootobj.get("ip").getAsString();
    }
    public String getTimeZone() throws IOException {
        jsonWork();
        return rootobj.get("time_zone").getAsString();
    }
    public String getCountryName() throws IOException {
        jsonWork();
        return rootobj.get("country_name").getAsString();
    }

}
