package com.itapia.blog.service.impl;

import com.itapia.blog.entity.Noticia;
import com.itapia.blog.repository.NoticiaRepository;
import com.itapia.blog.service.NoticiaService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NoticiaServiceImpl implements NoticiaService {

    private final NoticiaRepository repository;

    public NoticiaServiceImpl(NoticiaRepository repository) { this.repository = repository; }

    @Override
    public Noticia crear(Noticia n) { return repository.save(n); }

    @Override
    public List<Noticia> listar() { return repository.findAll(); }

    @Override
    public Noticia obtener(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Noticia actualizar(Long id, Noticia n) {
        return repository.findById(id).map(not -> {
            not.setNomNoticia(n.getNomNoticia());
            not.setDetNoticia(n.getDetNoticia());
            not.setImgNoticia(n.getImgNoticia());
            not.setFechaNoticia(n.getFechaNoticia());
            return repository.save(not);
        }).orElse(null);
    }

    @Override
    public void eliminar(Long id) { repository.deleteById(id); }
}
