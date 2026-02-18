package org.carlosxocop.prestamosapp.controller;


import org.carlosxocop.prestamosapp.entity.Cliente;
import org.carlosxocop.prestamosapp.repository.ClienteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteRepository repo;

    public ClienteController(ClienteRepository repo) {this.repo = repo; }

    @GetMapping
    public List<Cliente> listar() { return repo.findAll();}

    @PostMapping
    public Cliente guardar(@RequestBody Cliente c){ return repo.save(c);}

    @GetMapping("/{dpi}")
    public Cliente buscarPorDpi(@PathVariable String dpi){
        Cliente c = repo.findById(dpi).orElse(null);
        return c;
    }
}
