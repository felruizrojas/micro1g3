package com.micro1.micro1g3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.micro1.micro1g3.model.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {

    List<Rol> findAll();

    Rol save(Rol rol);

    Rol findByIdRol(int idRol);

    void deleteByIdRol(int idRol);
}
