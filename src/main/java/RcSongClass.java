import org.apache.commons.lang3.text.WordUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class RcSongClass {

    String url;
    Document doc;
    Elements songName, songTitle;

    public RcSongClass(String url) {
        this.url = url;

    }

    public void connect() throws IOException {

    }

    public String getSongName () throws IOException {
        doc = Jsoup.connect(url).get();
        songName = doc.getElementsByClass("song_title");
        String justName = songName.text();
        justName = WordUtils.capitalize(formatString(justName));
        return justName;
    }
    public String getTitle() throws IOException {
        doc = Jsoup.connect(url).get();
        songTitle = doc.getElementsByClass("song_author");
        String justSongName = songTitle.text();
        justSongName = WordUtils.capitalize(formatString(justSongName));
        return justSongName;
    }
    private String formatString (String string){
        StringBuilder stringBuilder = new StringBuilder(string);
        for (int i=1; i < stringBuilder.length(); i++){
            char c = stringBuilder.charAt(i);
            if (Character.isUpperCase(c)){
                stringBuilder.setCharAt(i,Character.toLowerCase(c));
            }
        }
        return stringBuilder.toString();
    }

}
