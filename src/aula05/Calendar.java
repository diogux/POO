package aula05;

public class Calendar {
    private int firstWeekDayOfYear;
    private int year;
    private String[] monthName = {"January","February","March","April","May","June","July","August","September","October","November","December"};
    private int[][] events = new int[13][32];

    
    public Calendar (int firstWeekDayOfYear, int year){
        this.firstWeekDayOfYear = firstWeekDayOfYear;
        this.year = year;
    } 

    public int getFirstWeekDayOfYear() {
        return firstWeekDayOfYear;
    }

    public void addEvent(int month, int day){
        if (month > 0 && month <= 12 && day > 0 && day <= DateYMD.monthDays(month, year)){
        events[month-1][day-1]++;}
        else {
            System.out.println("Invalid date");
        }
    }

    public void removeEvent(int month, int day){
        if (month > 0 && month <= 12 && day > 0 && day <= DateYMD.monthDays(month, year)){
        if (events[month-1][day-1] > 0) {
        events[month-1][day-1]--;
        }
        else {
            System.out.println("No events to remove.");
        }}
        else {
            System.out.println("Invalid date");
        }
}

    public int getYear() {
        return year;
    }

    public int getFirstWeekDayOfMonth(int month){
        int firstWeekDayOfMonth = 0;
        int days = 0;
        for (int i = 1; i < month; i++){
            days += DateYMD.monthDays(i, year);
        }
        firstWeekDayOfMonth = (firstWeekDayOfYear + days) % 7;
        return firstWeekDayOfMonth;
    }

    public void printMonth(int month) {
        int firstWeekDayOfMonth = getFirstWeekDayOfMonth(month);
        int monthDays = DateYMD.monthDays(month, year);
        System.out.println(monthName[month-1] + " " + year);
        System.out.println(" Su  Mo  Tu  We  Th  Fr  Sa");
        //print dos espaços vazios
        for (int i = 0; i < firstWeekDayOfMonth; i++){
            System.out.print("    ");
        }
        //print dos dias
        for (int i = 1; i <= monthDays; i++){
            if (events[month-1][i-1] > 0) {
                System.out.printf("*%2d ", i);
                continue;
            }
            else {
                System.out.printf(" %2d ", i);
            }

            // quando for sábado, pula uma linha
            if ((i + firstWeekDayOfMonth) % 7 == 0){
                System.out.println();
            }
        }
        System.out.println();

    }

    public void printCalendar() {
        for (int i = 1;i <=12; i++) {
            printMonth(i);
            System.out.println();
        }
    }

    
    
    




}
