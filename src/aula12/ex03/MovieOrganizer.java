package aula12.ex03;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.io.FileWriter;


public class MovieOrganizer {
    static Map<String, List<Movie>> movies = new TreeMap<>();

    public void loadMovies(String filename) throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        reader.readLine(); // skip header
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("\t");
            String title = parts[0];
            double score = Double.parseDouble(parts[1]);
            String rating = parts[2];
            String genre = parts[3];
            int runningTime = Integer.parseInt(parts[4]);
            Movie movie = new Movie(title, runningTime, score, rating, genre);
            if (!movies.containsKey(genre)) {
                movies.put(genre, new ArrayList<>());
            }
            movies.get(genre).add(movie);
        }
        reader.close();
    }

    public void listMoviesByScore() {
        List<Movie> MovieByScore = new ArrayList<>();
        for (String genre : movies.keySet()) {
            MovieByScore.addAll(movies.get(genre));
            MovieByScore.sort(Comparator.comparingDouble(Movie::getScore).reversed());
        }
        System.out.println(String.format("| %-30s | %-14s | %-10s | %-8s | %-10s |",
            "--Title--", "Running Time", "Score", "Rating", "Genre"));
        for (Movie movie : MovieByScore) {
            System.out.println(movie);
        }
    }

    public void listAllMovies(){
        for (String genre : movies.keySet()) {
            System.out.println(String.format("| %-30s | %-14s | %-10s | %-8s | %-10s |",
            "--Title--", "Running Time", "Score", "Rating", "Genre"));
            for (Movie movie : movies.get(genre)) {
                System.out.println(movie);
            }
        }
    }

    public void listMoviesByGenre(){
        for(String genre: movies.keySet()){
            System.out.printf("Genre: %s\n",genre);
            System.out.println(String.format("| %-30s | %-14s | %-10s | %-8s | %-10s |",
            "--Title--", "Running Time", "Score", "Rating", "Genre"));
            for(Movie movie:movies.get(genre)){
                System.out.println(movie);
            }
            System.out.println("----------------------------------------");
        }
    }

    public void listAllGenres(){
        for(String genre: movies.keySet()){
            System.out.printf("Genre: %s (Number of Movies: %d)\n",genre, movies.get(genre).size());
        }
    }

    public void listMoviesByRunningTime() {
        List<Movie> MovieByTime = new ArrayList<>();
        for (String genre : movies.keySet()) {
            MovieByTime.addAll(movies.get(genre));
            MovieByTime.sort(Comparator.comparingDouble(Movie::getRunningTime));
        }
        for (Movie movie : MovieByTime) {
            System.out.println(movie);
        }
    }

    public void listMoviesByScoreAndRunningTime() {
        List<Movie> moviesList = new ArrayList<>();
        for (String genre : movies.keySet()) {
            moviesList.addAll(movies.get(genre));
        }
        
        moviesList.sort(Comparator.comparingDouble(Movie::getScore).reversed()
                .thenComparingInt(Movie::getRunningTime));
        
        System.out.println(String.format("| %-30s | %-14s | %-10s | %-8s | %-10s |",
                "--Title--", "Running Time", "Score", "Rating", "Genre"));
        for (Movie movie : moviesList) {
            System.out.println(movie);
        }
    }
    
    public void writeSelection(String filename, String genre) throws IOException {
        try {
            genre = genre.toLowerCase();
            if (!movies.containsKey(genre)) {
                System.out.println("Genre not found.");
                return;
            }
            FileWriter writer = new FileWriter(filename);
            writer.write("Movies from the genre " + genre + " with score > 60: \n");
            writer.write(String.format("| %-30s | %-14s | %-10s | %-8s | %-10s |\n",
                    "--Title--", "Running Time", "Score", "Rating", "Genre"));
            for (Movie movie : movies.get(genre)) {
                if (movie.getScore() > 60) {
                    writer.write(movie.toString() + "\n");
                }
            }
            writer.close();
            System.out.println("Movie selection generated successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred while generating the movie list.");
            e.printStackTrace();
        }
    }
    

    




}
