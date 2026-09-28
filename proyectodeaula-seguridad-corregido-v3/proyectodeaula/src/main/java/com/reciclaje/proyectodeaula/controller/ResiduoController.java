package com.reciclaje.proyectodeaula.controller;

import com.reciclaje.proyectodeaula.model.Residuo;
import com.reciclaje.proyectodeaula.repository.ResiduoRepository;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/residuos")
@CrossOrigin(origins = "*")
public class ResiduoController {

    private final ResiduoRepository repository;

    public ResiduoController(
            ResiduoRepository repository) {

        this.repository = repository;
    }

    @GetMapping
    public List<Residuo> listar() {

        return repository.findAll();
    }

    @GetMapping("/mios")
    public List<Residuo> misResiduos(
            Authentication authentication) {

        return repository.findByCreadoPor(
                authentication.getName()
        );
    }

    @GetMapping("/recogidos")
    public List<Residuo> recogidos(
            Authentication authentication) {

        return repository.findByRecogidoPor(
                authentication.getName()
        );
    }

    @PostMapping
    public Residuo guardar(
            @RequestBody Residuo residuo,
            Authentication authentication) {


        residuo.setCreadoPor(
                authentication.getName()
        );

        residuo.setEstado(
                "PENDIENTE"
        );

        return repository.save(
                residuo
        );
    }

    @PutMapping("/recoger/{id}")
    public Residuo recoger(
            @PathVariable Long id,
            Authentication authentication) {

        Residuo residuo =
                repository.findById(id)
                        .orElse(null);

        if (residuo != null &&
                !"EJEMPLO".equals(
                        residuo.getEstado()
                )) {

            residuo.setEstado(
                    "RECOGIDO"
            );

            residuo.setRecogidoPor(
                    authentication.getName()
            );

            repository.save(
                    residuo
            );
        }

        return residuo;
    }

    @PutMapping("/clasificar/{id}")
    public Residuo clasificar(
            @PathVariable Long id,
            Authentication authentication) {

        Residuo residuo =
                repository.findById(id)
                        .orElse(null);

        if (residuo != null) {

            residuo.setEstado(
                    "CLASIFICADO"
            );

            residuo.setClasificadoPor(
                    authentication.getName()
            );

            repository.save(
                    residuo
            );
        }

        return residuo;
    }

    @DeleteMapping("/{id}")
    public void eliminar(
            @PathVariable Long id) {

        repository.deleteById(id);
    }
}