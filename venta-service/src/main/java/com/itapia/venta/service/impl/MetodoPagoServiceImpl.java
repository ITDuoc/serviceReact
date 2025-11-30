package com.itapia.venta.service.impl;

import com.itapia.venta.entity.MetodoPago;
import com.itapia.venta.repository.MetodoPagoRepository;
import com.itapia.venta.service.MetodoPagoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetodoPagoServiceImpl implements MetodoPagoService {

    private final MetodoPagoRepository repo;

    public MetodoPagoServiceImpl(MetodoPagoRepository repo) {
        this.repo = repo;
    }

    @Override
    public MetodoPago crear(MetodoPago metodoPago) {
        return repo.save(metodoPago);
    }

    @Override
    public MetodoPago obtener(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<MetodoPago> listar() {
        return repo.findAll();
    }

    @Override
    public MetodoPago actualizar(Long id, MetodoPago metodoPago) {
        MetodoPago existente = repo.findById(id).orElse(null);
        if (existente == null) return null;
        existente.setNombre(metodoPago.getNombre());
        existente.setDescripcion(metodoPago.getDescripcion());
        existente.setEstado(metodoPago.getEstado());
        return repo.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
