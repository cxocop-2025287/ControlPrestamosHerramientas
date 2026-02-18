package org.carlosxocop.prestamosapp.repository;

import org.carlosxocop.prestamosapp.entity.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {

    List<Prestamo> findByHerramientaId_herramienta(String idHerramienta);


    List<Prestamo> findByNombrePrestatarioContainingIgnoreCase(String nombre);


    List<Prestamo> findByFechaDevolucionGreaterThanEqual(LocalDate fecha);


    List<Prestamo> findByFechaDevolucionLessThan(LocalDate fecha);


    List<Prestamo> findByFechaPrestamoBetween(LocalDate fechaInicio, LocalDate fechaFin);
}