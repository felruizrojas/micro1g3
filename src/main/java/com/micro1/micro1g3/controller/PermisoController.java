package com.micro1.micro1g3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.micro1.micro1g3.model.Permiso;
import com.micro1.micro1g3.service.PermisoService;

@RestController
@RequestMapping("/api/permisos")

public class PermisoController {

    @Autowired
    private PermisoService permisoService;

    @GetMapping
    public ResponseEntity<List<Permiso>> getAll() {
        List<Permiso> permisos = permisoService.findAll();
        if (!permisos.isEmpty()) {
            return new ResponseEntity<>(permisos, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<Permiso> save(@RequestBody Permiso permiso) {
        Permiso encontrado = permisoService.findByIdPermiso(permiso.getIdPermiso());
        if (encontrado == null) {
            return new ResponseEntity<>(permisoService.save(permiso), HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
        }
    }

    @GetMapping("/idPermiso/{idPermiso}")
    public ResponseEntity<Permiso> getById(@PathVariable int id) {
        Permiso permiso = permisoService.findByIdPermiso(id);
        if (permiso != null) {
            return new ResponseEntity<>(permiso, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/idPermiso/{idPermiso}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        Permiso permiso = permisoService.findByIdPermiso(id);
        if (permiso != null) {
            permisoService.deleteByIdPermiso(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
