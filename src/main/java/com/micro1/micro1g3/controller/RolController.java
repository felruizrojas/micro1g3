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

import com.micro1.micro1g3.model.Rol;
import com.micro1.micro1g3.service.RolService;

@RestController
@RequestMapping("/api/roles")
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping
    public List<Rol> getAllRoles() {
        return rolService.findAll();
    }

    @GetMapping("/{idRol}")
    public Rol getRolByIdRol(@PathVariable int idRol) {
        return rolService.findByIdRol(idRol);
    }

    @PostMapping
    public Rol createRol(@RequestBody Rol rol) {
        return rolService.save(rol);
    }

    @PutMapping("/{idRol}")
    public Rol updateRol(@PathVariable int idRol, @RequestBody Rol rol) {
        rol.setIdRol(idRol);
        return rolService.save(rol);
    }

    @DeleteMapping("/{idRol}")
    public void deleteRol(@PathVariable int idRol) {
        rolService.deleteByIdRol(idRol);
    }
}
