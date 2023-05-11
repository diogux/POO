package aula05;

import utils.UserInput;

public class Date_Test {
    public static void main(String[] args){

        DateYMD date = new DateYMD(1,1,1);
        boolean validChoice = false;

        while(!validChoice) {
            System.out.println("Date operations: ");
            System.out.println("1 - create new date");
            System.out.println("2 - show current date");
            System.out.println("3 - increment date");
            System.out.println("4 - decrement date");
            System.out.println("0 - exit");
            
            int choice = UserInput.newInt("Choose an option: ");

            if (choice == 1){
                System.out.println("Insert date");
                int day = UserInput.newInt("Day: ");
                int month = UserInput.newInt("Month: ");
                int year = UserInput.newInt("Year: ");
                date = new DateYMD(day,month,year);
            }
            else if (choice == 2){
                System.out.println("Current date: " + date.toString());
            }
            else if (choice == 3){
                date.increment();
                System.out.println("Incremented date: " + date.toString());
            }
            else if (choice == 4){
                date.decrement();
                System.out.println("Decremented date: " + date.toString());

            }
            else if (choice == 0){
                System.out.println("Bye!");
                validChoice = true;
            }







        }

    }

}
