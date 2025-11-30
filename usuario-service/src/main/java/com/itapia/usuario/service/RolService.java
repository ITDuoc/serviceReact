package com.itapia.usuario.service;

import com.itapia.usuario.entity.Rol;
import java.util.List;

public interface RolService {
    Rol crearRol(Rol rol);
    Rol obtenerRolPorId(Long id);
    List<Rol> listarRoles();
    Rol actualizarRol(Long id, Rol rol);
    void eliminarRol(Long id);
}
