package testeaula7;
import java.util.ArrayList;

public class TournamentManager {
    public static ArrayList<Player> players = new ArrayList<Player>();


    public void addPlayer(Player player){
        players.add(player);
    }

    public void removePlayer(Player player){
        players.remove(player);
    }

    public Player searchForPlayerName(String nome){
        for (Player player : players) {
            if (player.getName().startsWith(nome)) {
                return player;
            }
        }
        return null;
    }

    public Player searchForPlayerId(int ID){
        for (Player player : players) {
            if (player.getID() == ID) {
                return player;
            }
        }
        return null;
    }

    public void printTournaments(){
        for (Player player : players) {
            System.out.println(player);
        }
    }

    public static boolean nextRound(){
        return false;
    }



    // public void addPlayer(Player player);
    // public void removePlayer(Player player);
    // public Player searchForPlayer(String nome);
    // public Player searchForPlayer(int ID);
    // public void printTournaments();
    // public boolean nextRound(); % returns false if tournament ended
}
