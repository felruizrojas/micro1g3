package com.micro1.micro1g3.dto;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class RolDTO {
    private String nombre; // o NombreRol
    private List<String> permisos;
}
