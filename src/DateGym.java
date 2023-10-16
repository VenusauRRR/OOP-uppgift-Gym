import java.time.LocalDate;
import java.time.Period;

public class DateGym {

    //generate date of today
    public static LocalDate todayDate(){
        return LocalDate.now();
    }

    //parsing a string of date to LocalDate
    public static LocalDate parseDate(String dateString){
        return LocalDate.parse(dateString);
    }

    //check if the customer paid his/her fee for mroe than 1 year
    public static boolean isFeePaid1YrAgo(LocalDate lastVisitedDate){
        Period p = Period.between(lastVisitedDate,todayDate());
        if (p.getYears()>=1){
            return true;
        }
        return false;
    }

}//class
