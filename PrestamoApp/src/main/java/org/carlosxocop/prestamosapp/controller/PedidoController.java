package org.carlosxocop.prestamosapp.controller;

import org.carlosxocop.prestamosapp.entity.Pedido;
import org.carlosxocop.prestamosapp.repository.ClienteRepository;
import org.carlosxocop.prestamosapp.repository.PedidoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoRepository pedidoRepo;
    public PedidoController(PedidoRepository pedidoRepo, ClienteRepository clienteRepo) {
        this.pedidoRepo = pedidoRepo;
    }

    
    @GetMapping
    public List<Pedido> listar() {
        return pedidoRepo.findAll();
    }

    
    @GetMapping("/{id}")
    public Pedido buscarPorId(@PathVariable Long id) {
        return pedidoRepo.findById(id).orElse(null);
    }

    
    @GetMapping("/cliente/{dpi}")
    public List<Pedido> buscarPorCliente(@PathVariable String dpi) {
        return pedidoRepo.findByClienteDpi(dpi);
    }

    
    @PostMapping
    public Pedido guardar(@RequestBody Pedido pedido) {
        return pedidoRepo.save(pedido);
    }

    
    @PutMapping("/{id}")
    public Pedido actualizar(@PathVariable Long id, @RequestBody Pedido pedidoNuevo) {
        Pedido pedido = pedidoRepo.findById(id).orElse(null);
        if (pedido == null) return null;

        pedido.setFechaPedido(pedidoNuevo.getFechaPedido());
        pedido.setEstado(pedidoNuevo.getEstado());
        pedido.setTotal(pedidoNuevo.getTotal());
        pedido.setCliente(pedidoNuevo.getCliente());

        return pedidoRepo.save(pedido);
    }

    
    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        pedidoRepo.deleteById(id);
        return "Pedido eliminado correctamente";
    }
}