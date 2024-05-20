package modelos;

import Modelo.Acomodacao;
import Modelo.Cliente;
import Modelo.Hotel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Reserva {
    private int idReserva;
    private Cliente cliente;
    private Hotel hotel;
    private List<Acomodacao> acomodacoes;
    private LocalDate dataCheckIn;
    private LocalDate dataCheckOut;
    private double valorTotal;

    public Reserva(int idReserva, Cliente cliente, Hotel hotel, LocalDate dataCheckIn, LocalDate dataCheckOut) {
        this.idReserva = idReserva;
        this.cliente = cliente;
        this.hotel = hotel;
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
        this.acomodacoes = new ArrayList<>();
        this.valorTotal = 0.0;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public List<Acomodacao> getAcomodacoes() {
        return acomodacoes;
    }

    public LocalDate getDataCheckIn() {
        return dataCheckIn;
    }

    public void setDataCheckIn(LocalDate dataCheckIn) {
        this.dataCheckIn = dataCheckIn;
        this.valorTotal = calcularValorTotal();
    }

    public LocalDate getDataCheckOut() {
        return dataCheckOut;
    }

    public void setDataCheckOut(LocalDate dataCheckOut) {
        this.dataCheckOut = dataCheckOut;
        this.valorTotal = calcularValorTotal();
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void adicionarAcomodacao(Acomodacao acomodacao) {
        this.acomodacoes.add(acomodacao);
        this.valorTotal = calcularValorTotal();
    }

    public void removerAcomodacao(Acomodacao acomodacao) {
        this.acomodacoes.remove(acomodacao);
        this.valorTotal = calcularValorTotal();
    }

    public void atualizarDatas(LocalDate dataCheckIn, LocalDate dataCheckOut) {
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
        this.valorTotal = calcularValorTotal();
    }

    public void cancelarReserva() {
        this.acomodacoes.clear();
        this.valorTotal = 0;
    }

    private double calcularValorTotal() {
        double total = 0;
        long dias = dataCheckOut.toEpochDay() - dataCheckIn.toEpochDay();
        for (Acomodacao acomodacao : acomodacoes) {
            total += acomodacao.getPrecoBase() * dias;
        }
        return total;
    }

    public void listarAcomodacoes() {
        for (Acomodacao acomodacao : acomodacoes) {
            System.out.println("Tipo: " + acomodacao.getTipo() + ", Leitos: " + acomodacao.getQuantidadeLeitos() + ", Preço: " + acomodacao.getPrecoBase());
        }
    }
}
