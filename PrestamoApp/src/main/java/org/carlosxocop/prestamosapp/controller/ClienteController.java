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

    @PutMapping("/{dpi}")
    public Cliente actualizar(@PathVariable String dpi, @RequestBody Cliente c) {

        Cliente cliente = repo.findById(dpi).orElse(null);

        cliente.setNombreClientes(c.getNombreClientes());
        cliente.setApellidoClientes(c.getApellidoClientes());
        cliente.setEmailClientes(c.getEmailClientes());
        cliente.setTelefonoClientes(c.getTelefonoClientes());
        cliente.setDireccionClientes(c.getDireccionClientes());
        cliente.setEstadoClientes(c.getEstadoClientes());
        cliente.setEstado(c.getEstado());

        return repo.save(cliente);
    }

    @DeleteMapping("/{dpi}")
    public void eliminar(@PathVariable String dpi) {
        repo.deleteById(dpi);
    }

}
