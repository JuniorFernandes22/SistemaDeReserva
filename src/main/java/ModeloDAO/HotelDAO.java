package ModeloDAO;

import Modelo.Hotel;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HotelDAO {
    public void criar(Hotel hotel) {
        Connection con = (Connection) Conexao.Connection.GetConnection(); // Altere aqui para usar a nova classe de conexão
        String sql = "INSERT INTO HOTEIS (nome_hotel, localizacao, telefone, email) VALUES (?, ?, ?, ?)";

        try (PreparedStatement smt = con.prepareStatement(sql)) {
            smt.setString(1, hotel.getNome());
            smt.setString(2, hotel.getLocalizacao());
            // Considerando que Hotel não possui telefone e email no exemplo fornecido
            smt.setString(3, ""); // Não há telefone no modelo Hotel
            smt.setString(4, ""); // Não há email no modelo Hotel
            smt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Hotel criado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao criar hotel: " + e.getMessage());
        }
    }

    public List<Hotel> lerHoteis() {
        Connection con = (Connection) Conexao.Connection.GetConnection(); // Altere aqui para usar a nova classe de conexão
        List<Hotel> lista = new ArrayList<>();
        String sql = "SELECT * FROM HOTEIS";

        try (PreparedStatement smt = con.prepareStatement(sql)) {
            ResultSet resultado = smt.executeQuery();
            while (resultado.next()) {
                Hotel hotel = new Hotel(resultado.getString("nome_hotel"), resultado.getString("localizacao"));
                lista.add(hotel);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao ler hotéis: " + e.getMessage());
        }

        return lista;
    }

    public void atualizar(Hotel hotel, int id) {
        Connection con = (Connection) Conexao.Connection.GetConnection(); // Altere aqui para usar a nova classe de conexão
        String sql = "UPDATE HOTEIS SET nome_hotel = ?, localizacao = ? WHERE id = ?";

        try (PreparedStatement smt = con.prepareStatement(sql)) {
            smt.setString(1, hotel.getNome());
            smt.setString(2, hotel.getLocalizacao());
            smt.setInt(3, id);
            smt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Hotel atualizado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar hotel: " + e.getMessage());
        }
    }

    public void remover(int id) {
        Connection con = (Connection) Conexao.Connection.GetConnection(); // Altere aqui para usar a nova classe de conexão
        String sql = "DELETE FROM HOTEIS WHERE id = ?";

        try (PreparedStatement smt = con.prepareStatement(sql)) {
            smt.setInt(1, id);
            smt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Hotel removido com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao remover hotel: " + e.getMessage());
        }
    }
}

