package aula12;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;



//Nota: o código não considera uma palavra se conter números ou caracteres especiais 
//Por exemplo, "vs." tem 3 caracteres, mas não é considerada uma palavra
public class WordsByFirstLetterEx02 {
    public static void main(String[] args) throws IOException{
        writeFile(getWordsMap(getWordsList("A_cidade_e_as_serras.txt")));
    }   

    public static ArrayList<String> getWordsList(String filename) throws IOException {
        ArrayList<String> AllWords = new ArrayList<>();
        Scanner input = new Scanner(new FileReader(filename));
        while (input.hasNext()) {
            String word = input.next().toLowerCase();
            if (word.length() >= 3 && !word.matches(".*\\d.*") && !word.matches(".*\\W.*") && !word.matches(".*\\_.*")){
            AllWords.add(word);
        }
    }
        input.close();
        return AllWords;
    }

    public static TreeMap<Character, TreeMap<String, Integer>> getWordsMap(ArrayList<String> AllWords) {
        TreeMap<Character, TreeMap<String, Integer>> AllWordsMap = new TreeMap<>();
        for (String word : AllWords) {
            char firstLetter = word.charAt(0);
            if (!AllWordsMap.containsKey(firstLetter)) {
                AllWordsMap.put(firstLetter, new TreeMap<>());
            }
            TreeMap<String, Integer> wordsMap = AllWordsMap.get(firstLetter);
            wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
        }
        return AllWordsMap;
    }

    public static void writeFile(TreeMap<Character, TreeMap<String, Integer>> AllWordsMap){
        try {
        FileWriter fw = new FileWriter("word_counter_aula12.txt",StandardCharsets.UTF_8);
        PrintWriter pw = new PrintWriter(fw);
        pw.write("Result: (First Letter: word, number of occurrences; etc)\n");
        for (Character firstLetter : AllWordsMap.keySet()) {
            pw.write(firstLetter + ": ");
            TreeMap<String, Integer> wordsMap = AllWordsMap.get(firstLetter);
            for (String word : wordsMap.keySet()) {
                pw.write(word + ", " + wordsMap.get(word) + "; ");
                
            }
            pw.write("\n");
        }


        pw.close();
    } catch (IOException e) {
        e.printStackTrace();
    }

}
}
