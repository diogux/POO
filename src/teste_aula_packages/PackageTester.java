package teste_doPedro_OficialOMG;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

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
        try {
            BufferedReader br = new BufferedReader(new FileReader("encomendas.txt"));
            String line;
            br.readLine();
            while((line = br.readLine()) != null){
                String[] fields = line.split(";");
                int id = Integer.parseInt(fields[0]);
                double weight = Double.parseDouble(fields[1]);
                String destination = fields[2];
                String sender = fields[3];
                Package p = new Package(id, weight, destination, sender);
                manager.addPackage(p);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Escreve todas as packages para um ficheiro

        try (PrintWriter output1 = new PrintWriter("AllPackages.txt")) {
            for (Package pkg : manager.packages.values()) {
                output1.write(pkg.getSender() + ":" + pkg.getDestination() + ":" + pkg.getWeight() + ":" + manager.cost(pkg));
                output1.write("\n");
            }
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
            return;
        }

        // Imprime todas as packages
        manager.printAllPackages();

        // Procura a package 224
        System.out.println(manager.searchPackage(24));


    }



}
