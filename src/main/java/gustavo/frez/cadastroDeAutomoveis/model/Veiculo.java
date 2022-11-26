package gustavo.frez.cadastroDeAutomoveis.model;


import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Veiculo {

    private Long id;
    private String placa;
    private String modelo;
    private String marca;
    private int lugares;
    private Double valorAluguel;

    public Veiculo() {
    }

    public Veiculo(Long id, String placa, String modelo, String marca, int lugares, Double valorAluguel) {
        this.id = id;
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.lugares = lugares;
        this.valorAluguel = valorAluguel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getLugares() {
        return lugares;
    }

    public void setLugares(int lugares) {
        this.lugares = lugares;
    }

    public Double getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(Double valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Veiculo{");
        sb.append("id=").append(id);
        sb.append(", placa='").append(placa).append('\'');
        sb.append(", modelo='").append(modelo).append('\'');
        sb.append(", marca='").append(marca).append('\'');
        sb.append(", lugares=").append(lugares);
        sb.append(", valorAluguel=").append(valorAluguel);
        sb.append('}');
        return sb.toString();
    }
}
