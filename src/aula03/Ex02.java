package aula03;
import utils.*;


public class Ex02 {
 
    public static void main(String[] args) {
        int invested;
        do {
            invested = UserInput.newPositiveInt("Insira o montante investido (positivo e múltiplo de 1000): ");
            if (invested % 1000 !=0){
                System.out.println("O valor não é múltiplo de 1000!");
            }
        }   while (invested % 1000 != 0);
        
        
        
        int rate = UserInput.intInRange("Taxa de juro (entre 0 e 5%): ", 0, 5);

        for (int i = 1; i <=12;i++) {
            System.out.printf("O valor final para o %2d mês é: %.2f\n" ,i,CompoundInterest.getCompoundInterest(invested, rate, i));
        }
 
    }
}
