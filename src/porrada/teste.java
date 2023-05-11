package porrada;
import java.util.Scanner;
import java.util.Random;

public class teste {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Fighter[] fighters = new Fighter[10];
        int fightersCount = 0;

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Generate random fighters");
            System.out.println("2. Start a fight between two specified fighters");
            System.out.println("3. Start a fight between two random fighters");
            System.out.println("4. Quit");

            int option = scanner.nextInt();
            if (option == 1) {
                fighters[fightersCount++] = generateRandomFighter();
                fighters[fightersCount++] = generateRandomFighter();
                System.out.println("Fighters generated!");
                printFighters(fighters, fightersCount);
            } else if (option == 2) {
                System.out.println("Choose the first fighter:");
                Fighter fighter1 = selectFighter(fighters, fightersCount, scanner);
                System.out.println("Choose the second fighter:");
                Fighter fighter2 = selectFighter(fighters, fightersCount, scanner);
                fight(fighter1, fighter2);
            } else if (option == 3) {
                Fighter fighter1 = fighters[new Random().nextInt(fightersCount)];
                Fighter fighter2 = fighters[new Random().nextInt(fightersCount)];
                fight(fighter1, fighter2);
            } else if (option == 4) {
                System.out.println("Quitting game...");
                break;
            } else {
                System.out.println("Invalid option!");
            }
        }
    
        scanner.close();
    }
    
    public static Fighter generateRandomFighter() {
        Random random = new Random();
        String name = "Fighter" + (random.nextInt(10) + 1);
        int type = random.nextInt(2);
        if (type == 0) {
            int range = random.nextInt(10) + 1;
            return new Boxer(name, range);
        } else {
            int speed = random.nextInt(10) + 1;
            return new Wrestler(name, speed);
        }
    }
    
    public static void printFighters(Fighter[] fighters, int fightersCount) {
        System.out.println("Fighters:");
        for (int i = 0; i < fightersCount; i++) {
            System.out.println(i + 1 + ". " + fighters[i]);
        }
    }
    
    public static Fighter selectFighter(Fighter[] fighters, int fightersCount, Scanner scanner) {
        printFighters(fighters, fightersCount);
        int index = scanner.nextInt() - 1;
        while (index < 0 || index >= fightersCount) {
            System.out.println("Invalid fighter index, please try again:");
            printFighters(fighters, fightersCount);
            index = scanner.nextInt() - 1;
        }
        return fighters[index];
    }
    
    public static void fight(Fighter fighter1, Fighter fighter2) {
        System.out.println("Fight starting between " + fighter1 + " and " + fighter2 + "...");
        while (fighter1.isAlive() && fighter2.isAlive()) {
            fighter1.attack(fighter2);
            if (fighter2.isAlive()) {
                fighter2.attack(fighter1);
            }
        }
        if (fighter1.isAlive()) {
            fighter1.addWin();
            fighter2.addLoss();
            System.out.println(fighter1.getName() + " wins!");
        } else {
            fighter2.addWin();
            fighter1.addLoss();
            System.out.println(fighter2.getName() + " wins!");
        }
        System.out.println(fighter1.getName() + " (Wins: " + fighter1.getWins() + ", Losses: " + fighter1.getLosses() + ")");
        System.out.println(fighter2.getName() + " (Wins: " + fighter2.getWins() + ", Losses: " + fighter2.getLosses() + ")");
    }
}
