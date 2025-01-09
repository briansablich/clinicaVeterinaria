package com.clinicaveterinaria.clinicaveterinaria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMascota;
    private String nombre;
    private String especie;
    private String raza;
    private String color;
    @ManyToOne
    @JoinColumn(name="idMascota")
    private Duenio duenio;
    
}
