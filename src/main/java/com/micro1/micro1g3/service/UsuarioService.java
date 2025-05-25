package com.micro1.micro1g3.service;

import com.micro1.micro1g3.model.Permiso;
import com.micro1.micro1g3.model.Rol;
import com.micro1.micro1g3.model.Usuario;
import com.micro1.micro1g3.repository.PermisoRepository;
import com.micro1.micro1g3.repository.RolRepository;
import com.micro1.micro1g3.repository.UsuarioRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private PermisoRepository permisoRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario findByIdUsuario(int idUsuario) {
        return usuarioRepository.findByIdUsuario(idUsuario);
    }

    public Usuario save(Usuario usuario) {
        List<Rol> rolesFinales = new ArrayList<>();

        for (Rol rol : usuario.getRoles()) {
            // Buscar si el rol ya existe
            Rol rolExistente = rolRepository.findByNombreRol(rol.getNombreRol());

            if (rolExistente != null) {
                rolesFinales.add(rolExistente); // Reutilizar el existente
            } else {
                // Verificar y reutilizar permisos si ya existen
                List<Permiso> permisosFinales = new ArrayList<>();
                for (Permiso permiso : rol.getPermisos()) {
                    Permiso permisoExistente = permisoRepository.findByNombrePermiso(permiso.getNombrePermiso());
                    if (permisoExistente != null) {
                        permisosFinales.add(permisoExistente);
                    } else {
                        permiso.setRol(rol); // asignar nueva relación
                        permisosFinales.add(permiso);
                    }
                }
                rol.setPermisos(permisosFinales);
                rol.setUsuario(usuario); // asignar relación usuario -> rol
                rolesFinales.add(rol);
            }
        }

        usuario.setRoles(rolesFinales);
        return usuarioRepository.save(usuario);
    }

    public void deleteByIdUsuario(int idUsuario) {
        usuarioRepository.deleteByIdUsuario(idUsuario);
    }
}
