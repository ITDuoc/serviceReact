package com.itapia.blog.repository;

import com.itapia.blog.entity.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticiaRepository extends JpaRepository<Noticia, Long> {
}
