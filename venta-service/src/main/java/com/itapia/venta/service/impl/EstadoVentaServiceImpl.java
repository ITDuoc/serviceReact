package com.itapia.venta.service.impl;

import com.itapia.venta.entity.EstadoVenta;
import com.itapia.venta.repository.EstadoVentaRepository;
import com.itapia.venta.service.EstadoVentaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoVentaServiceImpl implements EstadoVentaService {

    private final EstadoVentaRepository repo;

    public EstadoVentaServiceImpl(EstadoVentaRepository repo) {
        this.repo = repo;
    }

    @Override
    public EstadoVenta crear(EstadoVenta estadoVenta) {
        return repo.save(estadoVenta);
    }

    @Override
    public EstadoVenta obtener(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<EstadoVenta> listar() {
        return repo.findAll();
    }

    @Override
    public EstadoVenta actualizar(Long id, EstadoVenta estadoVenta) {
        EstadoVenta existente = repo.findById(id).orElse(null);
        if (existente == null) return null;
        existente.setNombre(estadoVenta.getNombre());
        existente.setDescripcion(estadoVenta.getDescripcion());
        return repo.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
