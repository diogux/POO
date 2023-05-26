package teste_aula_packages;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PackageTester {

    PackageManager manager = new PackageManager();

    public void testPackage() {
        //adicionar e remover packages
        Package pkg = new Package(1, 5, "Braga", "Porto");
        Package pkg2 = new Package(2, 3, "Braga", "Porto");
        manager.addPackage(pkg);
        manager.addPackage(pkg2);
        manager.removePackage(2);

        manager.printAllPackages();

        // calcular o custo de um package
        double cost = manager.cost(pkg);
        System.out.println(cost);
    }   

    public static void main(String[] args) {
        PackageTester tester = new PackageTester();
        tester.testPackage();   

        //instanciar o package manager
        PackageManager manager = new PackageManager();

        // Lê todas as packages de um ficheiro
       manager.loadFile("encomendas.txt");

        // Escreve todas as packages para um ficheiro

        manager.writeFile("packagesWritten.txt");

        // Imprime todas as packages
        manager.printAllPackages();

        // Procura a package 224
        System.out.println(manager.searchPackage(24));


    }



}
