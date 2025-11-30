package com.itapia.blog.controller;

import com.itapia.blog.entity.Noticia;
import com.itapia.blog.service.NoticiaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/noticias")
@CrossOrigin(origins = "*")
public class NoticiaController {

    private final NoticiaService service;

    public NoticiaController(NoticiaService service) { this.service = service; }

    @PostMapping
    public Noticia crear(@RequestBody Noticia n) { return service.crear(n); }

    @GetMapping
    public List<Noticia> listar() { return service.listar(); }

    @GetMapping("/{id}")
    public Noticia obtener(@PathVariable Long id) { return service.obtener(id); }

    @PutMapping("/{id}")
    public Noticia actualizar(@PathVariable Long id, @RequestBody Noticia n) {
        return service.actualizar(id, n);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) { service.eliminar(id); }
}
