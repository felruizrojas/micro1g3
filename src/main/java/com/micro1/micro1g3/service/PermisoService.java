package com.micro1.micro1g3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro1.micro1g3.model.Permiso;
import com.micro1.micro1g3.repository.PermisoRepository;

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

    public void deleteByIdPermiso(int idPermiso) {
        permisoRepository.deleteByIdPermiso(idPermiso);
    }
}
