package aula12;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class TotalOfDifferentWordsEx01 {
    public static void main(String[] args) throws IOException {
    Scanner input = new Scanner(new FileReader("movies.txt"));
    ArrayList<String> AllWords = new ArrayList<>();
    HashSet<String> AllWordsSet = new HashSet<>();
    input.useDelimiter("[\\s\\t\\n\\p{Punct}&&[^']]+");
    while (input.hasNext()) {
        String word = input.next().toLowerCase();
        AllWords.add(word);
        AllWordsSet.add(word);
    }

    System.out.println("---->TODAS AS PALAVRAS");
    System.out.println(AllWords.size()); 
    System.out.println("---->TODAS AS PALAVRAS SEM REPETIÇÕES");
    System.out.println(AllWordsSet.size());
}
    }


