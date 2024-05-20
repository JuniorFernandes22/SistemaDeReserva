package Servicos;

import java.util.List;
import Modelo.Funcionario;
import ModeloDAO.FuncionarioDAO;

public class FuncionarioS {
    FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

    public void criarFuncionario(String nome, String email, String telefone, String senha, String cargo){
        Funcionario funcionario = new Funcionario(nome, email, telefone, senha, cargo);
        funcionarioDAO.criar(funcionario);
    }

    public void lerFuncionarios(){
        List<Funcionario> lista = funcionarioDAO.lerFuncionarios();
        for (Funcionario funcionario : lista) {
            System.out.println(funcionario.getNome() + " - " + funcionario.getEmail() + " - " + funcionario.getTelefone() + " - " + funcionario.getCargo());
        }
    }

    public void atualizarFuncionario(int id, String nome, String email, String telefone, String senha, String cargo){
        Funcionario funcionario = new Funcionario(nome, email, telefone, senha, cargo);
        Funcionario.atualizar(id);
        FuncionarioDAO.atualizar(funcionario);
    }

    public void removerFuncionario(int id){
        funcionarioDAO.remover(id);
    }
}
