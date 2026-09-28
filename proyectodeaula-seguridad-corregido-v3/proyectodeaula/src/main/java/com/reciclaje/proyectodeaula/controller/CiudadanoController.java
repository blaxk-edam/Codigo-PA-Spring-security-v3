package com.reciclaje.proyectodeaula.controller;

import com.reciclaje.proyectodeaula.model.PuntoReciclaje;
import com.reciclaje.proyectodeaula.model.Solicitud;
import com.reciclaje.proyectodeaula.model.Usuario;
import com.reciclaje.proyectodeaula.repository.PuntoReciclajeRepository;
import com.reciclaje.proyectodeaula.repository.SolicitudRepository;
import com.reciclaje.proyectodeaula.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Controller
public class CiudadanoController {

    @Autowired
    private PuntoReciclajeRepository puntoRepository;

    @Autowired
    private SolicitudRepository solicitudRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/ciudadano")
    public String dashboard(
            Model model,
            Authentication authentication) {

        List<PuntoReciclaje> puntos =
                puntoRepository.findAll();

        String usuarioLogin =
                authentication.getName();

        Set<String> nombresPosibles =
                new LinkedHashSet<>();

        nombresPosibles.add(usuarioLogin);

        Usuario usuario =
                usuarioRepository.findByUsuario(usuarioLogin)
                        .orElse(null);

        if (usuario != null &&
                usuario.getNombre() != null) {

            nombresPosibles.add(
                    usuario.getNombre()
            );
        }

        List<Solicitud> historial =
                solicitudRepository.findByCiudadanoNombreIn(
                        new ArrayList<>(nombresPosibles)
                );

        model.addAttribute("puntos", puntos);

        model.addAttribute("historial", historial);

        return "ciudadano";
    }

    @PostMapping("/crear-solicitud")
    public String crearSolicitud(
            @RequestParam String descripcion,
            @RequestParam String direccionMaps,
            Authentication authentication) {

        Solicitud solicitud =
                new Solicitud();

        solicitud.setDescripcion(
                descripcion
        );

        solicitud.setDireccionMaps(
                direccionMaps
        );

        solicitud.setEstado(
                "PENDIENTE"
        );

        solicitud.setFechaSolicitud(
                LocalDateTime.now()
        );


        solicitud.setCiudadanoNombre(
                authentication.getName()
        );

        solicitudRepository.save(
                solicitud
        );

        return "redirect:/ciudadano";
    }
}