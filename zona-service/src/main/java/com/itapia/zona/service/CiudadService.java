package com.itapia.zona.service;

import com.itapia.zona.entity.Ciudad;
import java.util.List;

public interface CiudadService {
    Ciudad crear(Ciudad ciudad);
    Ciudad obtener(Long id);
    List<Ciudad> listar();
    Ciudad actualizar(Long id, Ciudad ciudad);
    void eliminar(Long id);
}
