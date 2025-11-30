package com.itapia.venta.controller;

import com.itapia.venta.entity.MetodoPago;
import com.itapia.venta.service.MetodoPagoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/metodos-pago")
@CrossOrigin(origins = "*")
public class MetodoPagoController {

    private final MetodoPagoService service;

    public MetodoPagoController(MetodoPagoService service) {
        this.service = service;
    }

    @PostMapping
    public MetodoPago crear(@RequestBody MetodoPago mp) {
        return service.crear(mp);
    }

    @GetMapping
    public List<MetodoPago> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public MetodoPago obtener(@PathVariable Long id) {
        return service.obtener(id);
    }

    @PutMapping("/{id}")
    public MetodoPago actualizar(@PathVariable Long id, @RequestBody MetodoPago mp) {
        return service.actualizar(id, mp);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
