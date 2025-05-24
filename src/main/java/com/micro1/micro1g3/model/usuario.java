package com.micro1.micro1g3.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity //en una entidad de intersección se crearía una clase @Data sin @Entity
       // y se le asignaría la tabla de intersección
@Table(name = "usuarios")

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    @Column(length = 13, nullable = false, unique = true)
    private String run;

    @Column(length = 50, nullable = false)
    private String nombrePrimero;

    @Column(length = 50)
    private String nombreSegundo;

    @Column(length = 50, nullable = false)
    private String apellidoPaterno;

    @Column(length = 50, nullable = false)
    private String apellidoMaterno;

    @Column(length = 100, nullable = false)
    private String correo;

    @Column(length = 250, nullable = false)
    private String direccion;

    @Column(length = 250, nullable = false)
    private String ciudad;

    @Column(length = 250, nullable = false)
    private String region;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Rol> roles = new ArrayList<>();
}
