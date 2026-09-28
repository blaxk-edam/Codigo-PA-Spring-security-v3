package com.reciclaje.proyectodeaula.config;

import com.reciclaje.proyectodeaula.model.Residuo;
import com.reciclaje.proyectodeaula.model.Usuario;
import com.reciclaje.proyectodeaula.repository.ResiduoRepository;
import com.reciclaje.proyectodeaula.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner cargarUsuarios(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {

        return args -> {
            crearOActualizarUsuario(usuarioRepository, passwordEncoder,
                    "Carlos Ciudadano", "ciudadano", "123456", "CIUDADANO");
            crearOActualizarUsuario(usuarioRepository, passwordEncoder,
                    "Rita Recicladora", "reciclador", "123456", "RECICLADOR");
            crearOActualizarUsuario(usuarioRepository, passwordEncoder,
                    "Andrés Acopio", "acopio", "123456", "ACOPIO");
        };
    }

    private void crearOActualizarUsuario(UsuarioRepository usuarioRepository,
                                         PasswordEncoder passwordEncoder,
                                         String nombre, String usuario, String password, String rol) {

        Usuario u = usuarioRepository.findByUsuario(usuario).orElseGet(Usuario::new);

        u.setNombre(nombre);
        u.setUsuario(usuario);
        u.setRol(rol);


        u.setPassword(passwordEncoder.encode(password));

        usuarioRepository.save(u);
    }

    @Bean
    CommandLineRunner cargarDatos(ResiduoRepository repository) {

        return args -> {

            if (repository.count() == 0) {

                repository.save(new Residuo(
                        "Cartón",
                        "Ejemplo reciclable",
                        "Punto Verde Centro",
                        "https://maps.google.com",
                        "EJEMPLO",
                        "Sistema"
                ));

                repository.save(new Residuo(
                        "Vidrio",
                        "Ejemplo reciclable",
                        "Punto Verde Norte",
                        "https://maps.google.com",
                        "EJEMPLO",
                        "Sistema"
                ));

                repository.save(new Residuo(
                        "Plástico",
                        "Ejemplo reciclable",
                        "Punto Verde Sur",
                        "https://maps.google.com",
                        "EJEMPLO",
                        "Sistema"
                ));

                repository.save(new Residuo(
                        "Papel",
                        "Ejemplo reciclable",
                        "Punto Verde Oeste",
                        "https://maps.google.com",
                        "EJEMPLO",
                        "Sistema"
                ));

                repository.save(new Residuo(
                        "Aluminio",
                        "Ejemplo reciclable",
                        "Punto Verde Este",
                        "https://maps.google.com",
                        "EJEMPLO",
                        "Sistema"
                ));
            }
        };
    }
}