package com.itapia.producto.service.impl;

import com.itapia.producto.entity.Marca;
import com.itapia.producto.repository.MarcaRepository;
import com.itapia.producto.service.MarcaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaServiceImpl implements MarcaService {

    private final MarcaRepository repo;

    public MarcaServiceImpl(MarcaRepository repo) {
        this.repo = repo;
    }

    @Override
    public Marca crearMarca(Marca marca) {
        return repo.save(marca);
    }

    @Override
    public Marca obtenerMarcaPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Marca> listarMarcas() {
        return repo.findAll();
    }

    @Override
    public Marca actualizarMarca(Long id, Marca marca) {
        Marca existente = repo.findById(id).orElse(null);
        if (existente == null) return null;

        existente.setNomMarca(marca.getNomMarca());
        existente.setEstadoMarca(marca.getEstadoMarca());

        return repo.save(existente);
    }

    @Override
    public void eliminarMarca(Long id) {
        repo.deleteById(id);
    }
}
