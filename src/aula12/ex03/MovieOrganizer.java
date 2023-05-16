package aula12.ex03;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;


public class MovieOrganizer {
    TreeMap<String, Movie> movies = new TreeMap<>();

    public void loadMovies(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        reader.readLine(); // skip header
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("\t");
            String title = parts[0];
            int runningTime = Integer.parseInt(parts[1]);
            double score = Double.parseDouble(parts[2]);
            String rating = parts[3];
            String genre = parts[4];
            movies.put(title, new Movie(title, runningTime, score, rating, genre));
        }
        reader.close();
    }




}
