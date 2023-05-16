package aula12;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Scanner;

public class TotalOfDifferentWordsEx01 {
    public static void main(String[] args) throws IOException {
    Scanner input = new Scanner(new FileReader("A_cidade_e_as_serras.txt",StandardCharsets.UTF_8));
    ArrayList<String> AllWords = new ArrayList<>();
    HashSet<String> AllWordsSet = new HashSet<>();
    input.useDelimiter("[\\s\\t\\n\\p{Punct}[«»0-9]&&[^'-]]+");
    while (input.hasNext()) {
        String word = input.next().toLowerCase();
        
        if(word.contains("--")) {
            //removes "--" from the word
            word = word.replace("--", ""); 
        }
        
        if (!word.matches(".*\\d.*") && !word.matches(".*\\_.*") && !word.equals("-")){
        AllWords.add(word);
        AllWordsSet.add(word);
    }}

    input.close();
    System.out.println("---->TODAS AS PALAVRAS");
    System.out.println(AllWords.size()); 
    System.out.println("---->TODAS AS PALAVRAS SEM REPETIÇÕES");
    System.out.println(AllWordsSet.size());

}
    }


