package com.micro1.micro1g3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.micro1.micro1g3.model.Rol;
import com.micro1.micro1g3.service.RolService;

@RestController
@RequestMapping("/api/roles")

public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping
    public ResponseEntity<List<Rol>> getAll() {
        List<Rol> roles = rolService.findAll();
        if (!roles.isEmpty()) {
            return new ResponseEntity<>(roles, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<Rol> save(@RequestBody Rol rol) {
        Rol encontrado = rolService.findByIdRol(rol.getIdRol());
        if (encontrado == null) {
            return new ResponseEntity<>(rolService.save(rol), HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
        }
    }

    @GetMapping("/idRol/{idRol}")
    public ResponseEntity<Rol> getById(@PathVariable int id) {
        Rol rol = rolService.findByIdRol(id);
        if (rol != null) {
            return new ResponseEntity<>(rol, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/idRol/{idRol}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        Rol rol = rolService.findByIdRol(id);
        if (rol != null) {
            rolService.deleteByIdRol(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
