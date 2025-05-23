package com.micro1.micro1g3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.micro1.micro1g3.model.Usuario;

@Repository

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    List<Usuario> findAll();

    @SuppressWarnings("unchecked")
    Usuario save(Usuario usuario);

    // ----- idUsuario -----

    Usuario findByIdUsuario(int idUsuario);

    void deleteByIdUsuario(int idUsuario);
}
