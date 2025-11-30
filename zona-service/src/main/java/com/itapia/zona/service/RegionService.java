package com.itapia.zona.service;

import com.itapia.zona.entity.Region;
import java.util.List;

public interface RegionService {
    Region crear(Region region);
    Region obtener(Long id);
    List<Region> listar();
    Region actualizar(Long id, Region region);
    void eliminar(Long id);
}
