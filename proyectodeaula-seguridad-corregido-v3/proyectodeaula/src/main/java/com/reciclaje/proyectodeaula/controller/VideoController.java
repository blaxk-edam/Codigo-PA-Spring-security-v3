package com.reciclaje.proyectodeaula.controller;

import com.reciclaje.proyectodeaula.model.VideoEducativo;
import com.reciclaje.proyectodeaula.repository.VideoEducativoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/videos")
public class VideoController {

    @Autowired
    private VideoEducativoRepository repository;

    @GetMapping
    public List<VideoEducativo> listar() {
        return repository.findAll();
    }

    @PostMapping
    public VideoEducativo guardar(
            @RequestBody VideoEducativo video) {

        return repository.save(video);
    }
}