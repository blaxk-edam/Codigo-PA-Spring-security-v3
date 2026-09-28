package com.reciclaje.proyectodeaula.controller;

import com.reciclaje.proyectodeaula.model.Usuario;
import com.reciclaje.proyectodeaula.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @GetMapping
    public List<Usuario> listar() {
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(org.springframework.http.HttpStatus.FORBIDDEN)
    public Usuario guardar(
            @RequestBody Usuario usuario) {

        return repository.save(usuario);
    }
}