package com.itapia.usuario.controller;

import com.itapia.usuario.entity.Usuario;
import com.itapia.usuario.service.UsuarioService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    public Usuario crear(@RequestBody Usuario u) {
        return service.crearUsuario(u);
    }

    @GetMapping
    public List<Usuario> listar() {
        return service.listarUsuarios();
    }

    @GetMapping("/{id}")
    public Usuario obtener(@PathVariable Long id) {
        return service.obtenerUsuarioPorId(id);
    }

    @PutMapping("/{id}")
    public Usuario actualizar(@PathVariable Long id, @RequestBody Usuario u) {
        return service.actualizarUsuario(id, u);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminarUsuario(id);
    }

    // --- Ejemplo de endpoint protegido por rol ---
    @GetMapping("/admin")
    public String soloAdmin() {
        boolean esAdmin = SecurityContextHolder.getContext().getAuthentication()
                .getAuthorities()
                .stream()
                .anyMatch(a -> a.getAuthority().equals("ADMIN"));
        if (!esAdmin) return "No autorizado";
        return "Bienvenido Admin";
    }

    @GetMapping("/user")
    public String soloUsuario() {
        boolean esUsuario = SecurityContextHolder.getContext().getAuthentication()
                .getAuthorities()
                .stream()
                .anyMatch(a -> a.getAuthority().equals("USER"));
        if (!esUsuario) return "No autorizado";
        return "Bienvenido Usuario";
    }

    // --- Obtener roles del usuario logueado ---
    @GetMapping("/mis-roles")
    public List<String> misRoles() {
        return SecurityContextHolder.getContext().getAuthentication()
                .getAuthorities()
                .stream()
                .map((GrantedAuthority a) -> a.getAuthority()) // lambda explícita
                .collect(Collectors.toList());
    }
}
