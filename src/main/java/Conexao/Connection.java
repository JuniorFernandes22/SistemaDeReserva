package Conexao;


import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
    private static final String URL = "jdbc:mysql://localhost:3306/sistemadereserva";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static java.sql.Connection conn;


    public static Connection GetConnection() {


        try {
            if (conn == null) {
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
                return (Connection) conn;
            } else{
                return (Connection) conn;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
}

