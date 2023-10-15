import java.time.LocalDate;
import java.time.Period;

public class DateGym {
    public static LocalDate todayDate(){
        return LocalDate.now();
    }
    public static LocalDate parseDate(String dateString){
        return LocalDate.parse(dateString);
    }
    public static boolean isFeePaid1YrAgo(LocalDate lastVisitedDate){
        Period p = Period.between(lastVisitedDate,todayDate());
        if (p.getYears()>=1){
            return true;
        }
        return false;
    }

}//class
