package com.itapia.zona.service.impl;

import com.itapia.zona.entity.Ciudad;
import com.itapia.zona.entity.Region;
import com.itapia.zona.repository.CiudadRepository;
import com.itapia.zona.repository.RegionRepository;
import com.itapia.zona.service.CiudadService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CiudadServiceImpl implements CiudadService {

    private final CiudadRepository repo;
    private final RegionRepository regionRepo;

    public CiudadServiceImpl(CiudadRepository repo, RegionRepository regionRepo) {
        this.repo = repo;
        this.regionRepo = regionRepo;
    }

    @Override
    public Ciudad crear(Ciudad ciudad) {
        if (ciudad.getRegion() != null && ciudad.getRegion().getId() != null) {
            Region r = regionRepo.findById(ciudad.getRegion().getId()).orElse(null);
            ciudad.setRegion(r);
        }
        return repo.save(ciudad);
    }

    @Override
    public Ciudad obtener(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Ciudad> listar() {
        return repo.findAll();
    }

    @Override
    public Ciudad actualizar(Long id, Ciudad ciudad) {
        Ciudad existente = repo.findById(id).orElse(null);
        if (existente == null) return null;
        existente.setNombre(ciudad.getNombre());
        if (ciudad.getRegion() != null && ciudad.getRegion().getId() != null) {
            Region r = regionRepo.findById(ciudad.getRegion().getId()).orElse(null);
            existente.setRegion(r);
        }
        return repo.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
