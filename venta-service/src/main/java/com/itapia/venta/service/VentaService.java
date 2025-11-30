package com.itapia.venta.service;

import com.itapia.venta.entity.Venta;
import java.util.List;

public interface VentaService {
    Venta crear(Venta venta);
    Venta obtener(Long id);
    List<Venta> listar();
    Venta actualizar(Long id, Venta venta);
    void eliminar(Long id);
}
