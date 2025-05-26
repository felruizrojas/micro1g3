package com.micro1.micro1g3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.micro1.micro1g3.model.Permiso;

@Repository

public interface PermisoRepository extends JpaRepository<Permiso, Integer> {

}
