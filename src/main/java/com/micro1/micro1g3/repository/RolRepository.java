package com.micro1.micro1g3.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.micro1.micro1g3.model.NombreRol;
import com.micro1.micro1g3.model.Rol;

@Repository

public interface RolRepository extends JpaRepository<Rol, Integer> {

    Optional<Rol> findByNombre(NombreRol nombre);

    @SuppressWarnings("unchecked")
    Rol save(Rol rol);
}
