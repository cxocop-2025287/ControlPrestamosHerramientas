package org.carlosxocop.prestamosapp.repository;

import org.carlosxocop.prestamosapp.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Query("SELECT p FROM Pedido p WHERE p.cliente.dpi_Clientes = :dpi")
    List<Pedido> findByClienteDpi(@Param("dpi") String dpi);
}