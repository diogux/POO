package aula09.ex01;

import aula06.Pessoa;
import aula07.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
// import utils.DateYMD;

public class AlDemo {
    public static void main(String[] args) {
        ArrayList<Integer> c1 = new ArrayList<>();
        for (int i = 10; i <= 100; i += 10)
            c1.add(i);
        System.out.println("Size: " + c1.size());
        for (int i = 0; i < c1.size(); i++)
            System.out.println("Elemento: " + c1.get(i));

        ArrayList<String> c2 = new ArrayList<>();

        c2.add("Vento");
        c2.add("Calor");
        c2.add("Frio");
        c2.add("Chuva");
        System.out.println(c2);
        Collections.sort(c2);
        System.out.println(c2);
        c2.remove("Frio");
        c2.remove(0);
        System.out.println(c2);

        // Testes das funções a)
        System.out.println("----Testes das funções----");
        System.out.println("Size: " + c1.size());
        System.out.println("Primeiro elemento: " + c1.get(0));
        System.out.println("Segundo elemento: " + c1.get(1));
        System.out.println("c2: " + c2);
        c2.add("Sol");
        System.out.println("Adicionar Sol a c2: " + c2);
        System.out.println("Index de Vento em c2: " + c2.indexOf("Vento"));
        System.out.println("Index de Sol em c2: " + c2.indexOf("Sol"));
        // set
        c2.set(0, "Vento");
        System.out.println("(c2.set(0,Vento)) c2: " + c2);
        // sub list
        System.out.println("c2.subList(0, 2): " + c2.subList(0, 2));

        // b)

        System.out.println("----Alínea b)----\n");

        Set<Pessoa> c3 = new HashSet<>();
        c3.add(new Pessoa("António Alberto", 3467225, new utils.DateYMD(13, 3, 1967)));
        c3.add(new Pessoa("André Dora", 9855678, new utils.DateYMD(18, 7, 1990)));
        c3.add(new Pessoa("Rita Silva", 8976543, new utils.DateYMD(11, 5, 1985)));
        c3.add(new Pessoa("Raquel Vinagre", 7634123, new utils.DateYMD(9, 3, 1998)));
        c3.add(new Pessoa("Diogo Fernandes", 1234567, new utils.DateYMD(1, 9, 2004)));
        c3.add(new Pessoa("André Dorasadjsada", 9855678, new utils.DateYMD(18, 7, 1990)));
        c3.add(new Pessoa("Pedro Salgado", 1234567, new utils.DateYMD(14, 8, 2007)));
        c3.add(new Pessoa("Pedro Salgado", 7777777, new utils.DateYMD(19, 8, 2007)));
        c3.add(new Pessoa("Pedro Salgado", 7777777, new utils.DateYMD(19, 8, 2007)));

        for (Pessoa p : c3)
            System.out.println(p + " Hascode: " + p.hashCode());

        // c)
        System.out.println("----Alínea c)----\n");

        Set<Date> c4 = new TreeSet<>();
        c4.add(new DateYMD(1, 1, 2000));
        c4.add(new DateYMD(2, 9, 2034));
        c4.add(new DateYMD(3, 3, 2000));
        c4.add(new DateYMD(4, 4, 2006));
        c4.add(new DateYMD(4, 4, 2006));

        for (Date d : c4)
            System.out.println(d + " Hascode: " + d.hashCode());

    }
}
