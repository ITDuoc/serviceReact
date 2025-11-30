package com.itapia.producto.service;

import com.itapia.producto.entity.Producto;
import java.util.List;

public interface ProductoService {

    Producto crearProducto(Producto producto);
    Producto obtenerProductoPorId(Long id);
    List<Producto> listarProductos();
    Producto actualizarProducto(Long id, Producto producto);
    void eliminarProducto(Long id);
}
