package aula12.ex03;

public class Movie { 
    private String title;
    private int runningTime;
    private double score;
    private String rating;
    private String genre;

    public Movie(String title, int runningTime, double score, String rating, String genre) {
        this.title = title;
        this.runningTime = runningTime;
        this.score = score;
        this.rating = rating;
        this.genre = genre;
    }

    public String getTitle() {return title;}
    public int getRunningTime() {return runningTime;}
    public double getScore() {return score;}
    public String getRating() {return rating;}
    public String getGenre() {return genre;}

    @Override
    public String toString() {
        return String.format("Title: %s Running Time: %d Score: %.1f Rating: %s Genre: %s ", title, runningTime, score, rating, genre);
    }

}