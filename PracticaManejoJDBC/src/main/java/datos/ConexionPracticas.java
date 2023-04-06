package datos;

import java.sql.*;

public class ConexionPracticas {

    private static final String url = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";

    private static final String JDBC_USER = "user";
    private static final String JDBC_PASSWORD = "123456789";

    public static Connection getConnection() throws SQLException { //ESTA ES LA CONEXION A LA BASE DE DATOS
        return DriverManager.getConnection(url, JDBC_USER, JDBC_PASSWORD);
    }

    public static void close(ResultSet rs) throws SQLException {
        rs.close();
    }

    public static void close(Statement smtm) throws SQLException { 
        smtm.close();
    }
     public static void close(PreparedStatement smtm) throws SQLException { 
        smtm.close();
    }

    public static void close(Connection conn) throws SQLException{
        conn.close();
    }
}
