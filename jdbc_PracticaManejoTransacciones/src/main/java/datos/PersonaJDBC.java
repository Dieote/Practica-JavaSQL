package datos;

import static datos.ConexionPracticas.*;
import dominio.Persona;
import java.sql.*;
import java.util.*;

public class PersonaJDBC {
    
    private Connection conexionTransaccional; //la transaccion es para conectarse desde otras clases

    public static final String SQL_SELECT = "SELECT idPerson, namePerson, surnamePerson, yearsPerson, emailPerson FROM persona";
    public static final String SQL_INSERT = "INSERT INTO persona (idPerson, namePerson, yearsPerson, emailPerson) VALUES (?, ?, ?, ?)";
    public static final String SQL_UPDATE = "UPDATE persona SET namePerson = ?, surnamePerson = ?, yearsPerson = ?, emailPerson = ? WHERE idPerson ?";
    public static final String SQL_DELETE = "DELETE FROM persona WHERE idPerson = ?";

    public PersonaJDBC() {
    
}
    public PersonaJDBC(Connection conexionTransaccional){
        this.conexionTransaccional = conexionTransaccional;
    }
    public List<Persona> seleccionar() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet resul = null;
        Persona person = null;
        List< Persona> persons = new ArrayList<>();
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : ConexionPracticas.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            int idPerson = resul.getInt("IdPerson");
        } finally {
            try {
                close(resul);
                close(stmt);
                    if(this.conexionTransaccional == null){
                    ConexionPracticas.close(conn);
                }                
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return persons;
    }

    public int inserte(Persona person) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registroInserts = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : ConexionPracticas.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, person.getIdPerson());
            stmt.setString(2, person.getNamePerson());
            stmt.setString(3, person.getSurnamePerson());
            stmt.setInt(4, person.getYearsPerson());
            stmt.setString(5, person.getEmailPerson());
            registroInserts = stmt.executeUpdate();
            System.out.println("Registros de personas Insertados = " + registroInserts);
        } finally {
            try {
                close(stmt);
                if(this.conexionTransaccional == null){
                    ConexionPracticas.close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
            return registroInserts;
        }
    }
    
    public int actualizar (Persona person) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        int registroAct = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : ConexionPracticas.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, person.getNamePerson());
            stmt.setString(2, person.getSurnamePerson());
            stmt.setInt(3, person.getYearsPerson());
            stmt.setString(4, person.getEmailPerson());
            stmt.setInt(5, person.getIdPerson());
            registroAct = stmt.executeUpdate();
            System.out.println("Registros de personas Actualizadas = " + registroAct);
        } finally {
            try {
                close(stmt);
                    if(this.conexionTransaccional == null){
                    ConexionPracticas.close(conn);
                }            
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
            return registroAct;
        }    
    }
    
    public int eliminar (Persona person) throws SQLException { //al colocar los throws se manejan las excepciones 
        Connection conn = null;
        PreparedStatement stmt = null;
        int registroDelete = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : ConexionPracticas.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, person.getIdPerson());
            registroDelete = stmt.executeUpdate();
            System.out.println("Registros de Personas eliminadas = " + registroDelete);
        } finally {
            try {
                close(stmt);
                    if(this.conexionTransaccional == null){
                    ConexionPracticas.close(conn);
                }                
            }catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registroDelete;
    }
}
