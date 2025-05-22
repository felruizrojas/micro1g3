package com.micro1.micro1g3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro1.micro1g3.model.Usuario;
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

    // ----- idUsuario -----

    public Usuario findByIdUsuario(int idUsuario) {
        return usuarioRepository.findById(idUsuario).orElse(null);
    }

    public void deleteById(int idUsuario) {
        usuarioRepository.deleteById(idUsuario);
    }

    // ----- run -----

    public Usuario findByRun(String run) {
        return usuarioRepository.findByRun(run);
    }

    public void deleteByRun(String run) {
        Usuario usuario = usuarioRepository.findByRun(run);
        if (usuario != null) {
            usuarioRepository.delete(usuario);
        }
    }
}
