package principal.logica;

import java.util.LinkedList;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Carrera {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Basic
    private String nombre;
    @OneToMany (mappedBy="carre")
    private LinkedList<Materia> listaMaterias;

    public Carrera() {
    }

    public Carrera(int id, String nombre, LinkedList<Materia> listaMaterias) {
        this.id = id;
        this.nombre = nombre;
        this.listaMaterias = listaMaterias;
    }
    


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LinkedList<Materia> getListaMaterias() {
        return listaMaterias;
    }

    public void setListaMaterias(LinkedList<Materia> listaMaterias) {
        this.listaMaterias = listaMaterias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Carrera{" + "id=" + id + ", nombre=" + nombre + '}';
    }
    
}
