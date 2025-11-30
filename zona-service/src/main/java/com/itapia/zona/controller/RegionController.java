package com.itapia.zona.controller;

import com.itapia.zona.entity.Region;
import com.itapia.zona.service.RegionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/regiones")
@CrossOrigin(origins = "*")
public class RegionController {

    private final RegionService service;

    public RegionController(RegionService service) { this.service = service; }

    @PostMapping
    public Region crear(@RequestBody Region r) { return service.crear(r); }

    @GetMapping
    public List<Region> listar() { return service.listar(); }

    @GetMapping("/{id}")
    public Region obtener(@PathVariable Long id) { return service.obtener(id); }

    @PutMapping("/{id}")
    public Region actualizar(@PathVariable Long id, @RequestBody Region r) {
        return service.actualizar(id, r);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) { service.eliminar(id); }
}
