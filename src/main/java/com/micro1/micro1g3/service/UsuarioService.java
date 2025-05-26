package com.micro1.micro1g3.service;

import com.micro1.micro1g3.dto.UsuarioDTO;
import com.micro1.micro1g3.dto.UsuarioUpdateDTO;
import com.micro1.micro1g3.model.Rol;
import com.micro1.micro1g3.model.Usuario;
import com.micro1.micro1g3.repository.RolRepository;
import com.micro1.micro1g3.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> usuarioPorId(int id) {
        return usuarioRepository.findById(id);
    }

    public Usuario crearUsuario(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setNombre(dto.getNombre());
        usuario.setRun(dto.getRun());

        if (dto.getRolNombre() != null && !dto.getRolNombre().isBlank()) {
            Rol rol = rolRepository.findByNombre(dto.getRolNombre())
                    .orElseGet(() -> {
                        Rol nuevoRol = new Rol();
                        nuevoRol.setNombre(dto.getRolNombre());
                        return rolRepository.save(nuevoRol);
                    });

            // IMPORTANTE: estás usando List, no Set
            List<Rol> roles = new ArrayList<>();
            roles.add(rol);
            usuario.setRoles(roles);
        } else {
            usuario.setRoles(new ArrayList<>()); // o null si prefieres
        }

        return usuarioRepository.save(usuario);
    }

    public Usuario actualizarUsuario(int id, UsuarioUpdateDTO dto) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);

        if (usuario == null) {
            return null; // Podés manejar esto desde el controller con un 404
        }

        if (dto.getNombre() != null) {
            usuario.setNombre(dto.getNombre());
        }

        return usuarioRepository.save(usuario);
    }

    public void eliminarUsuario(int id) {
        usuarioRepository.deleteById(id);
    }
}
