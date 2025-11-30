package com.itapia.usuario.service.impl;

import com.itapia.usuario.entity.Rol;
import com.itapia.usuario.entity.Usuario;
import com.itapia.usuario.repository.RolRepository;
import com.itapia.usuario.repository.UsuarioRepository;
import com.itapia.usuario.service.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepo;
    private final RolRepository rolRepo;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepo, RolRepository rolRepo) {
        this.usuarioRepo = usuarioRepo;
        this.rolRepo = rolRepo;
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        // si vienen roles con solo id, los resolvemos
        if (usuario.getRoles() != null && !usuario.getRoles().isEmpty()) {
            Set<Rol> roles = usuario.getRoles().stream()
                .map(r -> rolRepo.findById(r.getIdRol()).orElse(null))
                .filter(r -> r != null)
                .collect(Collectors.toSet());
            usuario.setRoles(roles);
        }
        // Nota: más adelante deberías encriptar passUsuario con BCrypt
        return usuarioRepo.save(usuario);
    }

    @Override
    public Usuario obtenerUsuarioPorId(Long id) {
        return usuarioRepo.findById(id).orElse(null);
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepo.findAll();
    }

    @Override
    public Usuario actualizarUsuario(Long id, Usuario usuario) {
        Usuario existente = usuarioRepo.findById(id).orElse(null);
        if (existente == null) return null;

        existente.setNomUsuario(usuario.getNomUsuario());
        existente.setApeUsuario(usuario.getApeUsuario());
        existente.setCorreoUsuario(usuario.getCorreoUsuario());
        // si quieres mantener contraseña, cámbiala explícitamente
        if (usuario.getPassUsuario() != null) {
            existente.setPassUsuario(usuario.getPassUsuario());
        }
        existente.setFechaNacUsuario(usuario.getFechaNacUsuario());
        existente.setEstadoUsuario(usuario.getEstadoUsuario());
        existente.setImgUsuario(usuario.getImgUsuario());

        if (usuario.getRoles() != null) {
            Set<Rol> roles = usuario.getRoles().stream()
                .map(r -> rolRepo.findById(r.getIdRol()).orElse(null))
                .filter(r -> r != null)
                .collect(Collectors.toSet());
            existente.setRoles(roles);
        }

        return usuarioRepo.save(existente);
    }

    @Override
    public void eliminarUsuario(Long id) {
        usuarioRepo.deleteById(id);
    }

    @Override
    public Usuario buscarPorCorreo(String correo) {
        return usuarioRepo.findByCorreoUsuario(correo).orElse(null);
    }
}
