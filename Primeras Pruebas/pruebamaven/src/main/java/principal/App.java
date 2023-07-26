package principal;

import java.util.Date;
import java.util.LinkedList;

import principal.logica.Alumno;
import principal.logica.Carrera;
import principal.logica.ControladoraLogica;
import principal.logica.Materia;

public class App {
    public static void main( String[] args ) {
        
        ControladoraLogica control = new ControladoraLogica();
        
        //Creamos lista de Materias
        LinkedList<Materia> listaMaterias = new LinkedList<Materia>();
        
        //Creación de Carrera con lista de MAterias
        Carrera carre = new Carrera(25, "Tecnicatura en Programación", listaMaterias);
        
        //Guardarla en la Base de Datos
        control.crearCarrera(carre);
        //Creación de Materia
        Materia mate1 = new Materia(58, "Programación I", "Cuatrimestral", carre);
        Materia mate2 = new Materia(59, "Programación II", "Cuatrimestral", carre);
        Materia mate3 = new Materia(60, "Programación Avanzada", "Anual", carre);
        
        
        //Guardar en la DB
        control.crearMateria(mate1);
        control.crearMateria(mate2);
        control.crearMateria(mate3);
        
        //Agregamos a la lista de Materias
        listaMaterias.add(mate1);
        listaMaterias.add(mate2);
        listaMaterias.add(mate3);
        
        carre.setListaMaterias(listaMaterias);
        control.editarCarrera(carre);
        
        
        // Creación de Alumno con Carrera
        Alumno alum = new Alumno(6, "Edd", "Chinowsky", new Date(), carre);
        
        //Guardamos el Alumno en la DB
        control.crearAlumno(alum);
        
        //Vemos resultado
        System.out.println("--------------------------");
        System.out.println("----DATOS ALUMNO----------");
        Alumno alu = control.traerAlumno(6);
        System.out.println("Alumno: " + alu.getNombre() + " " + alu.getApellido());
        System.out.println("Cursa la carrera de: " + alu.getCarre().getNombre());
        
    }
}
