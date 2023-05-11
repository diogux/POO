package aula04;
import utils.*;
import java.util.ArrayList;
import java.util.List;

public class Ex01 {
    public static void main (String[] args){
        
    System.out.println("------MENU------");
    System.out.println("Escolha uma opção.");
    System.out.println("1 - Círculo");
    System.out.println("2 - Triângulo");
    System.out.println("3 - Retângulo");
    System.out.println("4 - Mostrar figuras");
    System.out.println("5 - Comparar figuras");
    System.out.println("0 - Sair");
    System.out.println("----------------");
        
    List<Circle> circles = new ArrayList<>();
    List<Triangle> triangles = new ArrayList<>();
    List<Rectangle> rectangles = new ArrayList<>();

    boolean isValidChoice = false;

    while (!isValidChoice) {
        
    
        System.out.println("Escreva 10 para voltar a ver o menu.");
        int choice = UserInput.newInt("Opção: ");
    
    if (choice == 0) {
        System.out.println("Até à próxima!");
        isValidChoice = true;
    }
    else if (choice == 10){
        System.out.println("------MENU------");
        System.out.println("Escolha uma opção.");
        System.out.println("1 - Círculo");
        System.out.println("2 - Triângulo");
        System.out.println("3 - Retângulo");
        System.out.println("4 - Mostrar figuras");
        System.out.println("5 - Comparar figuras");
        System.out.println("0 - Sair");
        System.out.println("----------------");
    }

    else if (choice == 1){
        double radius = UserInput.newDouble("Raio: ");
        Circle c1 = new Circle(radius);
        circles.add(c1);
        System.out.println(c1.toString());
    }
    else if (choice == 2){
        double side1 = UserInput.newDouble("Lado 1: ");
        double side2 = UserInput.newDouble("Lado 2: ");
        double side3 = UserInput.newDouble("Lado 3: ");
        Triangle t1 = new Triangle(side1, side2, side3);
        triangles.add(t1);
        System.out.println(t1.toString());
    }
    else if (choice == 3){
        double lenght = UserInput.newDouble("Comprimento: ");
        double width = UserInput.newDouble("Largura: ");
        Rectangle r1 = new Rectangle(lenght, width);
        rectangles.add(r1);
        System.out.println(r1.toString());
    }
   else if (choice == 4) {
   System.out.println("---Círculos---");
    for (Circle c : circles) {
         System.out.println(c.toString());
    }
    System.out.println("---Triângulos---");
    for (Triangle t : triangles) {
         System.out.println(t.toString());
    }
    System.out.println("---Retângulos---");
    for (Rectangle r : rectangles) {
         System.out.println(r.toString());
    }

    }

    else if (choice == 5) {
        System.out.println("Escolha uma figura para comparar.");
        System.out.println("1 - Círculo");
        System.out.println("2 - Triângulo");
        System.out.println("3 - Retângulo");
        int choice2 = UserInput.newInt("Opção: ");

        switch (choice2) {
            case 1:
            for(int i = 0; i< circles.size(); i++){
                for(int j = i+1; j< circles.size(); j++){
                    if(i != j){
                        if(circles.get(i).equals(circles.get(j)) && i != j){
                            System.out.println(i + " & "+ j + " São círculos iguais\n");
                        }
                        else{
                            System.out.println(i + " & " + j +" São círculos diferentes\n");
                        }
                    }
                }   
            }
            case 2:
            for(int i = 0; i< triangles.size(); i++){
                for(int j = i+1; j< triangles.size(); j++){
                    if(i != j){
                        if(triangles.get(i).equals(triangles.get(j)) && i != j){
                            System.out.println(i + " & "+ j + " São triângulos iguais\n");
                        }
                        else{
                            System.out.println(i + " & " + j +" São triângulos diferentes\n");
                        }
                    }
                }
            }
            case 3:
            for(int i = 0; i< rectangles.size(); i++){
                for(int j = i+1; j< rectangles.size(); j++){
                    if(i != j){
                        if(rectangles.get(i).equals(rectangles.get(j)) && i != j){
                            System.out.println(i + " & "+ j + " São retângulos iguais\n");
                        }
                        else{
                            System.out.println(i + " & " + j +" São retângulos diferentes\n");
                        }
                    }
                }
            }
                break;}

        
    }
    
    else{
        System.out.println("Opção inválida.");
    }
    }

    }
}

