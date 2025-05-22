package com.micro1.micro1g3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro1.micro1g3.model.Usuario;
import com.micro1.micro1g3.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")

public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    // ----- general -----

    @GetMapping
    public ResponseEntity<List<Usuario>> getUsuarios() {
        List<Usuario> usuarios = usuarioService.findAll();
        if (usuarios.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Usuario> postUsuario(@RequestBody Usuario usuario) {
        Usuario newUsuario = usuarioService.save(usuario);
        if (newUsuario == null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(usuario, HttpStatus.CREATED);
    }

    // ----- idUsuario -----

    @GetMapping("/idUsuario/{idUsuario}")
    public ResponseEntity<Usuario> getUsuarioPorId(@PathVariable int idUsuario) {
        Usuario usuario = usuarioService.findByIdUsuario(idUsuario);
        if (usuario == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @PatchMapping("/idUsuario/{idUsuario}")
    public ResponseEntity<Usuario> updateById(@PathVariable int idUsuario, @RequestBody Usuario usuario) {
        Usuario updateUsuario = usuarioService.findByIdUsuario(idUsuario);
        if (updateUsuario == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (usuario.getNombrePrimero() != null) {
            updateUsuario.setNombrePrimero(usuario.getNombrePrimero());
        }
        if (usuario.getNombreSegundo() != null) {
            updateUsuario.setNombreSegundo(usuario.getNombreSegundo());
        }
        if (usuario.getApellidoPaterno() != null) {
            updateUsuario.setApellidoPaterno(usuario.getApellidoPaterno());
        }
        if (usuario.getApellidoMaterno() != null) {
            updateUsuario.setApellidoMaterno(usuario.getApellidoMaterno());
        }
        if (usuario.getCorreo() != null) {
            updateUsuario.setCorreo(usuario.getCorreo());
        }
        if (usuario.getDireccion() != null) {
            updateUsuario.setDireccion(usuario.getDireccion());
        }
        if (usuario.getRol() != null) {
            updateUsuario.setRol(usuario.getRol());
        }
        usuarioService.save(updateUsuario);
        return ResponseEntity.ok(updateUsuario);
    }

    @DeleteMapping("/idUsuario/{idUsuario}")
    public ResponseEntity<Void> deleteById(@PathVariable("idUsuario") int idUsuario) {
        Usuario deleteUsuario = usuarioService.findByIdUsuario(idUsuario);
        if (deleteUsuario == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        usuarioService.deleteById(idUsuario);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // ----- run -----

    @GetMapping("/run/{run}")
    public ResponseEntity<Usuario> getUsuarioPorRun(@PathVariable String run) {
        Usuario usuario = usuarioService.findByRun(run);
        if (usuario == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @PatchMapping("/run/{run}")
    public ResponseEntity<Usuario> updateByRun(@PathVariable String run, @RequestBody Usuario usuario) {
        Usuario updateUsuario = usuarioService.findByRun(run);
        if (updateUsuario == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (usuario.getNombrePrimero() != null) {
            updateUsuario.setNombrePrimero(usuario.getNombrePrimero());
        }
        if (usuario.getNombreSegundo() != null) {
            updateUsuario.setNombreSegundo(usuario.getNombreSegundo());
        }
        if (usuario.getApellidoPaterno() != null) {
            updateUsuario.setApellidoPaterno(usuario.getApellidoPaterno());
        }
        if (usuario.getApellidoMaterno() != null) {
            updateUsuario.setApellidoMaterno(usuario.getApellidoMaterno());
        }
        if (usuario.getCorreo() != null) {
            updateUsuario.setCorreo(usuario.getCorreo());
        }
        if (usuario.getDireccion() != null) {
            updateUsuario.setDireccion(usuario.getDireccion());
        }
        if (usuario.getRol() != null) {
            updateUsuario.setRol(usuario.getRol());
        }
        usuarioService.save(updateUsuario);
        return ResponseEntity.ok(updateUsuario);
    }

    @DeleteMapping("/run/{run}")
    public ResponseEntity<Void> deleteByRun(@PathVariable("run") String run) {
        Usuario deleteUsuario = usuarioService.findByRun(run);
        if (deleteUsuario == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        usuarioService.deleteByRun(run);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
