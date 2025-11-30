package com.itapia.usuario.controller;

import com.itapia.usuario.entity.Usuario;
import com.itapia.usuario.security.JwtUtil;
import com.itapia.usuario.service.UsuarioService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final UsuarioService usuarioService;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UsuarioService usuarioService, JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
        this.usuarioService = usuarioService;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public String login(@RequestBody Usuario u) {
        Usuario usuario = usuarioService.buscarPorCorreo(u.getCorreoUsuario());
        if (usuario == null || !passwordEncoder.matches(u.getPassUsuario(), usuario.getPassUsuario())) {
            return "ERROR: Usuario o contraseña incorrecta";
        }

        Set<String> roles = usuario.getRoles().stream()
                .map(r -> r.getNomRol())
                .collect(Collectors.toSet());

        return jwtUtil.generarToken(usuario.getCorreoUsuario(), roles);
    }

    @PostMapping("/registro")
    public Usuario registro(@RequestBody Usuario u) {
        u.setPassUsuario(passwordEncoder.encode(u.getPassUsuario()));
        return usuarioService.crearUsuario(u);
    }
}
