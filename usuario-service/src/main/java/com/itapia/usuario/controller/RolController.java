package com.itapia.usuario.controller;

import com.itapia.usuario.entity.Rol;
import com.itapia.usuario.service.RolService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rol")
@CrossOrigin(origins = "*")
public class RolController {

    private final RolService service;

    public RolController(RolService service) { this.service = service; }

    @PostMapping
    public Rol crear(@RequestBody Rol rol) { return service.crearRol(rol); }

    @GetMapping
    public List<Rol> listar() { return service.listarRoles(); }

    @GetMapping("/{id}")
    public Rol obtener(@PathVariable Long id) { return service.obtenerRolPorId(id); }

    @PutMapping("/{id}")
    public Rol actualizar(@PathVariable Long id, @RequestBody Rol rol) { return service.actualizarRol(id, rol); }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) { service.eliminarRol(id); }
}
