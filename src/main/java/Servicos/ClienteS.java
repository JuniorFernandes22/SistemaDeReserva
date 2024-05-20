package Servicos;

import java.util.List;

import Modelo.Cliente;
import ModeloDAO.ClientDAO;

public class ClienteS {
    static ClientDAO clienteDAO = new ClientDAO();

    public ClienteS() {
    }

    public static void criarCliente(String nome, String email, String telefone){
        ClienteS cliente = new ClienteS();
        clienteDAO.criar(cliente);
    }

    public static void lerClientes(){
        List<Cliente> lista = clienteDAO.lerClientes();
        for (Cliente cliente : lista) {
            clienteDAO.lerClientes();
        }
    }

    public void atualizarCliente(int id, String nome, String email, String telefone) throws InterruptedException {
        String senha = null;
        ClienteS cliente = new ClienteS();
        cliente.wait(id);
        clienteDAO.atualizar(cliente);
    }

    public void removerCliente(int id){
        clienteDAO.remover(id);
    }

    public String getNome() {
        return null;

    }

    public String getEmail() {
        return null;
    }

    public String getTelefone() {
        return null;
    }
}
