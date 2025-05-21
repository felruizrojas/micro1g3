package com.micro1.micro1g3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro1.micro1g3.model.Usuario;
import com.micro1.micro1g3.service.UsuarioService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/usuarios")

public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> getUsuarios() {
        List<Usuario> usuarios = usuarioService.findAll();
        if (!usuarios.isEmpty()) {
            return new ResponseEntity<>(usuarios, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // -------------------------------------------------- POR RUN --------------------------------------------------

    @GetMapping("/run/{run}")
    public ResponseEntity<Usuario> getUsuarioByRun(@PathVariable String run) {
        Usuario usuario = usuarioService.findByRun(run);
        if (usuario != null) {
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Usuario> postUsuario(@RequestBody Usuario usuario) {
        Usuario buscado = usuarioService.findByRun(usuario.getRun());
        if (buscado == null) {
            return new ResponseEntity<>(usuarioService.save(usuario), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/run/{run}")
    public ResponseEntity<Usuario> updateUsuarioByRun(@PathVariable String run, @RequestBody Usuario usuario) {
        Usuario existente = usuarioService.findByRun(run);
        if (existente != null) {
            existente.setNombrePrimero(usuario.getNombrePrimero());
            existente.setNombreSegundo(usuario.getNombreSegundo());
            existente.setApellidoPaterno(usuario.getApellidoPaterno());
            existente.setApellidoMaterno(usuario.getApellidoMaterno());
            existente.setCorreo(usuario.getCorreo());
            existente.setDireccion(usuario.getDireccion());
            return new ResponseEntity<>(usuarioService.save(existente), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/run/{run}")
    public ResponseEntity<Void> deleteUsuarioByRun(@PathVariable String run) {
        Usuario existente = usuarioService.findByRun(run);
        if (existente != null) {
            usuarioService.deleteByRun(run);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // -------------------------------------------------- POR ID --------------------------------------------------

    @GetMapping("/idUsuario/{idUsuario}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable int idUsuario) {
        Usuario usuario = usuarioService.findByIdUsuario(idUsuario);
        if (usuario != null) {
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/idUsuario/{idUsuario}")
    public ResponseEntity<Usuario> updateUsuarioById(@PathVariable int idUsuario, @RequestBody Usuario usuario) {
        Usuario existente = usuarioService.findByIdUsuario(idUsuario);
        if (existente != null) {
            existente.setNombrePrimero(usuario.getNombrePrimero());
            existente.setNombreSegundo(usuario.getNombreSegundo());
            existente.setApellidoPaterno(usuario.getApellidoPaterno());
            existente.setApellidoMaterno(usuario.getApellidoMaterno());
            existente.setCorreo(usuario.getCorreo());
            existente.setDireccion(usuario.getDireccion());
            return new ResponseEntity<>(usuarioService.save(existente), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/idUsuario/{idUsuario}")
    public ResponseEntity<Void> deleteUsuarioById(@PathVariable int idUsuario) {
        Usuario existente = usuarioService.findByIdUsuario(idUsuario);
        if (existente != null) {
            usuarioService.deleteById(idUsuario);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

//SE DEBEN AGREGAR OTROS METODOS