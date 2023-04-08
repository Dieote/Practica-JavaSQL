package datos;

import static datos.ConexionPracticas.*;
import dominio.Persona;
import java.sql.*;
import java.util.*;

public class PersonaJDBC {

    public static final String SQL_SELECT = "SELECT idPerson, namePerson, surnamePerson, yearsPerson, emailPerson FROM persona";
    public static final String SQL_INSERT = "INSERT INTO persona (idPerson, namePerson, yearsPerson, emailPerson) VALUES (?, ?, ?, ?)";
    public static final String SQL_UPDATE = "UPDATE persona SET namePerson = ?, surnamePerson = ?, yearsPerson = ?, emailPerson = ? WHERE idPerson ?";
    public static final String SQL_DELETE = "DELETE FROM persona WHERE idPerson = ?";

    public List<Persona> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet resul = null;
        Persona person = null;
        List< Persona> persons = new ArrayList<>();
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            int idPerson = resul.getInt("IdPerson");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(resul);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return persons;
    }

    public int inserte(Persona person) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registroInserts = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, person.getIdPerson());
            stmt.setString(2, person.getNamePerson());
            stmt.setString(3, person.getSurnamePerson());
            stmt.setInt(4, person.getYearsPerson());
            stmt.setString(5, person.getEmailPerson());
            registroInserts = stmt.executeUpdate();
            System.out.println("Registros de personas Insertados = " + registroInserts);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
            return registroInserts;
        }
    }
    
    public int actualizar (Persona person) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registroAct = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, person.getNamePerson());
            stmt.setString(2, person.getSurnamePerson());
            stmt.setInt(3, person.getYearsPerson());
            stmt.setString(4, person.getEmailPerson());
            stmt.setInt(5, person.getIdPerson());
            registroAct = stmt.executeUpdate();
            System.out.println("Registros de personas Actualizadas = " + registroAct);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
            return registroAct;
        }    
    }
    
    public int eliminar (Persona person){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registroDelete = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, person.getIdPerson());
            registroDelete = stmt.executeUpdate();
            System.out.println("Registros de Personas eliminadas = " + registroDelete);
        }catch (SQLException ex){
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            }catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registroDelete;
    }
}
