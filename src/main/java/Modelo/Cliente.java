package Modelo;

import Modelo.Utilizador;

public class Cliente extends Utilizador {

    public Cliente(String nome, String email, String telefone, String senha) {
        super(nome, email, telefone, senha);
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Nome: " + getNome());
        System.out.println("Email: " + getEmail());
        System.out.println("telefone: " + getTelefone());
    }

    public void setId(int id) {
    }
}
