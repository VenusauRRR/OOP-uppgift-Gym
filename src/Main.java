import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Gym bestGymEver = new Gym();

        bestGymEver.readFrånFile("src/InputData");
        System.out.println(bestGymEver.toString());

        while (true){
            String personNr = JOptionPane.showInputDialog("Enter your personal number");
            String name = JOptionPane.showInputDialog("Enter your name");
            Person customer;
            if ((customer = bestGymEver.isCustomer(personNr,name)) != null){
                bestGymEver.writeToFile(new Person(customer.getPersonNr(), customer.getName(),DateGym.todayDate()),
                        "src/Out_To_Trainer");
                if (DateGym.isFeePaid1YrAgo(customer.getLastVisitedDate())){
                    bestGymEver.writeToFile(customer,"src/Out_Old_Customer");
                    JOptionPane.showMessageDialog(null,"This is our old customer");
                } else {
                    bestGymEver.writeToFile(customer,"src/Out_Current_Customer");
                    JOptionPane.showMessageDialog(null,"This is our current customer");
                }
            } else {
                bestGymEver.writeToFile(new Person(personNr,name,DateGym.todayDate()),"src/Out_Unknown_Customer");
                JOptionPane.showMessageDialog(null,"This is not our customer");
            }
        }


    }
}