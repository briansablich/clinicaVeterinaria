package com.clinicaveterinaria.clinicaveterinaria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Duenio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDuenio;
    private String dni;
    private String nombre;
    private String apellido;
    private String celular;
    @OneToMany(mappedBy="duenio")
    private List<Mascota> listaMascotas;

    @Override
    public String toString() {
        return "Duenio{" + "nombre=" + nombre + ", apellido=" + apellido + ", listaMascotas=" + listaMascotas + '}';
    }
    
    
}
