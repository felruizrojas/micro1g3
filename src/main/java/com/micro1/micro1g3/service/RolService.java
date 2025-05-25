package com.micro1.micro1g3.service;

import com.micro1.micro1g3.model.Permiso;
import com.micro1.micro1g3.model.Rol;
import com.micro1.micro1g3.repository.PermisoRepository;
import com.micro1.micro1g3.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class RolService {

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private PermisoRepository permisoRepository;

    public List<Rol> findAll() {
        return rolRepository.findAll();
    }

    public Rol findByIdRol(int idRol) {
        return rolRepository.findByIdRol(idRol);
    }

    public Rol save(Rol rol) {
        Rol existente = rolRepository.findByNombreRol(rol.getNombreRol());
        if (existente != null) {
            return existente; // Evitar duplicado
        }

        List<Permiso> permisosFinales = new ArrayList<>();
        for (Permiso permiso : rol.getPermisos()) {
            Permiso permisoExistente = permisoRepository.findByNombrePermiso(permiso.getNombrePermiso());
            if (permisoExistente != null) {
                permisosFinales.add(permisoExistente);
            } else {
                permiso.setRol(rol);
                permisosFinales.add(permiso);
            }
        }

        rol.setPermisos(permisosFinales);
        return rolRepository.save(rol);
    }

    public void deleteByIdRol(int idRol) {
        rolRepository.deleteByIdRol(idRol);
    }
}
