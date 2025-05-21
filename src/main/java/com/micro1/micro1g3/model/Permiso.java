package com.micro1.micro1g3.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "permisos")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Permiso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPermiso;

    @Column(length = 50, nullable = false, unique = true)
    private String nombrePermiso;

    @ManyToMany(mappedBy = "permisos", fetch = FetchType.LAZY)
    private List<Rol> roles;
}

// con toda la fe