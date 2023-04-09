package test;

import datos.ConexionPracticas;
import datos.PersonaJDBC;
import dominio.Persona;
import java.sql.*;
import java.util.*;

public class MainPersonas {
    public static void main(String[] args) {
        
        Connection conexion = null; //se define fuera del blocke se instancia dentro
        try{
            conexion = ConexionPracticas.getConnection();//aqui tenemos la conexion fuera de personaJDBC
            if(conexion.getAutoCommit()){
             conexion.setAutoCommit(false); //Por defecto commit es TRUE
            }
            
            PersonaJDBC Person = new PersonaJDBC(conexion);
            
            Persona cambioPersona = new Persona();
            cambioPersona.setIdPerson(1);
            cambioPersona.setNamePerson("Marcos");
            cambioPersona.setSurnamePerson("Gonzales");
            cambioPersona.setYearsPerson(28);
            cambioPersona.setEmailPerson("emailhere@gmail.ss");
            Person.actualizar(cambioPersona);

            Persona newPersona = new Persona();
            newPersona.setIdPerson(3);
            newPersona.setNamePerson("Lawrence");
            newPersona.setSurnamePerson("Gardfa");
            newPersona.setYearsPerson(30);
            newPersona.setEmailPerson("emailhere@gmial.ss");
            Person.inserte(newPersona);
            
            conexion.commit();
                System.out.println("Se hizo commit");
            
        }catch (SQLException ex){
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
    }
        
}
