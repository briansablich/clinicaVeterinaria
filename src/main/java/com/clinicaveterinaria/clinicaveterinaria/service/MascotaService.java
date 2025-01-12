package com.clinicaveterinaria.clinicaveterinaria.service;

import com.clinicaveterinaria.clinicaveterinaria.dto.MascoDuenioDTO;
import com.clinicaveterinaria.clinicaveterinaria.model.Duenio;
import com.clinicaveterinaria.clinicaveterinaria.model.Mascota;
import com.clinicaveterinaria.clinicaveterinaria.repository.IMascotaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MascotaService implements IMascotaService {
    
    @Autowired
    private final IMascotaRepository iMascoRepo;
    
    @Autowired
    private final IDuenioService iDuenioServ;

    public MascotaService(IMascotaRepository iMascoRepo, IDuenioService iDuenioServ) {
        this.iMascoRepo = iMascoRepo;
        this.iDuenioServ = iDuenioServ;
    }
    
    
    @Override
    public void saveMascota(Mascota masco) {
        Duenio duenioAux = iDuenioServ.findDuenio(masco.getDuenio().getIdDuenio());
        masco.setDuenio(duenioAux);
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

    @Override
    public MascoDuenioDTO findMascoDuenioDTO(Long idMascota) {
        Mascota mascoAux = iMascoRepo.findById(idMascota).orElse(null);
        if(mascoAux == null){
            return null;
        } else {
            MascoDuenioDTO mdDTO = new MascoDuenioDTO();
            mdDTO.setApellidoDuenio(mascoAux.getDuenio().getApellido());
            mdDTO.setNombreDuenio(mascoAux.getDuenio().getNombre());
            mdDTO.setEspecie(mascoAux.getEspecie());
            mdDTO.setRaza(mascoAux.getRaza());
            mdDTO.setNombreMascota(mascoAux.getNombre());
            return mdDTO;
        }
    }

    @Override
    public void deleteMascota(Long idMascota) {
        iMascoRepo.deleteById(idMascota);
    }

}
