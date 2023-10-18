import org.junit.Test;

import java.time.DateTimeException;
import java.util.zip.DataFormatException;

import static org.junit.Assert.*;

public class PersonTest {
    Person p1 = new Person();

    @Test
    public void isPersonNrValidTest(){
        Person p2 = new Person("8512021234","Chamade Coriola","2018-03-12");
        String pn1 = "8512021234";
        String pn2 = "123abc";
        assertTrue(p2.isPersonNrValid(pn1));
        Throwable exception = assertThrows(IllegalStateException.class,
                () -> Person.isPersonNrValid(pn2));
    }

    @Test
    public void isPersonNrLengthValidTest(){
        String st1 = "1234567890";
        String st2 = "123";
        assertTrue(p1.isPersonNrLengthValid(st1));
        Throwable exception = assertThrows(IllegalStateException.class,
                () -> Person.isPersonNrValid(st2));
    }

    @Test
    public void isStringNumericTest(){
        String st1 = "1234567890";
        String st2 = "abc1234567";
        assertTrue(p1.isStringNumeric(st1));
        Throwable exception = assertThrows(NumberFormatException.class,
                () -> Person.isStringNumeric(st2));
    }
    @Test
    public void isPersonNrDateValidTest(){
        String st1 = "231220";
        String st2 = "123456";
        assertTrue(p1.isPersonNrDateValid(st1));
        Throwable exception1 = assertThrows(DateTimeException.class,
                () -> Person.isPersonNrDateValid(st2));

    }
}
