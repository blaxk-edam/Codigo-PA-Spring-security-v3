package com.reciclaje.proyectodeaula.controller;

import com.reciclaje.proyectodeaula.model.Solicitud;
import com.reciclaje.proyectodeaula.repository.SolicitudRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RecicladorController {

    @Autowired
    private SolicitudRepository solicitudRepository;

    @GetMapping("/reciclador")
    public String reciclador(Model model) {

        model.addAttribute(
                "solicitudes",
                solicitudRepository.findByEstado(
                        "PENDIENTE"
                )
        );

        return "reciclador";
    }

    @GetMapping("/completar/{id}")
    public String completar(
            @PathVariable Long id) {

        Solicitud solicitud =
                solicitudRepository.findById(id)
                        .orElse(null);

        if (solicitud != null &&
                "PENDIENTE".equals(
                        solicitud.getEstado()
                )) {

            solicitud.setEstado(
                    "RECOGIDO"
            );

            solicitudRepository.save(
                    solicitud
            );
        }

        return "redirect:/reciclador";
    }
}