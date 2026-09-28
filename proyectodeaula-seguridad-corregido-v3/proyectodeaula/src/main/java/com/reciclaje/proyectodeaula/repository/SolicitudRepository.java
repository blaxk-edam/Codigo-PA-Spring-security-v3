package com.reciclaje.proyectodeaula.repository;

import com.reciclaje.proyectodeaula.model.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SolicitudRepository
        extends JpaRepository<Solicitud, Long> {

    List<Solicitud> findByCiudadanoNombre(
            String ciudadanoNombre
    );

    List<Solicitud> findByCiudadanoNombreIn(
            List<String> ciudadanos
    );

    List<Solicitud> findByEstado(
            String estado
    );
}