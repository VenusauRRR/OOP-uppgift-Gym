import javax.swing.*;
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

    public String askVariable(boolean isTest, String testData, String descriptionForUserData){
        return isTest ? testData : JOptionPane.showInputDialog(null,descriptionForUserData);
    }

    //check if the input person is a customer
    public Person isCustomer(String personNr, String name){
        for (Person i : customerList){
            if (i.getPersonNr().equals(personNr) && i.getName().equals(name)){
                return i;
            }
        }
        return null;
    }

    //read data from a file
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

    //write data to a file
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
