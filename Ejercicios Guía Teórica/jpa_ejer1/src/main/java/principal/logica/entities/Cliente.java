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
    @Basic
    private int totalPrestamos;
    @Basic
    private int prestamosPorDevolver;
    @Basic
    private int prestamosDevueltos;
    @Basic
    private int prestamosDevueltosEnTiempo;
    @Basic
    private int prestamosDevueltosFueraDeTiempo;
    @Basic
    private int score;

    public Cliente() {
    }

    public Cliente(long documento, String nombre, String apellido, String telefono, ArrayList<Prestamo> prestamos) {
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.prestamos = prestamos;
        this.totalPrestamos = 0;
        this.prestamosPorDevolver = 0;
        this.prestamosDevueltos = 0;
        this.prestamosDevueltosEnTiempo = 0;
        this.prestamosDevueltosFueraDeTiempo = 0;
        this.score = 3;
    }

    public Cliente(int id, long documento, String nombre, String apellido, String telefono, ArrayList<Prestamo> prestamos, int totalPrestamos, int prestamosPorDevolver, int prestamosDevueltos, int prestamosDevueltosEnTiempo, int prestamosDevueltosFueraDeTiempo, int score) {
        this.id = id;
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.prestamos = prestamos;
        this.totalPrestamos = totalPrestamos;
        this.prestamosPorDevolver = prestamosPorDevolver;
        this.prestamosDevueltos = prestamosDevueltos;
        this.prestamosDevueltosEnTiempo = prestamosDevueltosEnTiempo;
        this.prestamosDevueltosFueraDeTiempo = prestamosDevueltosFueraDeTiempo;
        this.score = score;
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

    public int getTotalPrestamos() {
        return this.totalPrestamos;
    }

    public void setTotalPrestamos(int totalPrestamos) {
        this.totalPrestamos = totalPrestamos;
    }

    public int getPrestamosPorDevolver() {
        return this.prestamosPorDevolver;
    }

    public void setPrestamosPorDevolver(int prestamosPorDevolver) {
        this.prestamosPorDevolver = prestamosPorDevolver;
    }

    public int getPrestamosDevueltos() {
        return this.prestamosDevueltos;
    }

    public void setPrestamosDevueltos(int prestamosDevueltos) {
        this.prestamosDevueltos = prestamosDevueltos;
    }

    public int getPrestamosDevueltosEnTiempo() {
        return this.prestamosDevueltosEnTiempo;
    }

    public void setPrestamosDevueltosEnTiempo(int prestamosDevueltosEnTiempo) {
        this.prestamosDevueltosEnTiempo = prestamosDevueltosEnTiempo;
    }

    public int getPrestamosDevueltosFueraDeTiempo() {
        return this.prestamosDevueltosFueraDeTiempo;
    }

    public void setPrestamosDevueltosFueraDeTiempo(int prestamosDevueltosFueraDeTiempo) {
        this.prestamosDevueltosFueraDeTiempo = prestamosDevueltosFueraDeTiempo;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Cliente [" +
            " Id = " + getId() +
            ", Documento = " + getDocumento() +
            ", Nombre = " + getNombre() +
            ", Apellido = " + getApellido() +
            ", Teléfono = " + getTelefono() + 
            " \n Total de Prestamos = " + getTotalPrestamos() +
            " \n Total de Prestamos Devueltos = " + getPrestamosDevueltos() +
            " \n Total de Prestamos Devueltos en Tiempo = " + getPrestamosDevueltosEnTiempo() + 
            " \n Total de Prestamos Devutlos Fuera de Tiempo = " + getPrestamosDevueltosFueraDeTiempo() +
            " \n Total de Prestamos por Devolver = " + getPrestamosPorDevolver() + 
            " \n " + getPrestamos().toString() +
            " \n Score del Cliente = " + getScore() + " ]";
    }

}
