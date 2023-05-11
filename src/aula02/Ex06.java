package aula02;
import utils.*;

public class Ex06 {
    public static void main(String[] args) {
        int s,m,h;
        s = UserInput.newInt("Insira os segundos: ");
        h = (s/3600)%24;
        m = (s/60)%60;
        s = s%60;
        System.out.printf( "%02d:%02d:%02d",h,m,s); 

    }

}
