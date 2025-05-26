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

    /**
     * Lista todos los roles existentes.
     */
    public List<Rol> listarRoles() {
        return rolRepository.findAll();
    }

    /**
     * Busca un rol por su ID.
     */
    public Optional<Rol> rolPorId(int id) {
        return rolRepository.findById(id);
    }

    /**
     * Crea un nuevo rol a partir de un DTO.
     * Si los permisos no existen, se crean.
     */
    public Rol crearRolDesdeDTO(RolDTO rolDTO) {
        Rol rol = new Rol();
        rol.setNombre(rolDTO.getNombre());

        List<Permiso> permisosAsociados = new ArrayList<>();

        if (rolDTO.getPermisos() != null && !rolDTO.getPermisos().isEmpty()) {
            for (String nombrePermiso : rolDTO.getPermisos()) {
                Permiso permiso = permisoRepository.findByNombre(nombrePermiso.trim())
                        .orElseGet(() -> {
                            // Crear nuevo permiso si no existe
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

    /**
     * Elimina un rol por su ID y limpia las relaciones.
     */
    @Transactional
    public void eliminarRol(int id) {
        Optional<Rol> rolOpt = rolRepository.findById(id);
        if (rolOpt.isPresent()) {
            Rol rol = rolOpt.get();

            // Limpiar relaciones con usuarios
            rol.getUsuarios().forEach(usuario -> usuario.getRoles().remove(rol));
            rol.getUsuarios().clear();

            // Limpiar relaciones con permisos
            rol.getPermisos().clear();

            rolRepository.delete(rol);
        }
    }
}
