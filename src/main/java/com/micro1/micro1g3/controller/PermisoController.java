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

import com.micro1.micro1g3.model.Permiso;
import com.micro1.micro1g3.model.Rol;
import com.micro1.micro1g3.service.PermisoService;

@RestController
@RequestMapping("/api/permisos")

public class PermisoController {

    @Autowired
    private PermisoService permisoService;

    // ----- general -----

    @GetMapping
    public ResponseEntity<List<Permiso>> getPermisos() {
        List<Permiso> permisos = permisoService.findAll();
        if (permisos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(permisos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Permiso> postPermiso(@RequestBody Permiso permiso) {
        Permiso newPermiso = permisoService.save(permiso);
        if (newPermiso == null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(newPermiso, HttpStatus.CREATED);
    }

    // ----- idPermiso -----

    @GetMapping("/idPermiso/{idPermiso}")
    public ResponseEntity<Permiso> getPermisoPorId(@PathVariable int idPermiso) {
        Permiso permiso = permisoService.findByIdPermiso(idPermiso);
        if (permiso == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(permiso, HttpStatus.OK);
    }

    @PatchMapping("/idPermiso/{idPermiso}")
    public ResponseEntity<Permiso> updateById(@PathVariable int idPermiso, @RequestBody Permiso permiso) {
        Permiso updatePermiso = permisoService.findByIdPermiso(idPermiso);
        if (updatePermiso == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (permiso.getNombrePermiso() != null) {
            updatePermiso.setNombrePermiso(permiso.getNombrePermiso());
        }

        if (permiso.getRoles() != null) {
            for (Rol rol : permiso.getRoles()) {
                rol.getPermisos().add(updatePermiso); // Asegura relación inversa
            }
            updatePermiso.setRoles(permiso.getRoles());
        }

        permisoService.save(updatePermiso);
        return ResponseEntity.ok(updatePermiso);
    }

    @DeleteMapping("/idPermiso/{idPermiso}")
    public ResponseEntity<Void> deleteById(@PathVariable("idPermiso") int idPermiso) {
        Permiso deletePermiso = permisoService.findByIdPermiso(idPermiso);
        if (deletePermiso == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        permisoService.deleteById(idPermiso);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

