package com.clinicaveterinaria.clinicaveterinaria.service;

import com.clinicaveterinaria.clinicaveterinaria.model.Mascota;
import java.util.List;


public interface IMascotaService {
    public void saveMascota(Mascota masco);
    public List<Mascota> getMascotas();
    public List<Mascota> getMascotasPorRaza(String cadena);
    public Mascota editMascota(Mascota masco);
    public Mascota findMascota(Long idMascota);
}
