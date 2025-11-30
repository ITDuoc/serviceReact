package com.itapia.zona.service;

import com.itapia.zona.entity.Comuna;
import java.util.List;

public interface ComunaService {
    Comuna crear(Comuna comuna);
    Comuna obtener(Long id);
    List<Comuna> listar();
    Comuna actualizar(Long id, Comuna comuna);
    void eliminar(Long id);
}
