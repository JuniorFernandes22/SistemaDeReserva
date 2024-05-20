package Modelo;

public class Quarto extends Acomodacao {
    private boolean reservado;

    public Quarto(String tipo, int quantidadeLeitos, double precoBase) {
        super(tipo, quantidadeLeitos, precoBase);
        this.reservado = false;
    }

    public void reservar() {
        this.reservado = true;
    }

    public void cancelarReserva() {
        this.reservado = false;
    }

    public double calcularPreco() {
        double preco = getPrecoBase();
        if (this.reservado) {
            preco += 10.0;
        }
        return preco;
    }

    public Object getLocalizacao() {
        return null;
    }

    public boolean isReservado() {
        return true;
    }
}
