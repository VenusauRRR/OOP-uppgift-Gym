import java.time.LocalDate;

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
    public boolean isPersonNrValid(String personNr){
        return personNr.equals(this.personNr) ? true : false;
    }

    //check if the input person name matches the database
    public boolean isPersonNameValid(String name){
        return name.equalsIgnoreCase(this.name) ? true : false;
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
