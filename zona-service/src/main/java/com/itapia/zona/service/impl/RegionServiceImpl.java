package com.itapia.zona.service.impl;

import com.itapia.zona.entity.Region;
import com.itapia.zona.repository.RegionRepository;
import com.itapia.zona.service.RegionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionServiceImpl implements RegionService {

    private final RegionRepository repo;

    public RegionServiceImpl(RegionRepository repo) {
        this.repo = repo;
    }

    @Override
    public Region crear(Region region) {
        return repo.save(region);
    }

    @Override
    public Region obtener(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Region> listar() {
        return repo.findAll();
    }

    @Override
    public Region actualizar(Long id, Region region) {
        Region existente = repo.findById(id).orElse(null);
        if (existente == null) return null;
        existente.setNombre(region.getNombre());
        return repo.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
