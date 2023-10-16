import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Gym bestGymEver = new Gym();
        bestGymEver.readFrånFile("src/InputData");
        Person customer;

        while (true){
            String personNr = JOptionPane.showInputDialog("Enter your personal number");
            String name = JOptionPane.showInputDialog("Enter your name");

            //exit the program if no input is received
            if (personNr == null || name == null){
                System.exit(0);
            }

            //check if the input person is a customer
            if ((customer = bestGymEver.isCustomer(personNr,name)) != null){
                bestGymEver.writeToFile(new Person(customer.getPersonNr(), customer.getName(),DateGym.todayDate()),
                        "src/Out_To_Trainer");

                //check if this is a current customer or an old customer
                if (DateGym.isFeePaid1YrAgo(customer.getLastVisitedDate())){
                    bestGymEver.writeToFile(customer,"src/Out_Old_Customer");
                    JOptionPane.showMessageDialog(null,"This is our old customer");
                } else {
                    bestGymEver.writeToFile(customer,"src/Out_Current_Customer");
                    JOptionPane.showMessageDialog(null,"This is our current customer");
                }
            } else {

                //the input person is not a customer
                bestGymEver.writeToFile(new Person(personNr,name,DateGym.todayDate()),"src/Out_Unknown_Customer");
                JOptionPane.showMessageDialog(null,"This is not our customer");
            }
        }


    }
}