package com.itapia.venta.controller;

import com.itapia.venta.entity.EstadoVenta;
import com.itapia.venta.service.EstadoVentaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estados-venta")
@CrossOrigin(origins = "*")
public class EstadoVentaController {

    private final EstadoVentaService service;

    public EstadoVentaController(EstadoVentaService service) {
        this.service = service;
    }

    @PostMapping
    public EstadoVenta crear(@RequestBody EstadoVenta ev) {
        return service.crear(ev);
    }

    @GetMapping
    public List<EstadoVenta> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public EstadoVenta obtener(@PathVariable Long id) {
        return service.obtener(id);
    }

    @PutMapping("/{id}")
    public EstadoVenta actualizar(@PathVariable Long id, @RequestBody EstadoVenta ev) {
        return service.actualizar(id, ev);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
