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
        // Verifica si ya existe un rol con el mismo nombre
        Rol rolExistente = rolRepository.findByNombreRol(rol.getNombreRol());
        if (rolExistente != null) {
            // Si existe, reutiliza el rol existente
            rol = rolExistente;
        } else {
            // Si no existe, guarda el nuevo rol
            rol = rolRepository.save(rol);
        }

        // Lista para almacenar los permisos actualizados
        List<Permiso> permisosActualizados = new ArrayList<>();
        for (Permiso permiso : rol.getPermisos()) {
            Permiso permisoExistente = permisoRepository.findByNombrePermiso(permiso.getNombrePermiso());
            if (permisoExistente != null) {
                permisosActualizados.add(permisoExistente);
            } else {
                permiso.setRol(rol); // Asocia el permiso nuevo al rol
                permisosActualizados.add(permiso);
            }
        }

        rol.setPermisos(permisosActualizados); // Establece la lista final de permisos
        return rolRepository.save(rol);
    }

    public void deleteByIdRol(int idRol) {
        rolRepository.deleteByIdRol(idRol);
    }
}
