package aula08;

public class Ex01_Main {
    
    public static void main(String[] args) {
        EmpresaAluguer empresa = new EmpresaAluguer("Empresa YEY", "2430-342","empresasuperfixe@mail.com");
        
        Motociclo moto = new Motociclo("12-00-AA", "Yamaha","SUPERXD",300, "desportivo");
        moto.trajeto(500);

        AutomovelLigeiro autoLigeiro = new AutomovelLigeiro("00-XD-AA", "Ferrari", "SF-22", 340, "000000X0000000000", 100);
        autoLigeiro.trajeto(2000);

        PesadoMercadorias pesadoMercadorias = new PesadoMercadorias("00-00-00", "Mercedes", "IO3-HEAVY", 100, "00000L00000000001", 2000, 1000);
        pesadoMercadorias.trajeto(1500);

        PesadoPassageiros pesadoPassageiros = new PesadoPassageiros("P1-00-30", "Bugatti", "Adder", 90, "0000G000000000002", 1500, 40);
        pesadoPassageiros.trajeto(4000);

        Taxi taxi = new Taxi("69-TA-XI", "Alfa Romeo", "TAXI-OOP", 100, "0000B000000000005", 2000, 1000);
        taxi.trajeto(300);

        EletricoLigeiro eletricoLigeiro = new EletricoLigeiro("22-XP-TO", "Tesla", "Model S", 100, "A0000000000000002", 100, 1000,85);
        eletricoLigeiro.trajeto(500);
        eletricoLigeiro.carregar(10);

        EletricoPesadoPassageiros eletricoPesadoPassageiros = new EletricoPesadoPassageiros("AA-01-AA", "Nissan", "Fx-300", 1000, "ALAL0203999000000", 2000, 54, 1500, 20);
        eletricoPesadoPassageiros.trajeto(9000);
        eletricoPesadoPassageiros.carregar(15);

        empresa.addVeiculo(moto);
        empresa.addVeiculo(autoLigeiro);
        empresa.addVeiculo(pesadoMercadorias);
        empresa.addVeiculo(pesadoPassageiros);
        empresa.addVeiculo(taxi);
        empresa.addVeiculo(eletricoLigeiro);
        empresa.addVeiculo(eletricoPesadoPassageiros);



        //Printar o veiculo com mais km percorridos

        double maxKms = 0;
        for(Veiculo veiculo : empresa.getVeiculosList()) {
            if(veiculo.distanciaTotal() > maxKms) {
                maxKms = +veiculo.distanciaTotal();
            }
        }

        for(Veiculo veiculo : empresa.getVeiculosList()) {
            if(veiculo.distanciaTotal() == maxKms) {
                System.out.printf("Veículo com mais km percorridos: (%d km)\n", (int)maxKms);
                System.out.println(veiculo);
            }
        }





}
}
