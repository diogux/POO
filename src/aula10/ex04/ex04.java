package aula10.ex04;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.HashSet;

public class ex04 {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new FileReader("words.txt"));
        HashSet<String> wordsWithMoreThan2Char = new HashSet<>();
        HashSet<String> wordsThatEndWithS = new HashSet<>();
        while (input.hasNext()) {
            String word = input.next();
            if (word.length() > 2) {
                wordsWithMoreThan2Char.add(word);
            }
            if (word.charAt(word.length() - 1) == 's') {
                wordsThatEndWithS.add(word);
            }
        }
        System.out.println("---->PALAVRAS QUE ACABAM EM S");
        System.out.println(wordsThatEndWithS); // Print com todas as palavras que
        // terminam em s

        System.out.println("---->PALAVRAS COM MAIS DE 2 CARACTERES");
        System.out.println(wordsWithMoreThan2Char); // Print com todas as palavras

        wordsWithMoreThan2Char.removeIf(word -> !word.matches("[a-zA-Z0-9]+"));
        System.out.println("---->PALAVRAS COM MAIS DE 2 CARACTERES SEM CARACTERES ESPECIAIS");
        System.out.println(wordsWithMoreThan2Char); // Print com todas as palavras sem
        // caracteres especiais
    }

}
