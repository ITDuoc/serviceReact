package com.itapia.producto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.itapia.producto.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
