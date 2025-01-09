/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.clinicaveterinaria.clinicaveterinaria.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MascoDuenioDTO implements Serializable{

    private static final long serialVersionUID = 1L;
    private String nombreMascota;
    private String especie;
    private String raza;
    private String nombreDuenio;
    private String apellidoDuenio;

    public MascoDuenioDTO() {
    }
    
}
