package aula02;
import utils.*;

public class Ex05 {
    public static void main(String[] args) {
        double v1,v2,t1,t2,d1,d2,vm;
        v1 = UserInput.newPositiveDouble("Primeira Velocidade (m/s): ");
        d1 = UserInput.newPositiveDouble("Primeira Distância (metros): ");
        v2 = UserInput.newPositiveDouble("Segunda Velocidade (m/s): ");
        d2 = UserInput.newPositiveDouble("Segunda Distância (metros): ");
        
        t1 = d1/v1;
        t2 = d2/v2;
        vm = (d1+d2) / (t1+t2);
        System.out.printf("A velocidade média entre A e B foi de %.2f m/s!",vm);

    }
    
}
