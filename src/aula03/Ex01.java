package aula03;
import utils.*;

public class Ex01 {
    public static void main(String[] args){

        int n = UserInput.newPositiveInt("Escreva um número inteiro: ");

        int sum = 0;
        for (int i = 2; i <= n; i++){
            if (PrimeNumbers.isPrime(i)) {
                sum += i;
            }
        }
        System.out.print("A soma dos números primos até esse número é "+ sum);
    }


}
