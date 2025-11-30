package com.itapia.venta.service;

import com.itapia.venta.entity.DetalleVenta;
import java.util.List;

public interface DetalleVentaService {
    DetalleVenta crear(DetalleVenta detalle);
    DetalleVenta obtener(Long id);
    List<DetalleVenta> listar();
    List<DetalleVenta> listarPorVenta(Long ventaId);
    DetalleVenta actualizar(Long id, DetalleVenta detalle);
    void eliminar(Long id);
}
