package com.itapia.producto.controller;

import com.itapia.producto.entity.Marca;
import com.itapia.producto.service.MarcaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marca")
@CrossOrigin(origins = "*")
public class MarcaController {

    private final MarcaService service;

    public MarcaController(MarcaService service) {
        this.service = service;
    }

    @PostMapping
    public Marca crear(@RequestBody Marca marca) {
        return service.crearMarca(marca);
    }

    @GetMapping("/{id}")
    public Marca obtener(@PathVariable Long id) {
        return service.obtenerMarcaPorId(id);
    }

    @GetMapping
    public List<Marca> listar() {
        return service.listarMarcas();
    }

    @PutMapping("/{id}")
    public Marca actualizar(@PathVariable Long id, @RequestBody Marca marca) {
        return service.actualizarMarca(id, marca);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminarMarca(id);
    }
}
