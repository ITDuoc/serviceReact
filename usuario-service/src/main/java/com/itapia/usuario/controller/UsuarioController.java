package com.itapia.usuario.controller;

import com.itapia.usuario.entity.Usuario;
import com.itapia.usuario.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) { this.service = service; }

    @PostMapping
    public Usuario crear(@RequestBody Usuario u) { return service.crearUsuario(u); }

    @GetMapping
    public List<Usuario> listar() { return service.listarUsuarios(); }

    @GetMapping("/{id}")
    public Usuario obtener(@PathVariable Long id) { return service.obtenerUsuarioPorId(id); }

    @PutMapping("/{id}")
    public Usuario actualizar(@PathVariable Long id, @RequestBody Usuario u) { return service.actualizarUsuario(id, u); }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) { service.eliminarUsuario(id); }
}
