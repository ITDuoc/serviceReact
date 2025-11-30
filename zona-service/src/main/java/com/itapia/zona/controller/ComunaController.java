package com.itapia.zona.controller;

import com.itapia.zona.entity.Comuna;
import com.itapia.zona.service.ComunaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comunas")
@CrossOrigin(origins = "*")
public class ComunaController {

    private final ComunaService service;

    public ComunaController(ComunaService service) { this.service = service; }

    @PostMapping
    public Comuna crear(@RequestBody Comuna c) { return service.crear(c); }

    @GetMapping
    public List<Comuna> listar() { return service.listar(); }

    @GetMapping("/{id}")
    public Comuna obtener(@PathVariable Long id) { return service.obtener(id); }

    @PutMapping("/{id}")
    public Comuna actualizar(@PathVariable Long id, @RequestBody Comuna c) {
        return service.actualizar(id, c);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) { service.eliminar(id); }
}
