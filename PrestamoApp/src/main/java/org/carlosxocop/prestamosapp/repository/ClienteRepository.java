package org.carlosxocop.prestamosapp.repository;

import org.carlosxocop.prestamosapp.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, String> {
}
