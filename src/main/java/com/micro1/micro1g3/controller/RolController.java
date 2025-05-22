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

import com.micro1.micro1g3.model.Rol;
import com.micro1.micro1g3.service.RolService;

@RestController
@RequestMapping("/api/roles")
public class RolController {

    @Autowired
    private RolService rolService;

    // ----- general -----

    @GetMapping
    public ResponseEntity<List<Rol>> getRoles() {
        List<Rol> roles = rolService.findAll();
        if (roles.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Rol> postRol(@RequestBody Rol rol) {
        Rol newRol = rolService.save(rol);
        if (newRol == null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(newRol, HttpStatus.CREATED);
    }

    // ----- idRol -----

    @GetMapping("/idRol/{idRol}")
    public ResponseEntity<Rol> getRolPorId(@PathVariable int idRol) {
        Rol rol = rolService.findByIdRol(idRol);
        if (rol == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(rol, HttpStatus.OK);
    }

    @PatchMapping("/idRol/{idRol}")
    public ResponseEntity<Rol> updateById(@PathVariable int idRol, @RequestBody Rol rol) {
        Rol updateRol = rolService.findByIdRol(idRol);
        if (updateRol == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (rol.getNombreRol() != null) {
            updateRol.setNombreRol(rol.getNombreRol());
        }
        if (rol.getPermisos() != null) {
            updateRol.setPermisos(rol.getPermisos());
        }

        rolService.save(updateRol);
        return ResponseEntity.ok(updateRol);
    }

    @DeleteMapping("/idRol/{idRol}")
    public ResponseEntity<Void> deleteById(@PathVariable int idRol) {
        Rol deleteRol = rolService.findByIdRol(idRol);
        if (deleteRol == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        rolService.deleteById(idRol);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
