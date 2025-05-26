package com.micro1.micro1g3.service;

import com.micro1.micro1g3.model.Permiso;
import com.micro1.micro1g3.model.Rol;
import com.micro1.micro1g3.repository.PermisoRepository;
import com.micro1.micro1g3.repository.RolRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PermisoService {

    @Autowired
    private PermisoRepository permisoRepository;

    @Autowired
    private RolRepository rolRepository;

    public List<Permiso> listarPermisos() {
        return permisoRepository.findAll();
    }

    public Optional<Permiso> permisoPorId(int id) {
        return permisoRepository.findById(id);
    }

    /*
     * public Permiso crearPermiso(Permiso permiso) {
     * return permisoRepository.save(permiso);
     * }
     * //el de abajo conservarlo
     * 
     * public Permiso crearPermiso(Permiso permiso) {
     * List<Rol> rolesGuardados = new ArrayList<>();
     * for (Rol rol : permiso.getRoles()) {
     * Rol guardado = rolRepository.save(rol); // Guardar primero
     * rolesGuardados.add(guardado);
     * }
     * permiso.setRoles(rolesGuardados);
     * return permisoRepository.save(permiso);
     * }
     */

    public Permiso crearPermiso(Permiso permiso) {
        List<Rol> rolesGuardados = new ArrayList<>();

        if (permiso.getRoles() != null) {
            for (Rol rol : permiso.getRoles()) {
                Rol guardado = rolRepository.save(rol);
                rolesGuardados.add(guardado);
            }
        }

        permiso.setRoles(rolesGuardados);
        return permisoRepository.save(permiso);
    }

    @Transactional
    public void eliminarPermiso(int id) {
        Optional<Permiso> permisoOpt = permisoRepository.findById(id);
        if (permisoOpt.isPresent()) {
            Permiso permiso = permisoOpt.get();

            // Limpiar la relación con roles
            for (Rol rol : permiso.getRoles()) {
                rol.getPermisos().remove(permiso);
            }
            permiso.getRoles().clear();

            permisoRepository.delete(permiso);
        }
    }

}
