package com.itapia.venta.service.impl;

import com.itapia.venta.entity.Venta;
import com.itapia.venta.entity.DetalleVenta;
import com.itapia.venta.repository.VentaRepository;
import com.itapia.venta.repository.DetalleVentaRepository;
import com.itapia.venta.service.VentaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VentaServiceImpl implements VentaService {

    private final VentaRepository ventaRepo;
    private final DetalleVentaRepository detalleRepo;

    public VentaServiceImpl(VentaRepository ventaRepo, DetalleVentaRepository detalleRepo) {
        this.ventaRepo = ventaRepo;
        this.detalleRepo = detalleRepo;
    }

    @Override
    @Transactional
    public Venta crear(Venta venta) {
        // Guardar la venta primero
        Venta ventaGuardada = ventaRepo.save(venta);

        // Guardar los detalles
        if (venta.getDetalles() != null) {
            for (DetalleVenta d : venta.getDetalles()) {
                d.setVenta(ventaGuardada); // asignar la venta al detalle
                detalleRepo.save(d);
            }
        }

        return ventaGuardada;
    }

    @Override
    public Venta obtener(Long id) {
        return ventaRepo.findById(id).orElse(null);
    }

    @Override
    public List<Venta> listar() {
        return ventaRepo.findAll();
    }

    @Override
    @Transactional
    public Venta actualizar(Long id, Venta venta) {
        Venta existente = ventaRepo.findById(id).orElse(null);
        if (existente == null) return null;

        existente.setFechaVenta(venta.getFechaVenta());
        existente.setDirEnvio(venta.getDirEnvio());
        existente.setTotalVenta(venta.getTotalVenta());
        existente.setIdUsuario(venta.getIdUsuario());
        existente.setIdMetodoPago(venta.getIdMetodoPago());
        existente.setIdEstadoVenta(venta.getIdEstadoVenta());

        // Actualizar detalles: eliminar antiguos y agregar nuevos
        if (existente.getDetalles() != null) {
            detalleRepo.deleteAll(existente.getDetalles());
        }
        if (venta.getDetalles() != null) {
            for (DetalleVenta d : venta.getDetalles()) {
                d.setVenta(existente);
                detalleRepo.save(d);
            }
        }

        return ventaRepo.save(existente);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        Venta venta = ventaRepo.findById(id).orElse(null);
        if (venta != null) {
            if (venta.getDetalles() != null) {
                detalleRepo.deleteAll(venta.getDetalles());
            }
            ventaRepo.delete(venta);
        }
    }
}
