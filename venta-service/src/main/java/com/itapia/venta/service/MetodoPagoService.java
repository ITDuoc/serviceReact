package com.itapia.venta.service;

import com.itapia.venta.entity.MetodoPago;
import java.util.List;

public interface MetodoPagoService {
    MetodoPago crear(MetodoPago metodoPago);
    MetodoPago obtener(Long id);
    List<MetodoPago> listar();
    MetodoPago actualizar(Long id, MetodoPago metodoPago);
    void eliminar(Long id);
}
