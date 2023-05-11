package aula02;
import utils.*;

public class Ex09 {
    public static void main(String[] args) {
        int n = UserInput.newInt("Escreve um número: ");
        
        for (int i = n; i >= 0;i-- ) {
            if (i % 10 != 0) {
            System.out.print(i+",");
        } 
        else if (i == 0) {
            System.out.print("0");
        }
        else {
            System.out.println(i+",");
        }
        }
    }
    
}
