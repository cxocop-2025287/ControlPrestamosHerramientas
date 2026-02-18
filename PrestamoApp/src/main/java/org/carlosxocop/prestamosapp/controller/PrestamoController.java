package org.carlosxocop.prestamosapp.controller;

import org.carlosxocop.prestamosapp.entity.Prestamo;
import org.carlosxocop.prestamosapp.entity.Herramienta;
import org.carlosxocop.prestamosapp.repository.PrestamoRepository;
import org.carlosxocop.prestamosapp.repository.HerramientaRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/prestamos")
public class PrestamoController {

    private final PrestamoRepository prestamoRepo;
    private final HerramientaRepository herramientaRepo;

    public PrestamoController(PrestamoRepository prestamoRepo, HerramientaRepository herramientaRepo) {
        this.prestamoRepo = prestamoRepo;
        this.herramientaRepo = herramientaRepo;
    }

    // Listar todos los préstamos
    @GetMapping
    public List<Prestamo> listarTodos() {
        return prestamoRepo.findAll();
    }

    // Buscar préstamo por ID
    @GetMapping("/{id}")
    public ResponseEntity<Prestamo> buscarPorId(@PathVariable Long id) {
        Prestamo prestamo = prestamoRepo.findById(id).orElse(null);
        if (prestamo == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(prestamo);
    }

    @PostMapping
    public Prestamo crearPrestamo(@RequestBody Prestamo prestamo) {
        return prestamoRepo.save(prestamo);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPrestamo(@PathVariable Long id) {
        try {
            Prestamo prestamo = prestamoRepo.findById(id).orElse(null);
            if (prestamo == null) {
                return ResponseEntity.notFound().build();
            }


            prestamoRepo.deleteById(id);

            Map<String, String> response = new HashMap<>();
            response.put("mensaje", "Préstamo eliminado exitosamente");
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "Error al eliminar: " + e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }
    }

    // Listar préstamos por herramienta
    @GetMapping("/herramienta/{herramienta}")
    public List<Prestamo> listarPorHerramienta(@PathVariable String herramienta) {
        return prestamoRepo.findByHerramienta(herramienta);
    }



    @GetMapping("/buscar")
    public List<Prestamo> buscarPorNombre(@RequestParam String nombre) {

        return prestamoRepo.findByNombrePrestatarioContainingIgnoreCase(nombre);
    }


    @GetMapping("/activos")
    public List<Prestamo> listarActivos() {
        return prestamoRepo.findByFechaDevolucionGreaterThanEqual(LocalDate.now());
    }

    @GetMapping("/vencidos")
    public List<Prestamo> listarVencidos() {
        return prestamoRepo.findByFechaDevolucionLessThan(LocalDate.now());
    }

    @GetMapping("/estadisticas")
    public Map<String, Object> obtenerEstadisticas() {
        List<Prestamo> todos = prestamoRepo.findAll();
        long activos = todos.stream()
                .filter(p -> p.getFechaDevolucion() != null &&
                        p.getFechaDevolucion().isAfter(LocalDate.now()))
                .count();
        long vencidos = todos.stream()
                .filter(p -> p.getFechaDevolucion() != null &&
                        p.getFechaDevolucion().isBefore(LocalDate.now()))
                .count();

        Map<String, Object> stats = new HashMap<>();
        stats.put("totalPrestamos", todos.size());
        stats.put("prestamosActivos", activos);
        stats.put("prestamosVencidos", vencidos);

        return stats;
    }
}