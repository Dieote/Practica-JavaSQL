package datos;

import static datos.ConexionPracticas.*;
import dominio.Usuario;
import java.sql.*;
import java.util.*;

public class UsuarioJDBC {

    public static final String SQL_SELECT = "SELECT (idUser, userName, userPassword) FROM usuario";
    public static final String SQL_INSERT = "INSERT INTO usuario (userName, userPassword) VALUES (?, ?)";
    public static final String SQL_UPDATE = "UPDATE usuario SET userName = ?, userPassword = ? WHERE idUser ?";
    public static final String SQL_DELETE = "DELETE FROM usuario WHERE idUser = ?";

    public List<Usuario> seleccion() {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        Usuario user = null;
        List<Usuario> users = new ArrayList<Usuario>();

        try {
            conn = getConnection();
            stmt = conn.preprareStatement(SQL_SELECT);
            res = stmt.executeQuery();
            while (res.next()) {
                int idUser = res.getInt("idUser");
                String userName = res.getString("userName");
                String userPassword = res.getString("userPassword");
                user = new Usuario(idUser, userName, userPassword);
                users.add(user);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(res);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return users;
    }
}
