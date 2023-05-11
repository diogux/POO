package aula09.ex02;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.TreeSet;

public class CollectionTester {
    public static void main(String[] args) {
        int[] DIM = { 1000, 3000, 5000, 7000, 9000, 10000 };
        Collection<Collection<Integer>> allCollections = new ArrayList<>();
        allCollections.add(new ArrayList<>());
        allCollections.add(new LinkedList<>());
        allCollections.add(new HashSet<>());
        allCollections.add(new TreeSet<>());
        ArrayList<Double> Add = new ArrayList<>();
        ArrayList<Double> Remove = new ArrayList<>();
        ArrayList<Double> Search = new ArrayList<>();

        for (int i = 0; i < DIM.length; i++) {
            for (Collection<Integer> c : allCollections) {
                Double[] results = checkPerformance(c, DIM[i]);
                Add.add(results[0]);
                Search.add(results[1]);
                Remove.add(results[2]);
            }
        }

        printResults(DIM, allCollections, Add, Search, Remove);

    }

    private static Double[] checkPerformance(Collection<Integer> col, int DIM) {
        double start, stop, delta;
        double add = 0, remove = 0, search = 0;
        // Add
        start = System.nanoTime(); // clock snapshot before
        for (int i = 0; i < DIM; i++)
            col.add(i);
        stop = System.nanoTime(); // clock snapshot after
        delta = (stop - start) / 1e6; // convert to milliseconds

        add = delta;
        // Search
        start = System.nanoTime(); // clock snapshot before
        for (int i = 0; i < DIM; i++) {
            int n = (int) (Math.random() * DIM);
            if (!col.contains(n))
                System.out.println("Not found???" + n);
        }
        stop = System.nanoTime(); // clock snapshot after
        delta = (stop - start) / 1e6; // convert nanoseconds to milliseconds
        search = delta;
        // Remove
        start = System.nanoTime(); // clock snapshot before
        Iterator<Integer> iterator = col.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        stop = System.nanoTime(); // clock snapshot after
        delta = (stop - start) / 1e6; // convert nanoseconds to milliseconds
        remove = delta;

        start = System.nanoTime(); // clock snapshot before

        return new Double[] { add, search, remove };
    }

    public static void printResults(int[] DIMS,
            Collection<Collection<Integer>> allCollections, ArrayList<Double> Add, ArrayList<Double> Search,
            ArrayList<Double> Remove) {
        System.out.println("_".repeat(75));
        System.out.printf("%-15s", "Collection");
        for (int d : DIMS) {
            System.out.printf("%10d", d);
        }
        System.out.println();
        for (Collection<Integer> c : allCollections) {
            System.out.println("--" + c.getClass().getSimpleName() + "--");
            System.out.printf("%-15s", "Add:");
            for (int i = 0; i < DIMS.length; i++) {
                System.out.printf("%10.1f", Add.get(i));
            }
            System.out.println();
            System.out.printf("%-15s", "Search:");
            for (int i = 0; i < DIMS.length; i++) {
                System.out.printf("%10.1f", Search.get(i));
            }
            System.out.println();
            System.out.printf("%-15s", "Remove:");
            for (int i = 0; i < DIMS.length; i++) {
                System.out.printf("%10.1f", Remove.get(i));
            }
            System.out.println("\n");
        }
        System.out.println("_".repeat(75));
    }

}
