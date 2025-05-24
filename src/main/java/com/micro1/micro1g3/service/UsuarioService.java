package com.micro1.micro1g3.service;

import com.micro1.micro1g3.model.Usuario;
import com.micro1.micro1g3.repository.UsuarioRepository;

import jakarta.persistence.EntityNotFoundException;

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

    public Usuario findByIdUsuario(int idUsuario) {
        Usuario usuario = usuarioRepository.findByIdUsuario(idUsuario);
        if (usuario == null) {
            throw new EntityNotFoundException("Usuario no encontrado con ID: " + idUsuario);
        }
        return usuario;
    }

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deleteByIdUsuario(int idUsuario) {
        usuarioRepository.deleteByIdUsuario(idUsuario);
    }
}
