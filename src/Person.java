import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.logging.SimpleFormatter;

public class Person {
    protected String personNr;
    protected String name;
    protected LocalDate lastVisitedDate;
    public Person(){}

    public Person(String personNrAndName, String lastVisitedDate){
        String[] temp = personNrAndName.split(", ");
        this.personNr = temp[0];
        this.name = temp[1];
        this.lastVisitedDate = DateGym.parseDate(lastVisitedDate);
    }
    public Person(String personNr, String name, String lastVisitedDate) {
        this.personNr = personNr;
        this.name = name;
        this.lastVisitedDate = DateGym.parseDate(lastVisitedDate);
    }
    public Person(String personNr, String name, LocalDate lastVisitedDate) {
        this.personNr = personNr;
        this.name = name;
        this.lastVisitedDate = lastVisitedDate;
    }

    //check if the input person number matches the database
    public static boolean isPersonNrValid(String personNr){
        if (!isPersonNrLengthValid(personNr)){
            return false;
        }
        if (!isPersonNrDateValid(personNr.substring(0,6))){
            return false;
        }
        if (!isStringNumeric(personNr.substring(6))){
            return false;
        }
        return true;
    }

    //check if person number has correct length
    public static boolean isPersonNrLengthValid(String personNr){
        if (personNr.length()==10){
            return true;
        }
        throw new IllegalStateException("Length too short");
    }

    //check if last 4 digits in personNr is numeric
    public static boolean isStringNumeric(String personNr){
        try {
            Double.parseDouble(personNr);
            return true;
        } catch (NumberFormatException e){
            throw new NumberFormatException("Last 4 digits in person number invalid");
        }
    }

//    //check if the input person name matches the database
//    public boolean isPersonNameValid(String name){
//        return name.equalsIgnoreCase(this.name) ? true : false;
//    }

    //check if birthdate in person number is a date
    public static boolean isPersonNrDateValid(String personNr){
        try {
            DateTimeFormatter f = DateTimeFormatter.ofPattern("yyMMdd");
            LocalDate ld = LocalDate.parse(personNr, DateTimeFormatter.ofPattern("yyMMdd"));
            return true;
        } catch (DateTimeParseException e){
            throw new DateTimeException("Birthday invalid");
        }
    }

    public String getPersonNr() {
        return personNr;
    }

    public String getName() {
        return name;
    }

    public LocalDate getLastVisitedDate() {
        return lastVisitedDate;
    }
}
