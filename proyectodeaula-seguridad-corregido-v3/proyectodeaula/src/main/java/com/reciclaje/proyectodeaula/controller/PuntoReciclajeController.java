package com.reciclaje.proyectodeaula.controller;

import com.reciclaje.proyectodeaula.model.PuntoReciclaje;
import com.reciclaje.proyectodeaula.repository.PuntoReciclajeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/puntos")
public class PuntoReciclajeController {

    @Autowired
    private PuntoReciclajeRepository repository;

    @GetMapping
    public List<PuntoReciclaje> listar() {
        return repository.findAll();
    }

    @PostMapping
    public PuntoReciclaje guardar(
            @RequestBody PuntoReciclaje punto) {

        return repository.save(punto);
    }
}