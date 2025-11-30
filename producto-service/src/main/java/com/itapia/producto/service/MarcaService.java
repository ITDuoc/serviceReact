package com.itapia.producto.service;

import com.itapia.producto.entity.Marca;

import java.util.List;

public interface MarcaService {

    Marca crearMarca(Marca marca);
    Marca obtenerMarcaPorId(Long id);
    List<Marca> listarMarcas();
    Marca actualizarMarca(Long id, Marca marca);
    void eliminarMarca(Long id);
}
