package principal.logica.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Prestamo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Temporal(TemporalType.DATE)
    private Date fechaPrestamo;
    @Temporal(TemporalType.DATE)
    private Date fechaFDevolucion;
    @OneToOne
    private Libro libro;
    @ManyToOne
    private Cliente cliente;


    public Prestamo() {
    }

    public Prestamo(Date fechaPrestamo, Date fechaFDevolucion, Libro libro, Cliente cliente) {
        this.fechaPrestamo = fechaPrestamo;
        this.fechaFDevolucion = fechaFDevolucion;
        this.libro = libro;
        this.cliente = cliente;
    }

    public Prestamo(int id, Date fechaPrestamo, Date fechaFDevolucion, Libro libro, Cliente cliente) {
        this.id = id;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaFDevolucion = fechaFDevolucion;
        this.libro = libro;
        this.cliente = cliente;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaPrestamo() {
        return this.fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaFDevolucion() {
        return this.fechaFDevolucion;
    }

    public void setFechaFDevolucion(Date fechaFDevolucion) {
        this.fechaFDevolucion = fechaFDevolucion;
    }

    public Libro getLibro() {
        return this.libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return "Préstamo [" +
            " Id = " + getId() +
            ", Fecha de Prestamo = " + dateFormat.format(getFechaPrestamo()) +
            ", Fecha de FDevolución = " + dateFormat.format(getFechaFDevolucion()) + 
            ", Títlo del Libro = " + getLibro().getTitulo() + 
            ", Nombre del Cliente = " + getCliente().getNombre() + " ]";
    }


}
