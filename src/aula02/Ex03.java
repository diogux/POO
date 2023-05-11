package aula02;
import utils.*;

public class Ex03 {
    public static void main(String[] agrs) {
        double mass,tempIni,tempFin,energy;
        mass = UserInput.newDouble("Insira a massa da água em Kg: ");
        tempIni = UserInput.newDouble("Insira a temperatura incial da água: ");
        tempFin = UserInput.newDouble("Insira a temperatura final da água: ");
        energy = mass*(tempFin-tempIni) * 4184;
        System.out.println("A energia necessária para aquecer a água é de: "+ energy + " Joules.");
    }
    
}
