package com.itapia.producto.service.impl;

import com.itapia.producto.entity.Categoria;
import com.itapia.producto.entity.Marca;
import com.itapia.producto.entity.Producto;
import com.itapia.producto.repository.CategoriaRepository;
import com.itapia.producto.repository.MarcaRepository;
import com.itapia.producto.repository.ProductoRepository;
import com.itapia.producto.service.ProductoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository repo;
    private final CategoriaRepository categoriaRepo;
    private final MarcaRepository marcaRepo;

    public ProductoServiceImpl(ProductoRepository repo, CategoriaRepository categoriaRepo, MarcaRepository marcaRepo) {
        this.repo = repo;
        this.categoriaRepo = categoriaRepo;
        this.marcaRepo = marcaRepo;
    }

    @Override
    public Producto crearProducto(Producto producto) {

        Categoria cat = categoriaRepo.findById(producto.getCategoria().getIdCategoria()).orElse(null);
        Marca mar = marcaRepo.findById(producto.getMarca().getIdMarca()).orElse(null);

        producto.setCategoria(cat);
        producto.setMarca(mar);

        return repo.save(producto);
    }

    @Override
    public Producto obtenerProductoPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Producto> listarProductos() {
        return repo.findAll();
    }

    @Override
    public Producto actualizarProducto(Long id, Producto producto) {
        Producto existente = repo.findById(id).orElse(null);
        if (existente == null) return null;

        existente.setNomProducto(producto.getNomProducto());
        existente.setPrecioProducto(producto.getPrecioProducto());
        existente.setStockProducto(producto.getStockProducto());
        existente.setEstadoProducto(producto.getEstadoProducto());
        existente.setImgProducto(producto.getImgProducto());

        Categoria cat = categoriaRepo.findById(producto.getCategoria().getIdCategoria()).orElse(null);
        Marca mar = marcaRepo.findById(producto.getMarca().getIdMarca()).orElse(null);

        existente.setCategoria(cat);
        existente.setMarca(mar);

        return repo.save(existente);
    }

    @Override
    public void eliminarProducto(Long id) {
        repo.deleteById(id);
    }
}
