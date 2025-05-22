package com.micro1.micro1g3.service;

import com.micro1.micro1g3.model.Usuario;
import com.micro1.micro1g3.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Usuario findByIdUsuario(int idUsuario) {
        return usuarioRepository.findByIdUsuario(idUsuario);
    }

    public void deleteById(int idUsuario) {
        usuarioRepository.deleteByIdUsuario(idUsuario);
    }

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
