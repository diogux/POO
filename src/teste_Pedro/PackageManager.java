package teste_Pedro;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;
import java.util.Set;
import java.util.Map;
import java.util.TreeMap;
import java.io.FileWriter;
import java.io.PrintWriter;	
import java.util.ArrayList;


public class PackageManager {
    private Map<Integer, Package> packages = new TreeMap<>();
    
    public void load(String filename){
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;
            br.readLine();
            while((line = br.readLine()) != null){
                String[] fields = line.split(";");
                int id = Integer.parseInt(fields[0]);
                double weight = Double.parseDouble(fields[1]);
                String destination = fields[2];
                String sender = fields[3];
                Package p = new Package(id, weight, destination, sender);
                packages.put(id, p);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    

    public void removePackage(int id){
        packages.remove(id);
    }

    public Package getPackage(int id){
        for(Package p : packages){
            if(p.getId() == id){
                return p;
            }
        }
        return null;
    }


    public void writeFile(String filename) throws IOException{

        try {
            FileWriter fw = new FileWriter(filename);
            PrintWriter pw = new PrintWriter(fw);
            pw.write("ID:Weight:Destination:Sender:Price\n");
            for(Package p : packages.values() ){
                ShippingCostCalculator calculadora = new ShippingCost();
                double price = calculadora.calculateShippingCost(p);
                pw.write(p.toString() +  ":"+ price + "\n");
            }        
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
