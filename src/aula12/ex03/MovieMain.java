package aula12.ex03;
import java.io.IOException;
import utils.*;

public class MovieMain {
    public static void main (String[] args) throws IOException {
        MovieOrganizer Mo = new MovieOrganizer();
        //Loading movies from file
        Mo.loadMovies("movies.txt");

        int option = -1;

        while(option != 0){
            System.out.println("----- Menu -----");
            System.out.println("1 - List all movies");
            System.out.println("2 - List movies by score");
            System.out.println("3 - List movies by genre");
            System.out.println("4 - List all genres");
            System.out.println("5 - Write movies with score above 60 to file (by genre)");
            System.out.println("0 - Exit");
            option = UserInput.intInRange("Option: ", 0,  5);
            System.out.println();
        
            switch (option) {
                case 1:
                    Mo.listAllMovies();
                    break;
                case 2:
                    Mo.listMoviesByScore();
                    break;
                case 3:
                    Mo.listMoviesByGenre();
                    break;
                case 4:
                    Mo.listAllGenres();
                    break;
                case 5:
                    System.out.println("Genres available: ");
                    Mo.listAllGenres();
                    String genre = UserInput.newString("Enter genre to write the file: ");
                    Mo.writeSelection("myselection.txt", genre);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            
                }
                System.out.println();
        }
    }
}
