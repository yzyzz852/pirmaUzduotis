import com.jaunt.Element;
import com.jaunt.NotFound;
import com.jaunt.ResponseException;
import com.jaunt.UserAgent;

public class AppStatisticsClass {

    private String link;
    private UserAgent playLink = new UserAgent();
    private Element appName, downloads;
    private String nameString, downloadsString;

    public AppStatisticsClass(String link) {
        this.link = link;
    }

    public String getAppName() throws NotFound, ResponseException {
        playLink.visit(link);
        appName = playLink.doc.findFirst("<div class=id-app-title>");
        downloadsString = appName.innerHTML();
        return downloadsString;
    }
    public String getDownloadsSize() throws NotFound, ResponseException {
        playLink.visit(link);
        downloads = playLink.doc.findFirst("<div class=content itemprop=numDownloads>");
        nameString = downloads.innerHTML();
        return nameString;
    }
}
