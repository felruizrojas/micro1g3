package com.micro1.micro1g3.dto;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class UsuarioDTO {
    
    private String run;
    private String nombre;
    private List<String> roles; // nombres de roles
}
