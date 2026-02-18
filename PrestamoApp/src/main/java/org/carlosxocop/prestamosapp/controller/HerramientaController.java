package org.carlosxocop.prestamosapp.controller;


import org.carlosxocop.prestamosapp.entity.Herramienta;
import org.carlosxocop.prestamosapp.repository.HerramientaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/herramientas")
public class HerramientaController {
    private final HerramientaRepository repo;

    public HerramientaController(HerramientaRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Herramienta> listar() {
        return repo.findAll();
    }

    @PostMapping
    public Herramienta guardar(@RequestBody Herramienta h){
        return repo.save(h);
    }

    @GetMapping("/{id}")
    public Herramienta buscarPorId(@PathVariable String id) {
        Herramienta h = repo.findById(id).orElse(null);
        return h;
    }

    @PutMapping("/{id}")
    public Herramienta actualizar(@PathVariable String id , @RequestBody Herramienta h){
        Herramienta herramienta = repo.findById(id).orElse(null);
        herramienta.setNombreHerramienta(h.getNombreHerramienta());
        herramienta.setDescripcionHerramienta(h.getDescripcionHerramienta());
        herramienta.setDisponibilidad(h.isDisponibilidad());
        herramienta.setEstado(h.getEstado());

        return repo.save(herramienta);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable String id){
        repo.deleteById(id);
    }
}
