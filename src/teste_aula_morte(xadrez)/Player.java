package testeaula7;

public class Player {
    private String name;
    private int ID;
    private double score;
    private String team;
    
    public Player(String name, int ID, String team) {
        this.name = name;
        this.ID = ID;
        this.score = 0;
        this.team = team;
        

    }
    
    public String getName() {
        return name;
    }
    
    public String getTeam() {
        return team;
    }

    public int getID() {
        return ID;
    }
    
    public double getScore() {
        return score;
    }
    
    public void addWin() {
        this.score ++;
    }

    public void addDraw() {
        this.score += 0.5;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    public String toString() {
        return "Name: " + name + " ID: " + ID + " Score: " + score;
    }
}
