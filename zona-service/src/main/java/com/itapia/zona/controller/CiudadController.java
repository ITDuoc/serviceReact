package com.itapia.zona.controller;

import com.itapia.zona.entity.Ciudad;
import com.itapia.zona.service.CiudadService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ciudades")
@CrossOrigin(origins = "*")
public class CiudadController {

    private final CiudadService service;

    public CiudadController(CiudadService service) { this.service = service; }

    @PostMapping
    public Ciudad crear(@RequestBody Ciudad c) { return service.crear(c); }

    @GetMapping
    public List<Ciudad> listar() { return service.listar(); }

    @GetMapping("/{id}")
    public Ciudad obtener(@PathVariable Long id) { return service.obtener(id); }

    @PutMapping("/{id}")
    public Ciudad actualizar(@PathVariable Long id, @RequestBody Ciudad c) {
        return service.actualizar(id, c);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) { service.eliminar(id); }
}
