package aula02;
import utils.*;

public class Ex08 {
    public static void main(String[] args) {
        double catetoA,catetoB,hip,angle;
        catetoA = UserInput.newPositiveDouble("Valor positivo para o cateto(A): ");
        catetoB = UserInput.newPositiveDouble("Valor positivo para o cateto(B): ");
        hip = Math.sqrt( Math.pow(catetoA,2) + Math.pow(catetoB,2));
        angle = Math.toDegrees(Math.acos(catetoA/hip));
        System.out.printf("A hipótenusa tem %.2f u.d. e entre o Cateto A e a hipótenusa existe um ângulo de %.2fº.",hip,angle);

    }
}
