package aula02;
import utils.*;

public class Ex07 {
    public static void main(String[] agrs) {
        double x1,y1,x2,y2,dist;
        x1 = UserInput.newDouble("Coordenada x do primeiro ponto: ");
        y1 = UserInput.newDouble("Coordenada y do primeiro ponto: ");
        x2 = UserInput.newDouble("Coordenada x do segundo ponto: ");
        y2 = UserInput.newDouble("Coordenada y do segundo ponto: ");
        dist = Math.sqrt( Math.pow(x2-x1,2) + Math.pow(y2-y1,2) );
        System.out.printf("A distância entre o primeiro ponto e o segundo é de %.2f unidades de comprimento.",dist);
    }

}
