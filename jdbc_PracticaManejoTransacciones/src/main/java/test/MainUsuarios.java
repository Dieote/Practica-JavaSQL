package test;

import datos.UsuarioJDBC;
import dominio.Usuario;
import java.util.*;

public class MainUsuarios {

    public static void main(String[] args) {
        UsuarioJDBC user = new UsuarioJDBC();

       //Listar Usuarios
        List<Usuario> usuarios = new ArrayList<>();
        for (Usuario usuario : usuarios) { 
        //Insertamos Usuarios
            usuarios.add(new Usuario("Maru3421", "dasda*21"));
            usuarios.add(new Usuario("Car123lo", "fera*121"));
            usuarios.add(new Usuario("anDR0s", "fre21Str"));
            usuarios.add(new Usuario("Maqa12", "lalalon*234"));
            usuarios.add(new Usuario("luch099", "kakre1421"));
            usuarios.add(new Usuario("JOse193", "daND2ll1"));
            usuarios.add(new Usuario("JOse193", "daND2ll1"));
            
            //Actualizamos Usuario
            Usuario userUp = new Usuario(3, "Andiy", "fre21Str");
            user.actualizar(userUp);
            
             //Eliminar usuario
            user.eliminar(new Usuario(6));
        }
    }
}
