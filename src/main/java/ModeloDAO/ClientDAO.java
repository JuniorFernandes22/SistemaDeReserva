package ModeloDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Modelo.Cliente;
import Servicos.ClienteS;


public class ClientDAO {
    public void criar(ClienteS cliente) {
        Connection con = (Connection) Conexao.Connection.GetConnection(); // Altere aqui para usar a nova classe de conexão
        String sql = "INSERT INTO CLIENTES (nome, email, telefone) VALUES (?, ?, ?)";

        try (PreparedStatement smt = con.prepareStatement(sql)) {
            smt.setString(1, cliente.getNome());
            smt.setString(2, cliente.getEmail());
            smt.setString(3, cliente.getTelefone());
            smt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente criado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao criar cliente: " + e.getMessage());
        }
    }

    public List<Cliente> lerClientes() {
        Connection con = (Connection) Conexao.Connection.GetConnection(); // Altere aqui para usar a nova classe de conexão
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM CLIENTES";

        try (PreparedStatement smt = con.prepareStatement(sql)) {
            ResultSet resultado = smt.executeQuery();
            while (resultado.next()) {
                Cliente cliente = new Cliente(resultado.getString("nome"), resultado.getString("email"), resultado.getString("telefone"), "");
                lista.add(cliente);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao ler clientes: " + e.getMessage());
        }

        return lista;
    }

    public void atualizar(ClienteS cliente) {
        Connection con = (Connection) Conexao.Connection.GetConnection(); // Altere aqui para usar a nova classe de conexão
        String sql = "UPDATE CLIENTES SET nome = ?, email = ?, telefone = ? WHERE id = ?";

        try (PreparedStatement smt = con.prepareStatement(sql)) {
            smt.setString(1, cliente.getNome());
            smt.setString(2, cliente.getEmail());
            smt.setString(3, cliente.getTelefone());
            smt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar cliente: " + e.getMessage());
        }
    }

    public void remover(int id) {
        Connection con = (Connection) Conexao.Connection.GetConnection(); // Altere aqui para usar a nova classe de conexão
        String sql = "DELETE FROM CLIENTES WHERE id = ?";

        try (PreparedStatement smt = con.prepareStatement(sql)) {
            smt.setInt(1, id);
            smt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente removido com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao remover cliente: " + e.getMessage());
        }
    }
}

