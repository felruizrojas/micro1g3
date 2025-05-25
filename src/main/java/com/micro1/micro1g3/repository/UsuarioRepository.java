package com.micro1.micro1g3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.micro1.micro1g3.model.Usuario;

@Repository

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    List<Usuario> findAll(); // Innecesario. Método que ya provee JpaRepository. Métodos ya existente por defecto en JpaRepository<Usuario, Integer>. No es necesario redefinirlo ni usar @SuppressWarnings("unchecked").

    Usuario findByIdUsuario(int idUsuario); // ---con esta bastaría

    @SuppressWarnings("unchecked")
    Usuario save(Usuario usuario); // Innecesario. Método que ya provee JpaRepository. Métodos ya existente por defecto en JpaRepository<Usuario, Integer>. No es necesario redefinirlo ni usar @SuppressWarnings("unchecked").

    void deleteByIdUsuario(int idUsuario); // ---con esta bastaría
}
