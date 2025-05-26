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

        usuario.setRun(dto.getRun());
        usuario.setNomPrimero(dto.getNomPrimero());
        usuario.setNomSegundo(dto.getNomSegundo());
        usuario.setApPaterno(dto.getApPaterno());
        usuario.setApMaterno(dto.getApMaterno());
        usuario.setCorreo(dto.getCorreo());
        usuario.setDireccion(dto.getDireccion());
        usuario.setCiudad(dto.getCiudad());
        usuario.setRegion(dto.getRegion());

        if (dto.getRolNombre() != null && !dto.getRolNombre().isBlank()) {
            Rol rol = rolRepository.findByNombre(dto.getRolNombre())
                    .orElseGet(() -> {
                        Rol nuevoRol = new Rol();
                        nuevoRol.setNombre(dto.getRolNombre());
                        return rolRepository.save(nuevoRol);
                    });

            List<Rol> roles = new ArrayList<>();
            roles.add(rol);
            usuario.setRoles(roles);
        } else {
            usuario.setRoles(new ArrayList<>()); // o null, según lógica de negocio
        }

        return usuarioRepository.save(usuario);
    }

    public Usuario actualizarUsuario(int id, UsuarioUpdateDTO dto) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);

        if (usuario == null) {
            return null; // Puedes devolver null o manejarlo desde el controller con una respuesta 404
        }

        if (dto.getNomPrimero() != null) {
            usuario.setNomPrimero(dto.getNomPrimero());
        }
        if (dto.getNomSegundo() != null) {
            usuario.setNomSegundo(dto.getNomSegundo());
        }
        if (dto.getApPaterno() != null) {
            usuario.setApPaterno(dto.getApPaterno());
        }
        if (dto.getApMaterno() != null) {
            usuario.setApMaterno(dto.getApMaterno());
        }
        if (dto.getCorreo() != null) {
            usuario.setCorreo(dto.getCorreo());
        }
        if (dto.getDireccion() != null) {
            usuario.setDireccion(dto.getDireccion());
        }
        if (dto.getCiudad() != null) {
            usuario.setCiudad(dto.getCiudad());
        }
        if (dto.getRegion() != null) {
            usuario.setRegion(dto.getRegion());
        }

        return usuarioRepository.save(usuario);
    }

    public void eliminarUsuario(int id) {
        usuarioRepository.deleteById(id);
    }
}
