package utils;

import java.util.Scanner;

public class UserInput {
    private static Scanner sc = new Scanner(System.in);

    public static String newStringE(String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }

    public static double newDouble(String prompt) {
        System.out.print(prompt);
        while (!sc.hasNextDouble()) {
            System.out.println("Erro. É necessário colocar um número.");
            sc.nextLine();
        }
        double value = sc.nextDouble();
        sc.nextLine();
        return value;
    }

    public static String newString(String prompt) {
        System.out.print(prompt);
        while (!sc.hasNextLine()) {
            System.out.println("Erro. Digite novamente.");
            sc.nextLine();
        }
        String input = sc.nextLine();
        return input;
    }

    public static int newInt(String prompt) {
        System.out.print(prompt);
        while (!sc.hasNextInt()) {
            System.out.println("Erro. É necessário colocar um número inteiro.");
            sc.nextLine();
        }
        int value = sc.nextInt();
        sc.nextLine();
        return value;
    }

    public static Double newPositiveDouble(String prompt) {
        double value;
        do {
            value = newDouble(prompt);
            if (value <= 0) {
                System.out.println("Erro. O valor tem de ser positivo.");
            }
        } while (value <= 0);
        return value;
    }

    public static int newPositiveInt(String prompt) {
        int value;
        do {
            value = newInt(prompt);
            if (value <= 0) {
                System.out.println("Erro. O valor tem de ser positivo.");
            }
        } while (value <= 0);
        return value;
    }

    public static long newLong(String prompt) {
        System.out.print(prompt);
        while (!sc.hasNextLong()) {
            System.out.println("Erro. É necessário colocar um número inteiro.");
            sc.nextLine();
        }
        long value = sc.nextLong();
        sc.nextLine();
        return value;
    }

    public static long longInRange(String prompt, long min, long max) {
        long value;
        do {
            value = newLong(prompt);
            if (value < min || value > max) {
                System.out.printf("Erro. O número precisa de estar entre %d e %d.\n", min, max);
            }
        } while (value < min || value > max);
        return value;
    }

    public static int intInRange(String prompt, int min, int max) {
        int value;
        do {
            value = newInt(prompt);
            if (value < min || value > max) {
                System.out.printf("Erro. O número precisa de estar entre %d e %d.\n", min, max);
            }
        } while (value < min || value > max);
        return value;
    }

    public static double doubleInRange(String prompt, double min, double max) {
        double value;
        do {
            value = newDouble(prompt);
            if (value < min || value > max) {
                System.out.printf("Erro. O número precisa de estar entre %.1f e %.1f.\n", min, max);
            }
        } while (value < min || value > max);
        return value;
    }

    public static String newStringLetters(String prompt) {
        String input;
        do {
            input = newString(prompt);
            if (!input.matches("[a-zA-Z]+")) {
                System.out.println("Erro. Tem de ser composto apenas por letras.");
            }
            if (input.isEmpty())
                input = null;
        } while (!input.matches("[a-zA-Z]+"));
        return input;
    }

}
