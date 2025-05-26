package com.micro1.micro1g3.service;

import com.micro1.micro1g3.dto.UsuarioUpdateDTO;
import com.micro1.micro1g3.model.NombreRol;
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

    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario crearUsuarioConRoles(Usuario usuario, List<String> nombresRoles) {
        List<Rol> roles = new ArrayList<>();

        for (String nombre : nombresRoles) {
            NombreRol nombreRol = NombreRol.valueOf(nombre.toUpperCase());
            Rol rol = rolRepository.findByNombre(nombreRol)
                    .orElseThrow();
            roles.add(rol);
        }

        usuario.setRoles(roles);
        return usuarioRepository.save(usuario);
    }

    // Stream + Optional.filter().map()
    /*
     * public Usuario crearUsuarioConRoles(Usuario usuario, List<String>
     * nombresRoles) {
     * List<Rol> roles = nombresRoles.stream()
     * .map(nombre -> rolRepository.findByNombre(nombre))
     * .filter(Optional::isPresent)
     * .map(Optional::get)
     * .toList();
     * 
     * usuario.setRoles(roles);
     * return usuarioRepository.save(usuario);
     * }
     */

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
