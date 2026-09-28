package com.reciclaje.proyectodeaula.controller;

import com.reciclaje.proyectodeaula.model.Usuario;
import com.reciclaje.proyectodeaula.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class LoginController {

    private static final List<String> ROLES_PERMITIDOS = List.of("CIUDADANO", "RECICLADOR", "ACOPIO");

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/registro")
    public String registroPage() {
        return "registro";
    }

    @PostMapping("/registrar")
    public String registrar(
            @RequestParam String nombre,
            @RequestParam String usuario,
            @RequestParam String password,
            @RequestParam String rol,
            Model model,
            RedirectAttributes redirectAttributes
    ) {

        if (!ROLES_PERMITIDOS.contains(rol)) {
            model.addAttribute("error", "Rol no válido");
            return "registro";
        }

        if (usuarioRepository.findByUsuario(usuario).isPresent()) {
            model.addAttribute("error", "Ese usuario ya existe");
            return "registro";
        }

        Usuario u = new Usuario();
        u.setNombre(nombre);
        u.setUsuario(usuario);
        u.setPassword(passwordEncoder.encode(password));
        u.setRol(rol);

        usuarioRepository.save(u);

        redirectAttributes.addFlashAttribute("registroExitoso", "Usuario registrado correctamente. Ya puedes iniciar sesión.");
        return "redirect:/";
    }


    @GetMapping("/error-403")
    public String error403() {
        return "error-403";
    }
}
