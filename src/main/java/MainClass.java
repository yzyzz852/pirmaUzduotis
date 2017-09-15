import com.jaunt.NotFound;
import com.jaunt.ResponseException;
import com.jaunt.UserAgent;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;

import java.io.IOException;
import java.util.Scanner;

public class MainClass {
    //variables
    public static UserAgent userAgent = new UserAgent();
    public static LocalDate dateTime = new LocalDate(DateTimeZone.UTC);
    public static String appLink = "https://play.google.com/store/apps/details?id=free.wordgames.cat.dog.goat.horse.bear.guess.awesome.babygames.good.time.animals";
    //Classes
    public static JsonParserClass jsonParser = new JsonParserClass("http://freegeoip.net/json/");
    public static AppStatisticsClass appStat = new AppStatisticsClass(appLink);
    public static DateClass dates = new DateClass(dateTime);
    public static RandomNameClass randomName = new RandomNameClass();
    public static RcSongClass song = new RcSongClass("http://rc.lt/");
    public static SystemInfoClass systemInfo = new SystemInfoClass();
    public static WhetherItemClass  wheter = new WhetherItemClass(userAgent);

    public static void main(String[] args) throws NotFound, ResponseException, IOException {
        boolean userUse = true;
        System.out.println("\tSveiki! Jusu vardas sios sesijos metu bus: " + randomName.gettRandomName());
        while (userUse == true) {
            Scanner in = new Scanner(System.in);
            // Display the menu
            System.out.println("\tGauti:");
            System.out.println("1\t Google Play Store programos atsisiuntimu kieki");
            System.out.println("2\t Siandienos data");
            System.out.println("3\t Tinklo inforamcija");
            System.out.println("4\t Rc grojama daina");
            System.out.println("5\t Oro temperatura");
            System.out.println("6\t Visa informacija");
            System.out.println("7\t Iseiti");

            System.out.println("Jusu pasirinkimas:");

            //Get user's choice
            int choice = in.nextInt();

            //Display the title of the chosen module
            switch (choice) {
                case 1:
                    System.out.println("Pavadinimas: " +appStat.getAppName()+ "\nAtsisiuntimu kiekis: " + appStat.getDownloadsSize());
                    break;
                case 2:
                    System.out.println("Siandien yra: " + dates.todaysDay() + "\nIki naujuju liko: " + dates.daysToNewYear().getDays());
                    break;
                case 3:
                    System.out.println("Jusu IP: " +jsonParser.getIp() + "\nJusu laiko zona: " +jsonParser.getTimeZone()+
                    "\nJusu salis: "+jsonParser.getCountryName()+ "\nJusu salies kodas: "+jsonParser.getCountryCode());
                    break;
                case 4:
                    System.out.println("Siuo metu Radio centras groja: "+song.getTitle() +" - " +song.getSongName());
                    break;
                case 5:
                    System.out.println("Siuo metu mieste "+wheter.getCityName() +" yra " +wheter.getWheter());
                    break;
                case 6:
                    System.out.println("Proramos pavadinimas: " +appStat.getAppName()+ "\nAtsisiuntimu kiekis: " + appStat.getDownloadsSize());
                    System.out.println("\nSiandien yra: " + dates.todaysDay() + "\nIki naujuju liko: " + dates.daysToNewYear().getDays());
                    System.out.println("\nJusu IP: " +jsonParser.getIp() + "\nJusu laiko zona: " +jsonParser.getTimeZone()+
                            "\nJusu salis: "+jsonParser.getCountryName()+ "\nJusu salies kodas: "+jsonParser.getCountryCode());
                    System.out.println("\nSiuo metu Radio centras groja: "+song.getTitle() +" - " +song.getSongName());
                    System.out.println("\nSiuo metu mieste "+wheter.getCityName() +" yra " +wheter.getWheter());
                    break;
                case 7:
                    userUse = false;
                    break;
                default:
                    System.out.println("Toks pasirinkimas neegzistuoja");
            }//end of switch
        }//end while
    }//main
}//class
