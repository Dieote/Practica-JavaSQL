package datos;

import static datos.ConexionPracticas.*;
import dominio.Persona;
import java.sql.*;
import java.util.*;

public class PersonaJDBC {

    public static final String SQL_SELECT = "SELECT idPerson, namePerson, surnamePerson, yearsPerson, emailPerson FROM usuario";
    public static final String SQL_INSERT = "INSERT INTO usuario (idPerson, namePerson, yearsPerson, emailPerson) VALUES (?, ?, ?, ?)";
    public static final String SQL_UPDATE = "UPDATE usuario SET namePerson = ?, surnamePerson = ?, yearsPerson = ?, emailPerson = ? WHERE id_User ?";
    public static final String SQL_DELETE = "DELETE FROM usuario WHERE idPerson = ?";
     
    public List<Persona> seleccionar (){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet resul = null;
        Persona person = null;
        List< Persona> persons = new ArrayList<>();
        
        try{
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
}
