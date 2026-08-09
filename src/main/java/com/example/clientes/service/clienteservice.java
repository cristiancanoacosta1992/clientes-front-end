package com.example.clientes.service;

import com.example.clientes.model.cliente;
import com.example.clientes.repository.clienterepository;
import org.springframework.stereotype.Service;

import  java.util.List;
import java.util.Optional;

@Service

public class clienteservice {
    private final clienterepository clienterepository;

    public clienteservice(clienterepository clienterepository) {
        this.clienterepository = clienterepository;
    }
    public List<cliente> obtenerTodos() {
        return clienterepository.findAll();
    }
    public Optional<cliente> obtenerPorId(Long id) {
        return clienterepository.findById(id);
    }
    public cliente crear(cliente cliente) {
        return clienterepository.save(cliente);
    }
    public void eliminar(Long id) {
        clienterepository.deleteById(id);
    }
}