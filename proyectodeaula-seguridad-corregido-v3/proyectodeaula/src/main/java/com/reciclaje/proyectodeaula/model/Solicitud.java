package com.reciclaje.proyectodeaula.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "solicitud")
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "fecha_solicitud")
    private LocalDateTime fechaSolicitud;

    @Column(name = "estado")
    private String estado;

    @Column(name = "ciudadano_nombre")
    private String ciudadanoNombre;

    @Column(name = "direccion_maps", columnDefinition = "TEXT")
    private String direccionMaps;

    public Solicitud() {
    }

    public Long getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public LocalDateTime getFechaSolicitud() {
        return fechaSolicitud;
    }

    public String getEstado() {
        return estado;
    }

    public String getCiudadanoNombre() {
        return ciudadanoNombre;
    }

    public String getDireccionMaps() {
        return direccionMaps;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFechaSolicitud(LocalDateTime fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCiudadanoNombre(String ciudadanoNombre) {
        this.ciudadanoNombre = ciudadanoNombre;
    }

    public void setDireccionMaps(String direccionMaps) {
        this.direccionMaps = direccionMaps;
    }
}