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

public class RolService {

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private PermisoRepository permisoRepository;

    public List<Rol> listarRoles() {
        return rolRepository.findAll();
    }

    public Optional<Rol> rolPorId(int id) {
        return rolRepository.findById(id);
    }

    public Rol crearRol(Rol rol) {
        List<Permiso> permisosGuardados = new ArrayList<>();
        for (Permiso permiso : rol.getPermisos()) {
            Permiso guardado = permisoRepository.save(permiso); // Guardar primero
            permisosGuardados.add(guardado);
        }
        rol.setPermisos(permisosGuardados);
        return rolRepository.save(rol);
    }

    /*
     * public Rol crearRol(Rol rol) {
     * return permisoRepository.save(rol);
     * }
     */

    @Transactional
    public void eliminarRol(int id) {
        Optional<Rol> rolOpt = rolRepository.findById(id);
        if (rolOpt.isPresent()) {
            Rol rol = rolOpt.get();
            // Limpiar relaciones con usuarios
            rol.getUsuarios().forEach(usuario -> usuario.getRoles().remove(rol));
            rol.getUsuarios().clear();

            // Limpiar relaciones con permisos (opcional si tienes cascada)
            rol.getPermisos().clear();

            rolRepository.delete(rol);
        }
    }
    //por el momento no se elimina el rol, no los permisos asociados a el

}
