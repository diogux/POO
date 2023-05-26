package teste_aula_morte_xadrez;
import utils.*;
import java.util.Random; 

public class TournamentManagerMain {
    public static void main(String[] args) {
        TournamentManager chessTournament = new TournamentManager();
        TournamentManager checkersTournament = new TournamentManager();
        int choice = 0;
        int nextId = 1;

        while (choice != 7) {
            System.out.println("TournamentManager Menu:");
            System.out.println("1. Add player");
            System.out.println("2. Remove player");
            System.out.println("3. Start game");           
            System.out.println("4. New round");
            System.out.println("5. Search player");
            System.out.println("6. Print tournament(s) info");
            System.out.println("7. Exit");
            
            choice = UserInput.newInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    String name = UserInput.newString("Name: ");
                    String team = UserInput.newString("Team: ");
                    Player newPlayer = new Player(name,nextId, team);
                    String game = UserInput.newString("Game: ");
                    while (!game.equals("chess") && !game.equals("checkers")) {
                        System.out.println("Jogo inválido!");
                        game = UserInput.newString("Digite o tipo de jogo: ");
                    }
                    if (game == "chess") {
                        int elo = new Random().nextInt(100) + 1;
                        newPlayer = new ChessPlayer(name, nextId, team, elo);
                        chessTournament.addPlayer(newPlayer);
                        nextId++;
                    }
                    else if (game == "checkers") {
                        int elo = new Random().nextInt(50) + 1;
                        newPlayer = new CheckersPlayer(name, nextId, team, elo);
                        checkersTournament.addPlayer(newPlayer);
                        nextId++;
                    }
                    break;
                case 2:
                     System.out.println("Escolha qual jogador remover:");
                        System.out.println("1. Chess");
                        System.out.println("2. Checkers");
                        int gameChoice = UserInput.intInRange("Enter your choice: ",1,2);
                        if (gameChoice == 1) {
                            System.out.println("Jogadores de Chess:");
                            chessTournament.printTournaments();
                            int id = UserInput.newInt("ID: ");
                            Player player = chessTournament.searchForPlayerId(id);
                            chessTournament.removePlayer(player);
                        }
                        else if (gameChoice == 2) {
                            System.out.println("Jogadores de Checkers:");
                            checkersTournament.printTournaments();
                            int id = UserInput.newInt("ID: ");
                            Player player = checkersTournament.searchForPlayerId(id);
                            checkersTournament.removePlayer(player);
                        }
                    break;
                case 3:
                    System.out.println("Começando o torneio:");


                case 4:
                    // nova ronda (se torneio(s) terminado(s), nao 
                    // deve fazer nada)  
                    break;                             
                case 5:
                    System.out.println("Escolha o jogo: ");
                    System.out.println("1. Chess");
                    System.out.println("2. Checkers");
                    int gameChoiceSearch = UserInput.intInRange("Escolha: ",1,2);
                    if (gameChoiceSearch == 1) {
                        int idChoice = UserInput.newInt("Escolha o ID: ");
                        Player player = chessTournament.searchForPlayerId(idChoice);
                        if (player != null) {
                            System.out.println(player);
                        }
                        else {
                            System.out.println("Jogador não encontrado!");
                        }
                    }
                    else if (gameChoiceSearch == 2) {
                        int idChoice = UserInput.newInt("Escolha o ID: ");
                        Player player = checkersTournament.searchForPlayerId(idChoice);
                        if (player != null) {
                            System.out.println(player);
                        }
                        else {
                            System.out.println("Jogador não encontrado!");
                        }
                    }
                    break;

                case 6:
                    System.out.println("Escolha o jogo: ");
                    System.out.println("1. Chess");
                    System.out.println("2. Checkers");
                    int gameChoicePrint = UserInput.intInRange("Escolha: ",1,2);
                    if (gameChoicePrint == 1) {
                        chessTournament.printTournaments();
                    }
                    else if (gameChoicePrint == 2) {
                        checkersTournament.printTournaments();
                    }
                    break;
                case 7:
                    System.out.println("Acabou o programa.");
                    return;
                default:
                    System.out.println("Escolha inválida!");
            }
        }

    }






        


}
