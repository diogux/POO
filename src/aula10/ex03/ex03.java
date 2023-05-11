package aula10.ex03;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import utils.*;

public class ex03 {

    public static void main(String[] args) {
        String phrase = UserInput.newString("Write a phrase: ");
        HashMap<Character, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < phrase.length(); i++) {
            char c = phrase.charAt(i);
            List<Integer> indexList = map.getOrDefault(c, new ArrayList<>());
            indexList.add(i);
            map.put(c, indexList);
        }

        System.out.println(map);
    }
}
