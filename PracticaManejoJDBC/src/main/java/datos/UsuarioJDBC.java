package datos;

public class UsuarioJDBC {
    public static final String SQL_SELECT = "SELECT (idUser, userName, userPassword) FROM usuario";
    public static final String SQL_INSERT = "INSERT INTO usuario (userName, userPassword) VALUES (?, ?)";
    public static final String SQL_UPDATE = "UPDATE usuario SET userName = ?, userPassword = ? WHERE idUser ?";
    public static final String SQL_DELETE = "DELETE FROM usuario WHERE idUser = ?";
    
    public List<> seleccion() {
        
    }
}
