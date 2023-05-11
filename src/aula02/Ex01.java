package aula02;
import utils.*;

public class Ex01 {
    public static void main(String[] agrs) {
        double km,miles;
        km = UserInput.newDouble("Insira um número de Km: ");
        miles = km/1.609;
        System.out.printf("O número  de Km convertido para milhas é de %.2f!",miles);
    }
}
