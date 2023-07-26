package principal.logica;

import java.util.ArrayList;
import principal.persistencia.ControladoraPersistencia;

public class ControladoraLogica {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    public void crearAlumno(Alumno alu) {
        
        controlPersis.crearAlumno (alu);
    }
    
    public void eliminarAlumno(int id) {
        
        controlPersis.eliminarAlumno(id);
    }
    
    public void editarAlumno(Alumno alu) {
        
        controlPersis.editarAlumno(alu);
    }
    
    //Buscar un alumno en particular
    public Alumno traerAlumno(int id) {
        
        return controlPersis.traerAlumno(id);
    }
    
    //Traer todos los alumnos
    public ArrayList<Alumno> traerListaAlumnos() {
        return controlPersis.traerListaAlumnos();
    }
    
    //Carrera
    public void crearCarrera(Carrera carre) {
        
        controlPersis.crearCarrera (carre);
    }
    
    public void eliminarCarrera(int id) {
        
        controlPersis.eliminarCarrera(id);
    }
    
    public void editarCarrera(Carrera carrer) {
        
        controlPersis.editarCarrera(carrer);
    }
    
    //Buscar un alumno en particular
    public Carrera traerCarrera(int id) {
        
        return controlPersis.traerCarrera(id);
    }
    
    //Traer todos los alumnos
    public ArrayList<Carrera> traerListaCarrreras() {
        return controlPersis.traerListaCarreras();
    }
    
    //Materia
    public void crearMateria(Materia mate) {
        
        controlPersis.crearMateria (mate);
    }
    
    public void eliminarMateria(int id) {
        
        controlPersis.eliminarMateria(id);
    }
    
    public void editarMateria(Materia mate) {
        
        controlPersis.editarMateria(mate);
    }
    
    //Buscar un alumno en particular
    public Materia traerMateria(int id) {
        
        return controlPersis.traerMateria(id);
    }
    
    //Traer todos las materias
    public ArrayList<Materia> traerListaMaterias() {
        return controlPersis.traerListaMaterias();
    }
}
