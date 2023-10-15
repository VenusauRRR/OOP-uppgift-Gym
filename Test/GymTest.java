import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class GymTest {
    Gym g1 = new Gym();

    @Test
    public void isCustomerTest(){
        Person p1 = new Person("8204021234","Bear Belle","2012-12-12");
        Person p2 = new Person("12345689","hello hello","2000-01-01");
        g1.customerList.add(p1);
        g1.customerList.add(p2);
        String personnr1 = "8204021234";
        String name1 = "Bear Belle";
        String personnr2 = "1234";
        String name2 = "Hello";
        assertTrue(g1.isCustomer(personnr1,name1).getPersonNr().equals("8204021234"));
        assertTrue(g1.isCustomer(personnr1,name1).getName().equals("Bear Belle"));
        assertTrue(g1.isCustomer(personnr1,name1).getLastVisitedDate().toString().equals("2012-12-12"));
        assertTrue(g1.isCustomer(personnr2,name2)==null);
    }

//    Path recept = Paths.get("src/Test/ToReception");
//    Path pt = Paths.get("src/Test/personTrainer");
    @Test
    public void readFrånFileTest(){
        String inpath = "Test/indata";
        g1.readFrånFile(inpath);
        assertTrue(g1.getCustomerList().get(0).getPersonNr().equals("7703021234"));
        assertTrue(g1.getCustomerList().get(0).getName().equals("Alhambra Aromes"));
        assertTrue(g1.getCustomerList().get(0).getLastVisitedDate().toString().equals("2023-07-01"));
    }

    public static int countLinesInFile(String filePath){
        Path p = Paths.get(filePath);
        int counter = 0;
        String temp;
        try(BufferedReader br = Files.newBufferedReader(p)){
            while ((temp = br.readLine()) != null){
                counter++;
            }
        } catch (IOException e){
            System.out.println("Invalid file path");
            e.printStackTrace();
        }
        return counter;

    }

    @Test
    public void writeToFileTest(){
        String outpath = "Test/outdata";
        Person p = new Person("8204021234","Bear Belle","2012-12-12");
        Person p2 = new Person("2204021234","Bear2 Belle","2012-12-12");
        Person p3 = new Person("4204021234","Bear3 Belle","2012-12-12");
        Person p4 = new Person("9204021234","Bear4 Belle","2012-12-12");
        g1.writeToFile(p, outpath);
        g1.writeToFile(p2, outpath);
        g1.writeToFile(p3, outpath);
        g1.writeToFile(p4, outpath);
        assertTrue(countLinesInFile(outpath)==8);
        assertTrue(countLinesInFile(outpath)!=7);
    }
}
