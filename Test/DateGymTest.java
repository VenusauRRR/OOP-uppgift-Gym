import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DateGymTest {

    @Test
    public void isFeePaid1YrAgoTest(){
        LocalDate d1 = LocalDate.parse("2012-12-21");
        LocalDate d2 = LocalDate.parse("2023-01-21");
        assertTrue (DateGym.isFeePaid1YrAgo(d1));
        assertFalse (DateGym.isFeePaid1YrAgo(d2));
    }

    @Test
    public void todayDateTest(){
        LocalDate today = LocalDate.now();
        assertTrue(today.toString().equals(DateGym.todayDate().toString()));
    }

    @Test
    public void parseDateTest(){
        String st = "2022-11-23";
        String st1 = "1999-12-02";
        assertTrue(st.equals(DateGym.parseDate(st).toString()));
        assertFalse(st1.equals(DateGym.parseDate(st).toString()));
    }
}
