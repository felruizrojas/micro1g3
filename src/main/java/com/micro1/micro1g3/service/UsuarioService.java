package com.micro1.micro1g3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro1.micro1g3.model.Rol;
import com.micro1.micro1g3.model.Usuario;
import com.micro1.micro1g3.repository.RolRepository;
import com.micro1.micro1g3.repository.UsuarioRepository;

@Service

public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario findByRun(String run) {
        return usuarioRepository.findByRun(run);
    }

    public void deleteByRun(String run) {
        usuarioRepository.deleteByRun(run);
    }

    public Usuario findByIdUsuario(int idUsuario) {
        return usuarioRepository.findByIdUsuario(idUsuario);
    }

    public void deleteById(int idUsuario) {
        usuarioRepository.deleteById(idUsuario);
    }

    public boolean existePorRun(String run) {
        return usuarioRepository.existsByRun(run);
    }
}
