import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class Gym {
    protected ArrayList<Person> customerList;
    public Gym(){
        customerList = new ArrayList<>();
    }

    public Person isCustomer(String personNr, String name){
        for (Person i : customerList){
            if (i.isPersonNrValid(personNr) && i.isPersonNameValid(name)){
                return i;
            }
        }
        return null;
    }
    public void readFrånFile(String inputFilePath){
        Path inpath = Paths.get(inputFilePath);
        try(BufferedReader br = Files.newBufferedReader(inpath)){
            String temp;
            while ((temp = br.readLine()) != null){
                String firstString = temp;
                if ((temp = br.readLine()) != null){
                    String secondString = temp;
                    customerList.add(new Person(firstString, secondString));
                }
            }
        } catch (IOException e){
            System.out.println("Invalid input file");
            e.printStackTrace();
        }
    }

    public void writeToFile(Person p, String outputFilePath){
        Path outpath = Paths.get(outputFilePath);
        try{
            if (!Files.exists(outpath)){
                Files.createFile(outpath);
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        try(BufferedWriter bw = Files.newBufferedWriter(outpath,StandardOpenOption.APPEND)){
            bw.append(p.getPersonNr() + ", " + p.getName());
            bw.newLine();
            bw.append(DateGym.todayDate().toString());
            bw.newLine();
        }catch (IOException e){
            System.out.println("Invalid file path");
            e.printStackTrace();
        } catch (Exception e){
            System.out.println("No such file");
            e.printStackTrace();
        }
    }

    public String toString(){
        String temp = "";
        for (Person i : this.customerList){
            temp += i.getPersonNr() + ", " + i.getName() + ", " + i.getLastVisitedDate() + "\n";
        }
        return temp;
    }

    public ArrayList<Person> getCustomerList() {
        return customerList;
    }
}
