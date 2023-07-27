package principal.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


import principal.logica.entities.Autor;
import principal.logica.entities.Editorial;
import principal.logica.entities.Libro;
import principal.persistence.exceptions.NonexistentEntityException;

public class ControladoraPersistencia {
    
    AutorJpaController autorJpa = new AutorJpaController();
    EditorialJpaController editJpa = new EditorialJpaController();
    LibroJpaController libroJpa = new LibroJpaController();

    //Métodos para el Autor

    public void crearAutor(Autor autor) {
        autorJpa.create(autor);
    }

    public void eliminarAutor(int id) {
        try {
            autorJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarAutor(Autor autor) {
        try {
            autorJpa.edit(autor);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void darDeBajaAutor(Autor autor) {
        try {
            autorJpa.edit(autor);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Autor traerAutor(int id) {

        return autorJpa.findAutor(id);
    }

    public Autor traerAutorPorNombre(String nombre) {

        Autor autor = autorJpa.findAutorByName(nombre);
        return autor;
    }

    public ArrayList<Autor> traerListaAutores() {
        
        List<Autor> listaA = autorJpa.findAutorEntities();
        ArrayList<Autor> listaAutores = new ArrayList<Autor>(listaA);
        return listaAutores;
    }

    //Métodos para Editorial

    public void crearEditorial (Editorial editorial) {
        editJpa.create(editorial);
    }

    public void eliminarEditorial(int id) {
        try {
            editJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarEditorial(Editorial editorial) {
        try {
            editJpa.edit(editorial);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void darDeBajaEditorial(Editorial editorial) {
        try {
            editJpa.edit(editorial);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    public Editorial traerEditorial(int id) {

        return editJpa.findEditorial(id);
    }

    public Editorial traerEditorialPorNombre(String nombre) {

        return editJpa.findEditorialByName(nombre);
    }

    public ArrayList<Editorial> traerListaEditoriales() {
        
        List<Editorial> listaE = editJpa.findEditorialEntities();
        ArrayList<Editorial> listaEditoriales = new ArrayList<Editorial>(listaE);
        return listaEditoriales;
    }

    // Métodos par los Libros

    public void crearLibro (Libro libro) {
        libroJpa.create(libro);
    }

    public void eliminarLibro(int id) {
        try {
            libroJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarLibro(Libro libro) {
        try {
            libroJpa.edit(libro);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void darDeBajaLibro(Libro libro) {
        try {
            libroJpa.edit(libro);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Libro traerLibro(long isbn) {

        return libroJpa.findLibro(isbn);
    }

    public Libro traerLibroPorTitulo(String titulo) {

        return libroJpa.findLibroByName(titulo);
    }

    public Libro traerLibroPorAutor(Autor autor) {

        return libroJpa.findLibroByAutor(autor);
    }

    public Libro traerLibroPorEditorial(Editorial editorial) {

        return libroJpa.findLibroByEditorial(editorial);
    }

    public ArrayList<Libro> traerListaLibros() {
        
        List<Libro> listaL = libroJpa.findLibroEntities();
        ArrayList<Libro> listaLibros = new ArrayList<Libro>(listaL);
        return listaLibros;
    }

}
