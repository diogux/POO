package testeaula7;

public class CheckersPlayer extends Player{
    private int eloCheckers;

    public CheckersPlayer(String name, int ID, String team, int eloCheckers) {
        super(name, ID, team);
        this.eloCheckers = eloCheckers;
    }

    public int getEloCheckers() {
        return eloCheckers;
    }

    public String toString() {
        return "ChessPlayer " + super.toString() + " ELO: " + eloCheckers;
    }
}
