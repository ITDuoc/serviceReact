package com.itapia.producto.service.impl;

import com.itapia.producto.entity.Categoria;
import com.itapia.producto.repository.CategoriaRepository;
import com.itapia.producto.service.CategoriaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public Categoria crearCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria obtenerCategoriaPorId(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria actualizarCategoria(Long id, Categoria categoria) {
        Categoria existente = categoriaRepository.findById(id).orElse(null);
        if (existente == null) return null;

        existente.setNomCategoria(categoria.getNomCategoria());
        existente.setDescCategoria(categoria.getDescCategoria());
        existente.setImgCategoria(categoria.getImgCategoria());
        existente.setEstadoCategoria(categoria.getEstadoCategoria());

        return categoriaRepository.save(existente);
    }

    @Override
    public void eliminarCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }
}
