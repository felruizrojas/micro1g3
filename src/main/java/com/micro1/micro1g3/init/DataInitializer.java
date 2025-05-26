package com.micro1.micro1g3.init;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.micro1.micro1g3.model.NombreRol;
import com.micro1.micro1g3.model.Rol;
import com.micro1.micro1g3.repository.RolRepository;

import jakarta.annotation.PostConstruct;

@Component

public class DataInitializer {

    @Autowired
    private RolRepository rolRepository;

    @PostConstruct
    public void initRoles() {
        for (NombreRol nombreRol : NombreRol.values()) {
            rolRepository.findByNombre(nombreRol)
                    .orElseGet(() -> rolRepository.save(new Rol(0, nombreRol, new ArrayList<>(), new ArrayList<>())));
        }
    }
}