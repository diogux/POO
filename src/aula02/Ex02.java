package aula02;
import utils.*;

public class Ex02 {
    public static void main(String[] args) {
        double celsius,fahrenheit;
        celsius = UserInput.newDouble("Insira a temperatura em ºC: ");
        fahrenheit = (1.8 * celsius) + 32;
        System.out.println("A temperatura convertida é de "+ fahrenheit + "ºF");
    }
}
