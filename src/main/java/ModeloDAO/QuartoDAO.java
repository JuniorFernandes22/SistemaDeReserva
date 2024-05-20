package ModeloDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Modelo.Quarto;


public class QuartoDAO {
    public void criar(Quarto quarto) {
        Connection con = (Connection) Conexao.Connection.GetConnection(); // Altere aqui para usar a nova classe de conexão
        String sql = "INSERT INTO QUARTOS (tipo, quantidade_leitos, preco_base, reservado) VALUES (?, ?, ?, ?)";

        try (PreparedStatement smt = con.prepareStatement(sql)) {
            smt.setString(1, quarto.getTipo());
            smt.setInt(2, quarto.getQuantidadeLeitos());
            smt.setDouble(3, quarto.getPrecoBase());
            smt.setBoolean(4, quarto.isReservado());
            smt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Quarto criado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao criar quarto: " + e.getMessage());
        }
    }

    public List<Quarto> lerQuartos() {
        Connection con = (Connection) Conexao.Connection.GetConnection(); // Altere aqui para usar a nova classe de conexão
        List<Quarto> lista = new ArrayList<>();
        String sql = "SELECT * FROM QUARTOS";

        try (PreparedStatement smt = con.prepareStatement(sql)) {
            ResultSet resultado = smt.executeQuery();
            while (resultado.next()) {
                Quarto quarto = new Quarto(resultado.getString("tipo"), resultado.getInt("quantidade_leitos"), resultado.getDouble("preco_base"));
                quarto.setReservado(resultado.getBoolean("reservado"));
                lista.add(quarto);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao ler quartos: " + e.getMessage());
        }

        return lista;
    }

    // Adicione métodos para atualizar, remover e outras operações conforme necessário
}
