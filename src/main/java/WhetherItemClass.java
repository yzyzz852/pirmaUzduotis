import com.jaunt.*;
import com.jaunt.UserAgent;


public class WhetherItemClass {

    UserAgent userAgent = new UserAgent();

    public WhetherItemClass(UserAgent userAgent) {
        this.userAgent = userAgent;
    }

    public UserAgent getUserAgent() {
        return userAgent;
    }

    public String getCityName() throws ResponseException, NotFound {
        userAgent.visit("https://www.gismeteo.lt/city/daily/4230/");
        Element div = userAgent.doc.findFirst("<h2 class=typeC>");
        String response = div.innerHTML();
        return response;
    }

    public String getWheter() throws ResponseException, NotFound {
        userAgent.visit("https://www.accuweather.com/lt/lt/vilnius/231459/current-weather/231459?lang=lt");
        Element div = userAgent.doc.findFirst("<span class=large-temp>");
        String response = div.innerHTML();
        String test = response.split("&")[0] + "C";
        return test;
    }

}
