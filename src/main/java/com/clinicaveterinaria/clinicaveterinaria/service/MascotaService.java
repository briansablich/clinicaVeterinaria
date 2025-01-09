package com.clinicaveterinaria.clinicaveterinaria.service;

import com.clinicaveterinaria.clinicaveterinaria.model.Mascota;
import com.clinicaveterinaria.clinicaveterinaria.repository.IMascotaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MascotaService implements IMascotaService {
    
    @Autowired
    private final IMascotaRepository iMascoRepo;

    public MascotaService(IMascotaRepository iMascoRepo) {
        this.iMascoRepo = iMascoRepo;
    }
    
    
    @Override
    public void saveMascota(Mascota masco) {
        iMascoRepo.save(masco);
    }

    @Override
    public List<Mascota> getMascotas() {
        List<Mascota> listaMascotas = iMascoRepo.findAll();
        return listaMascotas;
    }

    @Override
    public List<Mascota> getMascotasPorRaza(String cadena) {
        List<Mascota> listaMascotas = iMascoRepo.findAll();
        listaMascotas.removeIf(c -> !c.getRaza().toLowerCase().contains(cadena.toLowerCase()));
        return listaMascotas;
    }

    @Override
    public Mascota editMascota(Mascota masco) {
        iMascoRepo.save(masco);
        return iMascoRepo.findById(masco.getIdMascota()).orElse(null);
    }

    @Override
    public Mascota findMascota(Long idMascota) {
        return iMascoRepo.findById(idMascota).orElse(null);
    }

}
