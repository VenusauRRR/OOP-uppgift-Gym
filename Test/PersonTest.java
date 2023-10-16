import org.junit.Test;
import static org.junit.Assert.*;

public class PersonTest {
    Person p1 = new Person();

    @Test
    public void isPersonNrValidTest(){
        Person p2 = new Person("8512021234","Chamade Coriola","2018-03-12");
        String pn1 = "8512021234";
        String pn2 = "123abc";
        assertTrue(p2.isPersonNrValid(pn1));
        assertFalse(p2.isPersonNrValid(pn2));
    }

    @Test
    public void isPersonNameValidTest(){
        Person p1 = new Person("1234567890","Peter","2012-12-12");
        String n1 = "Peter";
        String n2 = "abc";
        assertTrue(p1.isPersonNameValid(n1));
        assertFalse(p1.isPersonNameValid(n2));
    }
}
