package com.reciclaje.proyectodeaula.repository;

import com.reciclaje.proyectodeaula.model.Residuo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResiduoRepository
        extends JpaRepository<Residuo, Long> {

    List<Residuo> findByCreadoPor(
            String creadoPor
    );

    List<Residuo> findByRecogidoPor(
            String recogidoPor
    );
}