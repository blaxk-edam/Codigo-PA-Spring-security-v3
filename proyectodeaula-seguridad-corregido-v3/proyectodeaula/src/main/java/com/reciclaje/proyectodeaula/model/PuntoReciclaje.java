package com.reciclaje.proyectodeaula.model;

import jakarta.persistence.*;

@Entity
@Table(name = "punto_reciclaje")
public class PuntoReciclaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String direccion;

    private String horario;

    public PuntoReciclaje() {
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getHorario() {
        return horario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}