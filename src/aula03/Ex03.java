package aula03;
import utils.*;
import java.util.Random;
import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int guess;
            int contagem = 1;
            Random randnum = new Random();
            int randomNumber = randnum.nextInt(101);
            System.out.println(randomNumber);
            guess = UserInput.intInRange("Advinha um número inteiro entre 0 e 100: ", 0, 100);
            while (guess != randomNumber){
                if (guess > randomNumber){guess = UserInput.intInRange("Tenta um número menor. ", 0, 100);contagem++;}
                else if (guess < randomNumber){guess = UserInput.intInRange("Tenta um número maior. ", 0, 100);contagem++;}
            }
            System.out.printf("Boa! Acertaste com apenas %d tentativas.\n" ,contagem);
            System.out.print("Se quiseres jogar outra vez escreve (S)im: ");
            String answer = sc.next().toUpperCase();
            if (answer.equals("S") || answer.equals("SIM")){
                continue;}
            else {
                System.out.println("Acabou o jogo.");
                break;}
        }
        sc.close();
}
}
