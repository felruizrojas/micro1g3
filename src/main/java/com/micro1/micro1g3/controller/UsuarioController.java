package com.micro1.micro1g3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro1.micro1g3.model.Rol;
import com.micro1.micro1g3.model.Usuario;
import com.micro1.micro1g3.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")

public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return usuarioService.findAll();
    }

    @GetMapping("/{idUsuario}")
    public Usuario getUsuarioByIdUsuario(@PathVariable int idUsuario) {
        return usuarioService.findByIdUsuario(idUsuario);
    }

    @PostMapping
    public ResponseEntity<Usuario> saveUsuario(@RequestBody Usuario usuario) {
        Usuario nuevoUsuario = usuarioService.save(usuario);
        return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED);
    }

    @PutMapping("/{idUsuario}")
    public Usuario updateUsuario(@PathVariable int idUsuario, @RequestBody Usuario usuario) {
        usuario.setIdUsuario(idUsuario);
        return usuarioService.save(usuario);
    }

    @DeleteMapping("/{idUsuario}")
    public void deleteUsuario(@PathVariable int idUsuario) {
        usuarioService.deleteByIdUsuario(idUsuario);
    }
}
