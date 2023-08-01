package principal.logica.entities;

import java.util.ArrayList;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Basic
    private long documento;
    @Basic
    private String nombre;
    @Basic
    private String apellido;
    @Basic
    private String telefono;
    @OneToMany(mappedBy = "cliente")
    private ArrayList<Prestamo> prestamos;


    public Cliente() {
    }

    public Cliente(long documento, String nombre, String apellido, String telefono, ArrayList<Prestamo> prestamos) {
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.prestamos = prestamos;
    }


    public Cliente(int id, long documento, String nombre, String apellido, String telefono, ArrayList<Prestamo> prestamos) {
        this.id = id;
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.prestamos = prestamos;
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getDocumento() {
        return this.documento;
    }

    public void setDocumento(long documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public ArrayList<Prestamo> getPrestamos() {
        return this.prestamos;
    }

    public void setPrestamos(ArrayList<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    @Override
    public String toString() {
        return "Cliente [" +
            " Id = " + getId() +
            ", Documento = " + getDocumento() +
            ", Nombre = " + getNombre() +
            ", Apellido = " + getApellido() +
            ", Teléfono = " + getTelefono() + 
            " \n " + getPrestamos().toString() + " ]";
    }

}
