package com.itapia.blog.repository;

import com.itapia.blog.entity.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

    // Listar comentarios por noticia
    List<Comentario> findByNoticiaId(Long idNoticia);
}
