package com.itapia.producto.controller;

import com.itapia.producto.entity.Producto;
import com.itapia.producto.service.ProductoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
@CrossOrigin(origins = "*")
public class ProductoController {

    private final ProductoService service;

    public ProductoController(ProductoService service) {
        this.service = service;
    }

    @PostMapping
    public Producto crear(@RequestBody Producto producto) {
        return service.crearProducto(producto);
    }

    @GetMapping("/{id}")
    public Producto obtener(@PathVariable Long id) {
        return service.obtenerProductoPorId(id);
    }

    @GetMapping
    public List<Producto> listar() {
        return service.listarProductos();
    }

    @PutMapping("/{id}")
    public Producto actualizar(@PathVariable Long id, @RequestBody Producto producto) {
        return service.actualizarProducto(id, producto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminarProducto(id);
    }
}
