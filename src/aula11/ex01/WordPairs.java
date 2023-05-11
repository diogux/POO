package aula11.ex01;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

//Nota: O código seguinte não guarda pares caso a próxima palavra tenha menos que 3 letras.
//Por exemplo, na frase "voltou a casa", o par "voltou casa" não será guardado, pois "a" tem menos que 3 letras.
//O professor disse que aceita de ambas formas, a guardar ou a não guardar, por isso deixei assim.


public class WordPairs {

    public static void main(String[] args) {
        try {
            Map<String, Map<String, Integer>> wordPairs = countWordPairs("major.txt");

            for (Map.Entry<String, Map<String, Integer>> entry : wordPairs.entrySet()) {
                String word = entry.getKey();
                Map<String, Integer> pairs = entry.getValue();
                System.out.println(word + "=" + pairs);
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    public static Map<String, Map<String, Integer>> countWordPairs(String fileName) throws IOException {
        Map<String, Map<String, Integer>> wordPairs = new TreeMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            String previousWord = null;

            while ((line = br.readLine()) != null) {
                String[] words = line.split("[\\s\\t\\n.,:'‘’;?!-*{}=+&/\\(\\)\\[\\]”“\"\\']+");

                for (String word : words) {
                    if (word.length() >= 3) {
                        if (previousWord != null) {
                            String pair = previousWord.toLowerCase();
                            Map<String, Integer> pairs = wordPairs.getOrDefault(pair, new TreeMap<>());
                            pairs.put(word.toLowerCase(), pairs.getOrDefault(word.toLowerCase(), 0) + 1);
                            wordPairs.put(pair, pairs);
                        }
                        previousWord = word;
                    } else {
                        previousWord = null;
                    }
                }
            }
        }


        return wordPairs;
    }
}
