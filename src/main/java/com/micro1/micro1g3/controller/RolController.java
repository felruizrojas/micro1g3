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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.micro1.micro1g3.dto.RolDTO;
import com.micro1.micro1g3.model.Rol;
import com.micro1.micro1g3.service.RolService;

@RestController
@RequestMapping("/api/roles")
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping
    public ResponseEntity<List<Rol>> getRoles() {
        List<Rol> roles = rolService.listarRoles();
        if (roles.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rol> getRolPorId(@PathVariable int id) {
        Optional<Rol> roles = rolService.rolPorId(id);
        return roles.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Rol> crearRol(@RequestBody RolDTO rolDTO) {
        Rol nuevoRol = rolService.crearRolDesdeDTO(rolDTO);
        return ResponseEntity.ok(nuevoRol);
    }

    @PutMapping("/{id}/asignarPermiso")
    public ResponseEntity<Rol> asignarPermiso(@PathVariable int id, @RequestParam String permisoNombre) {
        Rol actualizado = rolService.asignarPermiso(id, permisoNombre);
        return actualizado != null ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRol(@PathVariable int id) {
        rolService.eliminarRol(id);
        return ResponseEntity.noContent().build();
    }
}
