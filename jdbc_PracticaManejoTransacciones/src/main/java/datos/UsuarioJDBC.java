package datos;

import static datos.ConexionPracticas.*;
import dominio.Usuario;
import java.sql.*;
import java.util.*;

public class UsuarioJDBC {
    
    private Connection conexionTransaccional;

    public static final String SQL_SELECT = "SELECT (id_User, userName, userPassword) FROM usuario";
    public static final String SQL_INSERT = "INSERT INTO usuario (userName, userPassword) VALUES (?, ?)";
    public static final String SQL_UPDATE = "UPDATE usuario SET userName = ?, userPassword = ? WHERE id_User ?";
    public static final String SQL_DELETE = "DELETE FROM usuario WHERE id_User = ?";

    public UsuarioJDBC (){
        
    }
    
    public UsuarioJDBC(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }
    
    public List<Usuario> seleccion() throws SQLException {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        Usuario user = null;
        List<Usuario> users = new ArrayList<Usuario>();
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : ConexionPracticas.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            res = stmt.executeQuery();
            while (res.next()) {
                int id_User = res.getInt("id_User");
                String userName = res.getString("userName");
                String userPassword = res.getString("userPassword");
                user = new Usuario(id_User, userName, userPassword);
                users.add(user);
            }
        } finally {
            try {
                close(res);
                close(stmt);
                if (this.conexionTransaccional == null) {
                ConexionPracticas.close(conn);
            }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return users;
    }

    public int inserte(Usuario user) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registroInserts = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : ConexionPracticas.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, user.getUserName());
            stmt.setString(2, user.getUserPassword());
            
            registroInserts = stmt.executeUpdate();
            System.out.println("Registros de Usuarios Insertados = " + registroInserts);
        } finally {
            try {
                close(stmt);
                if (this.conexionTransaccional == null) {
                ConexionPracticas.close(conn);
            }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
            return registroInserts;
        }
    }

    public int actualizar(Usuario user) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registroAct = 0;
        try{
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : ConexionPracticas.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, user.getUserName());
            stmt.setString(2, user.getUserPassword());
            registroAct = stmt.executeUpdate();
            System.out.println("Registros de Usuarios Actualizados = " + registroAct);
        } finally {
            try {
                close(stmt);
                if (this.conexionTransaccional == null) {
                ConexionPracticas.close(conn);
            }            }catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registroAct;
    }
    public int eliminar (Usuario user) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        int registroDelete = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : ConexionPracticas.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, user.getId_User());
            registroDelete = stmt.executeUpdate();
            System.out.println("Registros de Usuarios eliminados = " + registroDelete);
        } finally {
            try {
                close(stmt);
                if (this.conexionTransaccional == null) {
                ConexionPracticas.close(conn);
            }            }catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registroDelete;
    }
}
