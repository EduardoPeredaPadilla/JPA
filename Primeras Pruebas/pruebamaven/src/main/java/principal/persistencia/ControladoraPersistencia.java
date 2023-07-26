package principal.persistencia;

import principal.logica.Alumno;
import principal.logica.Carrera;
import principal.logica.Materia;
import principal.persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {
    
    AlumnoJpaController aluJpa = new AlumnoJpaController();
    CarreraJpaController carreJpa = new CarreraJpaController();
    MateriaJpaController mateJpa = new MateriaJpaController();

    public void crearAlumno(Alumno alu) {
        
        aluJpa.create(alu);
    }

    public void eliminarAlumno(int id) {
        
        try {
            aluJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarAlumno(Alumno alu) {
        
        try {
            aluJpa.edit(alu);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Alumno traerAlumno(int id) {
        
        return aluJpa.findAlumno(id);
    }

    public ArrayList<Alumno> traerListaAlumnos() {
        
        List<Alumno> lista = aluJpa.findAlumnoEntities();
        ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno> (lista);
        
        return listaAlumnos;
    }
    
    //Carrera
    public void crearCarrera(Carrera carre) {
        
        carreJpa.create(carre);
    }
    
    public void eliminarCarrera(int id) {
        
        try {
            carreJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarCarrera(Carrera carrer) {
        
        try {
            carreJpa.edit(carrer);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Carrera traerCarrera(int id) {
        
        return carreJpa.findCarrera(id);
    }

    public ArrayList<Carrera> traerListaCarreras() {
        
        List<Carrera> listaC = carreJpa.findCarreraEntities();
        ArrayList<Carrera> listaCarreras = new ArrayList<Carrera> (listaC);
        return listaCarreras;
    }
    
    
    //Materia
    public void crearMateria(Materia mate) {
        
        mateJpa.create(mate);
    }

    public void eliminarMateria(int id) {
        
        try {
            mateJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarMateria(Materia mate) {
        
        try {
            mateJpa.edit(mate);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Materia traerMateria(int id) {
        
        return mateJpa.findMateria(id);
    }

    public ArrayList<Materia> traerListaMaterias() {
        
        List<Materia> listaM = mateJpa.findMateriaEntities();
        ArrayList<Materia> listaMaterias = new ArrayList<Materia>(listaM);
        return listaMaterias;
    }
}
