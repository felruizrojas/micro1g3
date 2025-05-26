package com.micro1.micro1g3.service;

import com.micro1.micro1g3.model.Permiso;
import com.micro1.micro1g3.model.Rol;
import com.micro1.micro1g3.model.Usuario;
import com.micro1.micro1g3.repository.PermisoRepository;
import com.micro1.micro1g3.repository.RolRepository;
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
}
