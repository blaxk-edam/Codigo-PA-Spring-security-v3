package com.reciclaje.proyectodeaula.controller;

import com.reciclaje.proyectodeaula.repository.PuntoReciclajeRepository;
import com.reciclaje.proyectodeaula.repository.SolicitudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AcopioController {

    @Autowired
    private SolicitudRepository solicitudRepository;

    @Autowired
    private PuntoReciclajeRepository puntoRepository;

    @GetMapping("/acopio")
    public String acopio(Model model) {

        model.addAttribute("solicitudes",
                solicitudRepository.findAll());

        model.addAttribute("puntos",
                puntoRepository.findAll());

        return "acopio";
    }
}