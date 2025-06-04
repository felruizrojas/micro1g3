package com.micro1.micro1g3.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro1.micro1g3.model.Permiso;
import com.micro1.micro1g3.service.PermisoService;

@RestController
@RequestMapping("/api/permisos")

public class PermisoController {

    @Autowired
    private PermisoService permisoService;

    @GetMapping
    public ResponseEntity<List<Permiso>> getPermisos() {
        List<Permiso> permisos = permisoService.listarPermisos();
        if (permisos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(permisos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Permiso> getPermisoPorId(@PathVariable int id) {
        Optional<Permiso> permisos = permisoService.permisoPorId(id);
        return permisos.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Permiso> crearPermiso(@RequestBody Permiso permiso) {
        Permiso permisos = permisoService.crearPermiso(permiso);
        return ResponseEntity.ok(permisos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPermiso(@PathVariable int id) {
        permisoService.eliminarPermiso(id);
        return ResponseEntity.noContent().build();
    }
}

/*04/06/2025*/