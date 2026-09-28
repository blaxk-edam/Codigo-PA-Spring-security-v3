package com.reciclaje.proyectodeaula.model;

import jakarta.persistence.*;

@Entity
public class Residuo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;
    private String direccion;
    private String mapa;
    private String estado;
    private String creadoPor;
    private String recogidoPor;
    private String clasificadoPor;

    public Residuo() {
    }

    public Residuo(String nombre,
                   String descripcion,
                   String direccion,
                   String mapa,
                   String estado,
                   String creadoPor) {

        this.nombre = nombre;
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.mapa = mapa;
        this.estado = estado;
        this.creadoPor = creadoPor;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getMapa() {
        return mapa;
    }

    public void setMapa(String mapa) {
        this.mapa = mapa;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(String creadoPor) {
        this.creadoPor = creadoPor;
    }

    public String getRecogidoPor() {
        return recogidoPor;
    }

    public void setRecogidoPor(String recogidoPor) {
        this.recogidoPor = recogidoPor;
    }

    public String getClasificadoPor() {
        return clasificadoPor;
    }

    public void setClasificadoPor(String clasificadoPor) {
        this.clasificadoPor = clasificadoPor;
    }
}