package com.itapia.usuario.service.impl;

import com.itapia.usuario.entity.Rol;
import com.itapia.usuario.repository.RolRepository;
import com.itapia.usuario.service.RolService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolServiceImpl implements RolService {

    private final RolRepository repo;

    public RolServiceImpl(RolRepository repo) {
        this.repo = repo;
    }

    @Override
    public Rol crearRol(Rol rol) {
        return repo.save(rol);
    }

    @Override
    public Rol obtenerRolPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Rol> listarRoles() {
        return repo.findAll();
    }

    @Override
    public Rol actualizarRol(Long id, Rol rol) {
        Rol existente = repo.findById(id).orElse(null);
        if (existente == null) return null;
        existente.setNomRol(rol.getNomRol());
        return repo.save(existente);
    }

    @Override
    public void eliminarRol(Long id) {
        repo.deleteById(id);
    }
}
