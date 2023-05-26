package teste_aula_morte_xadrez;

public class ChessPlayer extends Player {
    private int elo;

    public ChessPlayer(String name, int ID, String team, int elo) {
        super(name, ID, team);
        this.elo = elo;
    }

    public int getElo() {
        return elo;
    }

    public String toString() {
        return "ChessPlayer " + super.toString() + " ELO: " + elo;
    }

    


}
