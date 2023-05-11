package aula03;
import utils.*;

public class Ex05 {
    
    public static void main(String[] args) {
        int month = 0;
        int year = 0;
        boolean validDate = false;
        while (!validDate) {
            String date = UserInput.newString("Insira da data com o formato mm/yyyy: ");
            String[] dateParts = date.split("/");
            //Verifica se contém o formato certo
            if (dateParts.length != 2) {
                System.out.println("Erro, por favor use o formato mm/yyyy.");
                continue;
            }
            try { // verifica se ambas as partes (mês e ano) são números
                month = Integer.parseInt(dateParts[0]);
                year = Integer.parseInt(dateParts[1]);
                //valida o ano e o mês
                if (month < 1 || month > 12 || year < 0 || year > 9999) {
                    System.out.println("Erro, essa data não é válida.");
                    continue;
                }
                validDate = true; // para fechar o loop
            } catch (NumberFormatException e) {
                System.out.println("Erro, o mês e o ano ambos necessitam de ser números inteiros.");
            }
        }
        
        //Dia da semana do 1º dia
        int firstDayOfMonth = UserInput.intInRange("Insira o primeiro dia do mês (1=Segunda, 2=Terça, ...): ",1,7);
        
        
        

        printCalendar(firstDayOfMonth, month, year );
    }
    
    
    
    private static int calculateNumDaysInMonth(int month, int year) {
        if (month == 2) {
            if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
                return 29; // Ano bissexto
            } else {
                return 28;
            }
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else {
            return 31;
        }
    }
    
    
    private static void printCalendar(int firstDayOfMonth, int month,int year) {
        //Número de dias
        int numDaysInMonth = calculateNumDaysInMonth(month, year);

        //Nome do Mês
        String[] months = {"January","February","March","April","May","June","July","September","October","November","December"};
        String monthName = months[month-1];
        
        //Print do calendário
        System.out.printf("%11s %d\n",monthName, year);
        System.out.println(" Su Mo Tu We Th Fr Sa");
        int day = 0;

        //Print dos espaços vazios
        for (int i = 1; i < firstDayOfMonth; i++) {
            System.out.print("   ");
        }
        //Print dos dias
        for (int i = firstDayOfMonth; i <= 7; i++) {
            
            System.out.printf("%2d ", day+1);
            day++;
            
        }
        System.out.println();
        //Print dos dias restantes
        while (day <= numDaysInMonth) {
            for (int i = 1; i <= 7 && day <= numDaysInMonth; i++) {
                System.out.printf("%2d ", day);
                day++;
            }
            System.out.println();
        }

       
       
    }
}