package test;

import datos.PersonaJDBC;
import dominio.Persona;
import java.util.*;

public class MainPersonas {
    public static void main(String[] args) {
        PersonaJDBC person = new PersonaJDBC();
        
        //Listado personas
        List<Persona> personas = new ArrayList();
        for(Persona persona : personas){
        personas.add(new Persona("Marcela", "Monsal",32, "MonMar@gmail.ss"));
        personas.add(new Persona("Lewis", "Smonj",28, "LewSmon@gmail.ss"));
        personas.add(new Persona("Lesly", "Junks",33, "LesJun@gmail.ss"));
        personas.add(new Persona("Hannah", "Fernandez",25, "HanFer@gmail.ss"));
        personas.add(new Persona("Mariela", "Kachs",36, "MariKach@gmail.ss"));
        personas.add(new Persona("Carlos", "Moins",27, "CarlMoi@gmail.ss"));
        personas.add(new Persona("Andress", "Hous",29, "AndOus@gmail.ss"));
        personas.add(new Persona("Macarena", "Cando",30, "MacaCan@gmail.ss"));
        
        //  Actualizamos Persona
        Persona personUp = new Persona(2,"Dario", "Lorenh", 38, "DarLor@gmail.ss");
        person.actualizar(personUp);
        }
        
        //Eliminar Persona
        person.eliminar(new Persona(1));
    }
}
