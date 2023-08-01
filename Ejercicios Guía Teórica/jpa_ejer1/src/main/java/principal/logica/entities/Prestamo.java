package principal.logica.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Basic;
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
    @Temporal(TemporalType.DATE)
    private Date fechaFDevolucionReal;
    @OneToOne
    private Libro libro;
    @ManyToOne
    private Cliente cliente;
    @Basic
    private String estatus;


    public Prestamo() {
    }

    public Prestamo(Date fechaPrestamo, Date fechaFDevolucion, Libro libro, Cliente cliente) {
        this.fechaPrestamo = fechaPrestamo;
        this.fechaFDevolucion = fechaFDevolucion;
        this.libro = libro;
        this.cliente = cliente;
        this.estatus = "Por Devolver";
        this.fechaFDevolucionReal = null;
    }



    public Prestamo(int id, Date fechaPrestamo, Date fechaFDevolucion, Date fechaFDevolucionReal, Libro libro, Cliente cliente, String estatus) {
        this.id = id;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaFDevolucion = fechaFDevolucion;
        this.fechaFDevolucionReal = fechaFDevolucionReal;
        this.libro = libro;
        this.cliente = cliente;
        this.estatus = estatus;
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

    public Date getFechaFDevolucionReal() {
        return this.fechaFDevolucionReal;
    }

    public void setFechaFDevolucionReal(Date fechaFDevolucionReal) {
        this.fechaFDevolucionReal = fechaFDevolucionReal;
    }

    public String getEstatus() {
        return this.estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return "Préstamo [" +
            " Id = " + getId() +
            ", Fecha de Prestamo = " + dateFormat.format(getFechaPrestamo()) +
            ", Fecha de FDevolución = " + dateFormat.format(getFechaFDevolucion()) + 
            ", Títlo del Libro = " + getLibro().getTitulo() + 
            ", Nombre del Cliente = " + getCliente().getNombre() + 
            ", Estatus = " + getEstatus() + 
            ", Fecha de Devolución Real = " + getFechaFDevolucionReal() + " ]";
    }


}
