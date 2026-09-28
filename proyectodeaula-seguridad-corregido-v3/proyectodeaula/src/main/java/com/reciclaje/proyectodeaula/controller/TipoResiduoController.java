package com.reciclaje.proyectodeaula.controller;

import com.reciclaje.proyectodeaula.model.TipoResiduo;
import com.reciclaje.proyectodeaula.repository.TipoResiduoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class TipoResiduoController {

    @Autowired
    private TipoResiduoRepository repository;

    @GetMapping("/api/tipos")
    public List<TipoResiduo> listar() {

        return repository.findAll();
    }

    @PostMapping("/api/tipos")
    public TipoResiduo guardar(
            @RequestBody TipoResiduo residuo) {

        return repository.save(residuo);
    }
}