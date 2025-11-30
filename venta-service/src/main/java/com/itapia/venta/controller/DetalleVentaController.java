package com.itapia.venta.controller;

import com.itapia.venta.entity.DetalleVenta;
import com.itapia.venta.service.DetalleVentaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detalle-ventas")
@CrossOrigin(origins = "*")
public class DetalleVentaController {

    private final DetalleVentaService service;

    public DetalleVentaController(DetalleVentaService service) {
        this.service = service;
    }

    @PostMapping
    public DetalleVenta crear(@RequestBody DetalleVenta d) {
        return service.crear(d);
    }

    @GetMapping
    public List<DetalleVenta> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public DetalleVenta obtener(@PathVariable Long id) {
        return service.obtener(id);
    }

    @GetMapping("/venta/{ventaId}")
    public List<DetalleVenta> listarPorVenta(@PathVariable Long ventaId) {
        return service.listarPorVenta(ventaId);
    }

    @PutMapping("/{id}")
    public DetalleVenta actualizar(@PathVariable Long id, @RequestBody DetalleVenta d) {
        return service.actualizar(id, d);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
