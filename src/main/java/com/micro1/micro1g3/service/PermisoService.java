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

    public Permiso save(Permiso permiso) {
        return permisoRepository.save(permiso);
    }

    public Permiso findByIdPermiso(int idPermiso) {
        return permisoRepository.findByIdPermiso(idPermiso);
    }

    public void deleteById(int idPermiso) {
        permisoRepository.deleteByIdPermiso(idPermiso);
    }
}
