package com.micro1.micro1g3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro1.micro1g3.model.Rol;
import com.micro1.micro1g3.repository.RolRepository;

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

    public Rol findById(int idRol) {
        return rolRepository.findByIdRol(idRol); // 👈 uso directo sin Optional
    }
}
