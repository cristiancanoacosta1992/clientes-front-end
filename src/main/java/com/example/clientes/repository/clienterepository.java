package com.example.clientes.repository;
import com.example.clientes.model.cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface clienterepository extends JpaRepository<cliente, Long> {
    // Aquí puedes agregar métodos personalizados si los necesitas
}

