package org.carlosxocop.prestamosapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Clientes")
public class Cliente {
    @Id
    @Column(name="dpi_cliente")
    private String dpi_Clientes;
    @Column
    private String nombreClientes;
    @Column
    private String apellidoClientes;
    @Column
    private String emailClientes;
    @Column
    private String telefonoClientes;
    @Column
    private String direccionClientes;
    @Column
    private String estadoClientes;
    @Column
    private int estado;


    public Cliente(String id_cliente){
    }

    public Cliente(){

    }

    public Cliente(String dpi_Clientes, String nombreClientes, String apellidoClientes, String emailClientes, String telefonoClientes, String direccionClientes, String estadoClientes, int estado) {
        this.dpi_Clientes = dpi_Clientes;
        this.nombreClientes = nombreClientes;
        this.apellidoClientes = apellidoClientes;
        this.emailClientes = emailClientes;
        this.telefonoClientes = telefonoClientes;
        this.direccionClientes = direccionClientes;
        this.estadoClientes = estadoClientes;
        this.estado = estado;
    }

    public String getDpi_Clientes() {
        return dpi_Clientes;
    }

    public void setDpi_Clientes(String dpi_Clientes) {
        this.dpi_Clientes = dpi_Clientes;
    }

    public String getNombreClientes() {
        return nombreClientes;
    }

    public void setNombreClientes(String nombreClientes) {
        this.nombreClientes = nombreClientes;
    }

    public String getApellidoClientes() {
        return apellidoClientes;
    }

    public void setApellidoClientes(String apellidoClientes) {
        this.apellidoClientes = apellidoClientes;
    }

    public String getEmailClientes() {
        return emailClientes;
    }

    public void setEmailClientes(String emailClientes) {
        this.emailClientes = emailClientes;
    }

    public String getTelefonoClientes() {
        return telefonoClientes;
    }

    public void setTelefonoClientes(String telefonoClientes) {
        this.telefonoClientes = telefonoClientes;
    }

    public String getDireccionClientes() {
        return direccionClientes;
    }

    public void setDireccionClientes(String direccionClientes) {
        this.direccionClientes = direccionClientes;
    }

    public String getEstadoClientes() {
        return estadoClientes;
    }

    public void setEstadoClientes(String estadoClientes) {
        this.estadoClientes = estadoClientes;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
