package aula05;
import utils.*;

public class Calendar_Test {
    public static void main(String[] args){
        Calendar calendar = new Calendar(1, 2020);
        
        boolean validChoice = false;

        while(!validChoice) {

            System.out.println("Calendar operations: ");
            System.out.println("1 - create new calendar");
            System.out.println("2 - print month");
            System.out.println("3 - print year");
            System.out.println("4 - add event");
            System.out.println("5 - remove event");
            System.out.println("0 - exit");


            int choice = UserInput.newInt("Choose an option: ");

            if (choice == 1){
                System.out.println("Insert calendar");
                int firstWeekDayOfYear = UserInput.newInt("First week day of year (1-Sunday, 2-Monday...) : ");
                if (firstWeekDayOfYear <= 0 || firstWeekDayOfYear > 7){
                    System.out.println("Invalid first week day of year");
                    continue;
                }
                //no ínicio fiz com 1 = segunda entao fiz esta alteração
                else if  (firstWeekDayOfYear == 1){
                    firstWeekDayOfYear = 7;
                }
                else {
                    firstWeekDayOfYear--;
                }
                int year = UserInput.newInt("Year: ");
                if (year <= 0 || year > 9999){
                    System.out.println("Invalid year");
                    continue;
                }
                calendar = new Calendar(firstWeekDayOfYear, year);
            }
            else if (choice == 2){
                int month = UserInput.newInt("Month: ");
                calendar.printMonth(month);
            }
            else if (choice == 3){
                calendar.printCalendar();
            }
            else if (choice == 4) {
                System.out.println("Insert event");
                int month = UserInput.newInt("Month: ");
                int day = UserInput.newInt("Day: ");
                calendar.addEvent(month, day);
            }
            else if (choice == 5) {
                System.out.println("Remove event");
                int month = UserInput.newInt("Month: ");
                int day = UserInput.newInt("Day: ");
                calendar.removeEvent(month, day);
            }
            else if (choice == 0){
                System.out.println("End of program...");
                validChoice = true;
            }
            else {
                System.out.println("Invalid option");
            }


        }

    }
}
