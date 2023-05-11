package aula08;

public enum DiaSemana {
    Segunda, Terça, Quarta, Quinta, Sexta;

    static DiaSemana getDiaSemana(int dia) { // 0 = segunda, 1 = terça, etc.
        DiaSemana[] dias = DiaSemana.values();
        return dias[dia];
        }
    }

    

