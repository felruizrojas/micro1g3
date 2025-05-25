package com.micro1.micro1g3.service;

import com.micro1.micro1g3.model.Permiso;
import com.micro1.micro1g3.repository.PermisoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermisoService {

    @Autowired
    private PermisoRepository permisoRepository;

    public List<Permiso> findAll() {
        return permisoRepository.findAll();
    }

    public Permiso findByIdPermiso(int idPermiso) {
        return permisoRepository.findByIdPermiso(idPermiso);
    }

    public Permiso save(Permiso permiso) {
        Permiso existente = permisoRepository.findByNombrePermiso(permiso.getNombrePermiso());
        if (existente != null) {
            return existente; // Evitar duplicado
        }

        return permisoRepository.save(permiso);
    }

    public void deleteByIdPermiso(int idPermiso) {
        permisoRepository.deleteByIdPermiso(idPermiso);
    }
}
