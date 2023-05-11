package aula08;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.ArrayList;
import java.util.List;

public class EmpresaAluguer {
    private String nome;
    private String codigoPostal;
    private String email;
    private List<Veiculo> veiculos = new ArrayList<>();

    public EmpresaAluguer(String nome, String codigoPostal, String email) {
        this.nome = nome;
        this.codigoPostal = codigoPostal;
        if(validEmail(email)) {
            this.email = email;
        }
    }

    public String getNome() {
        return nome;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public String getEmail() {
        return email;
    }

    public List<Veiculo> getVeiculosList() {
        return veiculos;
    }

    public void addVeiculo(Veiculo veiculo) {
        this.veiculos.add(veiculo);
    }

    public Veiculo getVeiculo(String matricula) {
        for(Veiculo veiculo : veiculos) {
            if(veiculo.getMatricula() == matricula) {
                return veiculo;
            }
        }

        return null;
    }

    public boolean validEmail(String email) {
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
