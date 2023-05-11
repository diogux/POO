package aula03;
import utils.*;
import java.util.Random;


public class Ex04 {
    public static void main(String[] args) {
        Random random = new Random();
        int alunos = UserInput.newPositiveInt("Quantos alunos tem a turma?: ");
        double[][] notas = new double[alunos][2];

        for (int i = 0; i < alunos; i++) {
            for(int j = 0; j< 2; j++) {
                double notaRandom = random.nextDouble(20);
                notas[i][j] = notaRandom;
            }
        }
        
        int notasSize = notas.length;
        System.out.printf("%-6s %-6s %-6s\n","notaT","notaP","notaF");
        
        for (int i = 0; i < notasSize; i++) {
            double notaF;
            if (notas[i][0] < 7 || notas[i][1] < 7) {
            notaF = 66;
            }
            else{
                notaF = 0.4 * notas[i][0] + 0.6*notas[i][1];    
            }
            System.out.printf("%-6.1f %-6.1f %-6.0f\n",notas[i][0],notas[i][1],notaF);
        }
    }
}
