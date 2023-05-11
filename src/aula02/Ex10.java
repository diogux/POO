package aula02;
import utils.*;
import java.util.ArrayList;
//Usei a os arrays do ArrayList pois achei que assim é mais intuitivo
public class Ex10 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        int firstNumber;
        int number;

        firstNumber = UserInput.newInt("Insira o primeiro número: ");
        numbers.add(firstNumber);

        do {
            number = UserInput.newInt("Insira outro número: ");
            numbers.add(number);
        } while (number != firstNumber);

        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
        }
        
        numbers.sort(null); //para conseguir o mínimo e o máximo
        double average = sum / numbers.size();

        System.out.println("Mínimo: " + firstNumber);
        System.out.println("Máximo: " + numbers.get(numbers.size() - 1));
        System.out.println("Soma de todos os números: " + sum );
        System.out.println("Foram inseridos " + numbers.size() + " números.");
        System.out.printf("Média: %.2f",average);


    }
}
