package com.micro1.micro1g3.service;

import com.micro1.micro1g3.model.Rol;
import com.micro1.micro1g3.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    public List<Rol> findAll() {
        return rolRepository.findAll();
    }

    public Rol save(Rol rol) {
        return rolRepository.save(rol);
    }

    public Rol findByIdRol(int idRol) {
        return rolRepository.findByIdRol(idRol);
    }

    public void deleteByIdRol(int idRol) {
        rolRepository.deleteByIdRol(idRol);
    }
}