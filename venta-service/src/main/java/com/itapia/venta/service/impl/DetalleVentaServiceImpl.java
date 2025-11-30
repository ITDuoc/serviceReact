package com.itapia.venta.service.impl;

import com.itapia.venta.entity.DetalleVenta;
import com.itapia.venta.repository.DetalleVentaRepository;
import com.itapia.venta.service.DetalleVentaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleVentaServiceImpl implements DetalleVentaService {

    private final DetalleVentaRepository repo;

    public DetalleVentaServiceImpl(DetalleVentaRepository repo) {
        this.repo = repo;
    }

    @Override
    public DetalleVenta crear(DetalleVenta detalle) {
        return repo.save(detalle);
    }

    @Override
    public DetalleVenta obtener(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<DetalleVenta> listar() {
        return repo.findAll();
    }

    @Override
    public List<DetalleVenta> listarPorVenta(Long ventaId) {
        return repo.findByVentaId(ventaId);
    }

    @Override
    public DetalleVenta actualizar(Long id, DetalleVenta detalle) {
        DetalleVenta existente = repo.findById(id).orElse(null);
        if (existente == null) return null;

        existente.setIdProducto(detalle.getIdProducto());
        existente.setCantidad(detalle.getCantidad());
        existente.setPrecioUnitario(detalle.getPrecioUnitario());
        existente.setSubtotal(detalle.getSubtotal());
        existente.setVenta(detalle.getVenta());

        return repo.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
