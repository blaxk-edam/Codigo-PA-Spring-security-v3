package com.reciclaje.proyectodeaula.repository;

import com.reciclaje.proyectodeaula.model.VideoEducativo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoEducativoRepository
        extends JpaRepository<VideoEducativo, Long> {
}