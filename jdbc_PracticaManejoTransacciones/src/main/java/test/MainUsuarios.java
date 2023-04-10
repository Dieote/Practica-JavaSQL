package test;

import datos.ConexionPracticas;
import datos.UsuarioJDBC;
import dominio.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

public class MainUsuarios {

    public static void main(String[] args) {
        Connection conexion = null;
        try {
            conexion = ConexionPracticas.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
        }
        UsuarioJDBC user = new UsuarioJDBC(conexion);
            Usuario cambioUser = new Usuario();
            cambioUser.setId_User(1);
            cambioUser.setUserName("juan.perez.1");
            cambioUser.setUserPassword("123");
            user.actualizar(cambioUser);
            
            Usuario newUser = new Usuario();
            newUser.setUserName("CarloMans");
            newUser.setUserPassword("6480ß37");
            user.inserte(newUser);
            
            conexion.commit();
            System.out.println("Se hizo commit");
            
        } catch (SQLException ex) {
        ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
    }

//    public static void main(String[] args) {
//        UsuarioJDBC user = new UsuarioJDBC();
//
//       //Listar Usuarios
//        List<Usuario> usuarios = new ArrayList<>();
//        for (Usuario usuario : usuarios) { 
//        //Insertamos Usuarios
//            usuarios.add(new Usuario("Maru3421", "dasda*21"));
//            usuarios.add(new Usuario("Car123lo", "fera*121"));
//            usuarios.add(new Usuario("anDR0s", "fre21Str"));
//            usuarios.add(new Usuario("Maqa12", "lalalon*234"));
//            usuarios.add(new Usuario("luch099", "kakre1421"));
//            usuarios.add(new Usuario("JOse193", "daND2ll1"));
//            usuarios.add(new Usuario("JOse193", "daND2ll1"));
//            
//            //Actualizamos Usuario
//            Usuario userUp = new Usuario(3, "Andiy", "fre21Str");
//            user.actualizar(userUp);
//            
//             //Eliminar usuario
//            user.eliminar(new Usuario(6));
//        }
//    }
}
