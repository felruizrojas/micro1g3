package com.micro1.micro1g3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    public List<Permiso> getAllPermisos() {
        return permisoService.findAll();
    }

    @GetMapping("/{idPermiso}")
    public Permiso getPermisoByIdPermiso(@PathVariable int idPermiso) {
        return permisoService.findByIdPermiso(idPermiso);
    }

    @PostMapping
    public Permiso createPermiso(@RequestBody Permiso permiso) {
        return permisoService.save(permiso);
    }

    @PutMapping("/{idPermiso}")
    public Permiso updatePermiso(@PathVariable int idPermiso, @RequestBody Permiso permiso) {
        permiso.setIdPermiso(idPermiso);
        return permisoService.save(permiso);
    }

    @DeleteMapping("/{idPermiso}")
    public void deletePermiso(@PathVariable int idPermiso) {
        permisoService.deleteByIdPermiso(idPermiso);
    }
}
