package com.itapia.producto.service;

import com.itapia.producto.entity.Categoria;
import java.util.List;

public interface CategoriaService {

    Categoria crearCategoria(Categoria categoria);

    Categoria obtenerCategoriaPorId(Long id);

    List<Categoria> listarCategorias();

    Categoria actualizarCategoria(Long id, Categoria categoria);

    void eliminarCategoria(Long id);
}
