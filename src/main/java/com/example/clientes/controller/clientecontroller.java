package com.example.clientes.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import  java.util.Optional;

import com.example.clientes.model.cliente;
import com.example.clientes.service.clienteservice;

@RestController
@RequestMapping("/api/clientes")
public class clientecontroller {
    private final clienteservice clienteservice;
    public clientecontroller(clienteservice clienteservice) {
        this.clienteservice = clienteservice;
    }
    @GetMapping
    public List<cliente> listarTodos() {
        return clienteservice.obtenerTodos();
    }
    @PutMapping("/{id}")
    public ResponseEntity<cliente> actualizarCliente(@PathVariable Long id,
                                                     @RequestBody cliente clienteActualizado) {
        Optional<cliente> clienteExistente =
                clienteservice.obtenerPorId(id);

        if (clienteExistente.isPresent()) {
            cliente cliente = clienteExistente.get();
            cliente.setNombre(clienteActualizado.getNombre());
            cliente.setApellido_materno(clienteActualizado.getApellido_materno());
            cliente.setApellido_paterno(clienteActualizado.getApellido_paterno());
            cliente.setEmail(clienteActualizado.getEmail());
            cliente.setDireccion(clienteActualizado.getDireccion());
            return ResponseEntity.ok(clienteservice.crear(cliente));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public cliente crear(@RequestBody cliente cliente) {
        return clienteservice.crear(cliente);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        clienteservice.eliminar(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<cliente> obtenerClientePorId(@PathVariable Long
                                                               id) {
        Optional<cliente> cliente = clienteservice.obtenerPorId(id);
        if (cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}