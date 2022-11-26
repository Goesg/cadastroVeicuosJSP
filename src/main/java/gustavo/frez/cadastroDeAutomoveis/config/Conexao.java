package gustavo.frez.cadastroDeAutomoveis.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    public static Connection conectar() throws SQLException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:49153/frez_automoveis?useTimezone=true&serverTimezone=UTC&user=root&password=root");
        }catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }
}
