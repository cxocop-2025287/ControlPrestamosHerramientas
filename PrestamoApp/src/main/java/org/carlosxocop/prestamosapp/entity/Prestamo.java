package org.carlosxocop.prestamosapp.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Prestamos")
public class Prestamo {

    @Id
    @Column(name = "id_prestamo")
    private Long idPrestamo;


    @Column(name = "herramienta")
    private String herramienta;

    @Column(name = "nombre_prestatario")
    private String nombrePrestatario;

    @Column(name = "fecha_prestamo")
    private LocalDateTime fechaPrestamo;


    @Column(name = "fecha_devolucion")
    private LocalDate fechaDevolucion;

    @Column(name = "cantidad_prestada", nullable = false)
    private Integer cantidadPrestada = 1;

    public Prestamo() {
    }

    public Prestamo(String herramienta, String nombrePrestatario, LocalDate fechaDevolucion) {
        this.herramienta = herramienta;
        this.nombrePrestatario = nombrePrestatario;
        this.fechaDevolucion = fechaDevolucion;
        this.fechaPrestamo = LocalDateTime.now();
    }

    public Long getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(Long idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public String getHerramienta() {
        return herramienta;
    }

    public void setHerramienta(String herramienta) {
        this.herramienta = herramienta;
    }

    public String getNombrePrestatario() {
        return nombrePrestatario;
    }

    public void setNombrePrestatario(String nombrePrestatario) {
        this.nombrePrestatario = nombrePrestatario;
    }

    public LocalDateTime getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDateTime fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }


    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

}