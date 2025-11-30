package com.itapia.venta.service;

import com.itapia.venta.entity.EstadoVenta;
import java.util.List;

public interface EstadoVentaService {
    EstadoVenta crear(EstadoVenta estadoVenta);
    EstadoVenta obtener(Long id);
    List<EstadoVenta> listar();
    EstadoVenta actualizar(Long id, EstadoVenta estadoVenta);
    void eliminar(Long id);
}
