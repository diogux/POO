package aula02;
import utils.*;

public class Ex04 {
    public static void main(String[] agrs) {
        double invested,rate,finalValue;
        invested = UserInput.newDouble("Montante investido: ");
        rate = UserInput.newDouble("Taxa de juro mensal: ")/100;
        finalValue = invested * Math.pow((1+rate),3);
        System.out.printf("O valor total ao final de 3 meses é de: %.3f euros.",finalValue);

    }
}
