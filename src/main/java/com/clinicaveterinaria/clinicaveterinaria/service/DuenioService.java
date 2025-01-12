package com.clinicaveterinaria.clinicaveterinaria.service;

import com.clinicaveterinaria.clinicaveterinaria.model.Duenio;
import com.clinicaveterinaria.clinicaveterinaria.repository.IDuenioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DuenioService implements IDuenioService{

    @Autowired
    private final IDuenioRepository iDueRepo;

    public DuenioService(IDuenioRepository iDueRepo) {
        this.iDueRepo = iDueRepo;
    }
    
    @Override
    public void saveDuenio(Duenio duen) {
        iDueRepo.save(duen);
    }

    @Override
    public List<Duenio> getDuenios() {
        List<Duenio> listaDuenios = iDueRepo.findAll();
        return listaDuenios;
    }

    @Override
    public Duenio editDuenio(Duenio duen) {
        iDueRepo.save(duen);
        return iDueRepo.findById(duen.getIdDuenio()).orElse(null);
    }

    @Override
    public Duenio findDuenio(Long idDuenio) {
        return iDueRepo.findById(idDuenio).orElse(null);
    }

    @Override
    public void deleteDuenio(Long idDuenio) {
        iDueRepo.deleteById(idDuenio);
    }

}
