import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Gym bestGymEver = new Gym();
        bestGymEver.readFrånFile("src/InputData");

        String outputPath_current_customer = "src/Out_Current_Customer";
        String outputPath_old_customer = "src/Out_Old_Customer";
        String outputPath_unknown_person = "src/Out_Unknown_Customer";
        String outputPath_trainer = "src/Out_To_Trainer";

        Person customer;
        String personNr;
        String name;
        boolean isTest = false;

        while (true){

            //TDD with datainput
            personNr = bestGymEver.askVariable(isTest, "2310181234", "Enter your person number");
            name = bestGymEver.askVariable(isTest, "Venus", "Enter your name");

            //exit the program if no input is received
            if (personNr == null && name == null){
                System.exit(0);
            }

            //send error message if input is empty
            if (personNr == null || personNr.isEmpty() || name == null || name.isEmpty()){
                JOptionPane.showMessageDialog(null,"Person number or name cannot be empty");
                continue;
            }

            //send error message if person number is invalid
            try {
                Person.isPersonNrValid(personNr);
            } catch (Exception e){
                JOptionPane.showMessageDialog(null,e.getMessage());
                continue;
            }

            //check if the input person is a customer
            if ((customer = bestGymEver.isCustomer(personNr,name)) != null){
                if (DateGym.isFeePaid1YrAgo(customer.getLastVisitedDate())){
                    //check if this is an old customer and write data to relevant file
                    bestGymEver.writeToFile(customer,outputPath_old_customer);
                    JOptionPane.showMessageDialog(null,
                            "This is our old customer. Fee is paid more than 1 yr ago");
                } else {
                    //check if this is a current customer and write file to receoption and personal trainer
                    bestGymEver.writeToFile(customer,outputPath_current_customer);
                    bestGymEver.writeToFile(new Person(customer.getPersonNr(), customer.getName(),DateGym.todayDate()),
                            outputPath_trainer);
                    JOptionPane.showMessageDialog(null,"This is our current customer");
                }
            } else {
                //the input person is not a customer and write data to relevant file
                bestGymEver.writeToFile(new Person(personNr,name,DateGym.todayDate()),outputPath_unknown_person);
                JOptionPane.showMessageDialog(null,"This is not our customer");
            }

            //to end the program under test mode
            if (isTest){
                break;
            }
        }//while loop
    }//main
}//class