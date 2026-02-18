package org.carlosxocop.prestamosapp.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Long idPedido;

    @Column(name = "fecha_pedido")
    private LocalDate fechaPedido;

    @Column(name = "estado")
    private String estado;

    @Column(name = "total")
    private double total;

    @ManyToOne
    @JoinColumn(name = "dpi_cliente", referencedColumnName = "dpi_cliente")
    private Cliente cliente;

    public Pedido() {}

    public Pedido(LocalDate fechaPedido, String estado, double total, Cliente cliente) {
        this.fechaPedido = fechaPedido;
        this.estado = estado;
        this.total = total;
        this.cliente = cliente;
    }

    public Long getIdPedido() { return idPedido; }
    public void setIdPedido(Long idPedido) { this.idPedido = idPedido; }

    public LocalDate getFechaPedido() { return fechaPedido; }
    public void setFechaPedido(LocalDate fechaPedido) { this.fechaPedido = fechaPedido; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
}