import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Days;
import org.joda.time.LocalDate;

public class DateClass {

    private LocalDate localDate;
    private DateTime nowDay;


    public DateClass(LocalDate localDate) {
        this.localDate = localDate;
    }

    public Days daysToNewYear() {
        LocalDate newYear = localDate.plusYears(1).withDayOfYear(1);
        return Days.daysBetween(localDate, newYear);
    }
    public String todaysDay(){
        nowDay = new DateTime(DateTimeZone.UTC);
        String today = nowDay.getYear() + "-" + nowDay.getMonthOfYear() + "-" + nowDay.getDayOfMonth();
        return today;
    }

}
