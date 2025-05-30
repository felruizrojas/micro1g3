package com.micro1.micro1g3.service;

import com.micro1.micro1g3.dto.RolDTO;
import com.micro1.micro1g3.model.Permiso;
import com.micro1.micro1g3.model.Rol;
import com.micro1.micro1g3.repository.PermisoRepository;
import com.micro1.micro1g3.repository.RolRepository;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private PermisoRepository permisoRepository;

    public List<Rol> listarRoles() {
        return rolRepository.findAll();
    }

    public Optional<Rol> rolPorId(int id) {
        return rolRepository.findById(id);
    }

    public Rol crearRolDesdeDTO(RolDTO rolDTO) {
        Rol rol = new Rol();
        rol.setNombre(rolDTO.getNombre());
        List<Permiso> permisosAsociados = new ArrayList<>();
        if (rolDTO.getPermisos() != null && !rolDTO.getPermisos().isEmpty()) {
            for (String nombrePermiso : rolDTO.getPermisos()) {
                Permiso permiso = permisoRepository.findByNombre(nombrePermiso.trim())
                        .orElseGet(() -> {
                            Permiso nuevoPermiso = new Permiso();
                            nuevoPermiso.setNombre(nombrePermiso.trim());
                            return permisoRepository.save(nuevoPermiso);
                        });
                permisosAsociados.add(permiso);
            }
        }
        rol.setPermisos(permisosAsociados);
        return rolRepository.save(rol);
    }

    public Rol asignarPermiso(int rolId, String permisoNombre) {
        Optional<Rol> rolOpt = rolRepository.findById(rolId);
        if (rolOpt.isEmpty()) {
            return null;
        }
        Rol rol = rolOpt.get();
        Permiso permiso = permisoRepository.findByNombre(permisoNombre.trim())
                .orElseGet(() -> {
                    Permiso nuevoPermiso = new Permiso();
                    nuevoPermiso.setNombre(permisoNombre.trim());
                    return permisoRepository.save(nuevoPermiso);
                });
        if (!rol.getPermisos().contains(permiso)) {
            rol.getPermisos().add(permiso);
        }
        return rolRepository.save(rol);
    }

    @Transactional
    public void eliminarRol(int id) {
        Optional<Rol> rolOpt = rolRepository.findById(id);
        if (rolOpt.isPresent()) {
            Rol rol = rolOpt.get();
            rol.getUsuarios().forEach(usuario -> usuario.getRoles().remove(rol));
            rol.getUsuarios().clear();
            rol.getPermisos().clear();
            rolRepository.delete(rol);
        }
    }
}
