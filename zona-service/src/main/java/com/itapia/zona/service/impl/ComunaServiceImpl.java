package com.itapia.zona.service.impl;

import com.itapia.zona.entity.Comuna;
import com.itapia.zona.entity.Ciudad;
import com.itapia.zona.repository.ComunaRepository;
import com.itapia.zona.repository.CiudadRepository;
import com.itapia.zona.service.ComunaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComunaServiceImpl implements ComunaService {

    private final ComunaRepository repo;
    private final CiudadRepository ciudadRepo;

    public ComunaServiceImpl(ComunaRepository repo, CiudadRepository ciudadRepo) {
        this.repo = repo;
        this.ciudadRepo = ciudadRepo;
    }

    @Override
    public Comuna crear(Comuna comuna) {
        if (comuna.getCiudad() != null && comuna.getCiudad().getId() != null) {
            Ciudad c = ciudadRepo.findById(comuna.getCiudad().getId()).orElse(null);
            comuna.setCiudad(c);
        }
        return repo.save(comuna);
    }

    @Override
    public Comuna obtener(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Comuna> listar() {
        return repo.findAll();
    }

    @Override
    public Comuna actualizar(Long id, Comuna comuna) {
        Comuna existente = repo.findById(id).orElse(null);
        if (existente == null) return null;
        existente.setNombre(comuna.getNombre());
        if (comuna.getCiudad() != null && comuna.getCiudad().getId() != null) {
            Ciudad c = ciudadRepo.findById(comuna.getCiudad().getId()).orElse(null);
            existente.setCiudad(c);
        }
        return repo.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
