package com.example.clientes.model;

import  jakarta.persistence.Entity;
import  jakarta.persistence.Id;
import  jakarta.persistence.GeneratedValue;
import  jakarta.persistence.GenerationType;
import  com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "id", "nombre", "apellido_materno", "apellido_paterno","email","direccion" })
@Entity

public class cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido_materno;
    private String apellido_paterno;
    private String email;
    private String direccion;


    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido_materno() { return apellido_materno; }
    public void setApellido_materno(String apellido_materno) { this.apellido_materno = apellido_materno; }

    public String getApellido_paterno() { return apellido_paterno; }
    public void setApellido_paterno(String apellido_paterno) { this.apellido_paterno= apellido_paterno; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email= email; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }


}