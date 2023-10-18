import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Gym bestGymEver = new Gym();
        bestGymEver.readFrånFile("src/InputData");
        Person customer;
        String personNr;
        String name;
        boolean isTest = false;

        while (true){
            personNr = bestGymEver.askVariable(isTest, null, "Enter your person number");
            name = bestGymEver.askVariable(isTest, null, "Enter your name");

            //exit the program if no input is received
            if (personNr == null && name == null){
                System.exit(0);
            }

            //check if the input person is a customer
            if ((customer = bestGymEver.isCustomer(personNr,name)) != null){
                if (DateGym.isFeePaid1YrAgo(customer.getLastVisitedDate())){
                    //check if this is an old customer and write data to relevant file
                    bestGymEver.writeToFile(customer,"src/Out_Old_Customer");
                    JOptionPane.showMessageDialog(null,
                            "This is our old customer. Fee is paid more than 1 yr ago");
                } else {
                    //check if this is a current customer and write file to receoption and personal trainer
                    bestGymEver.writeToFile(customer,"src/Out_Current_Customer");
                    bestGymEver.writeToFile(new Person(customer.getPersonNr(), customer.getName(),DateGym.todayDate()),
                            "src/Out_To_Trainer");
                    JOptionPane.showMessageDialog(null,"This is our current customer");
                }
            } else {
                //the input person is not a customer and write data to relevant file
                bestGymEver.writeToFile(new Person(personNr,name,DateGym.todayDate()),"src/Out_Unknown_Customer");
                JOptionPane.showMessageDialog(null,"This is not our customer");
            }

            //to end the program under test mode
            if (isTest){
                break;
            }
        }


    }
}