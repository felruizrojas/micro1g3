package com.micro1.micro1g3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.micro1.micro1g3.model.Permiso;

@Repository

public interface PermisoRepository extends JpaRepository<Permiso, Integer> {

    List<Permiso> findAll();

    Permiso findByIdPermiso(int idPermiso);

    Permiso findByNombrePermiso(String nombrePermiso);
    
    @SuppressWarnings("unchecked")
    Permiso save(Permiso permiso);

    void deleteByIdPermiso(int idPermiso);
}
