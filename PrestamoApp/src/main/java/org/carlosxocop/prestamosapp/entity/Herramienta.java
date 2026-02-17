package org.carlosxocop.prestamosapp.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Herramientas")
public class Herramienta {
    @Id
    @Column (name= "id_herramienta")
    private String id_herramienta;
    @Column
    private String nombreHerramienta;
    @Column
    private String descripcionHerramienta;
    @Column
    private boolean disponibilidad;
    @Column
    private int estado;

    public Herramienta(String id_herramienta) {
    }

    public Herramienta() {

    }

    public Herramienta(String id_herramienta, String nombreHerramienta, String descripcionHerramienta, boolean disponibilidad, int estado) {
        this.id_herramienta = id_herramienta;
        this.nombreHerramienta = nombreHerramienta;
        this.descripcionHerramienta = descripcionHerramienta;
        this.disponibilidad = disponibilidad;
        this.estado = estado;
    }

    public String getId_herramienta() {
        return id_herramienta;
    }

    public void setId_herramienta(String id_herramienta) {
        this.id_herramienta = id_herramienta;
    }

    public String getNombreHerramienta() {
        return nombreHerramienta;
    }

    public void setNombreHerramienta(String nombreHerramienta) {
        this.nombreHerramienta = nombreHerramienta;
    }

    public String getDescripcionHerramienta() {
        return descripcionHerramienta;
    }

    public void setDescripcionHerramienta(String descripcionHerramienta) {
        this.descripcionHerramienta = descripcionHerramienta;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
