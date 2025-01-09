package com.clinicaveterinaria.clinicaveterinaria.service;

import com.clinicaveterinaria.clinicaveterinaria.model.Duenio;
import java.util.List;


public interface IDuenioService {
    public void saveDuenio(Duenio duen);
    public List<Duenio> getDuenios();
    public Duenio editDuenio(Duenio duen);
    public Duenio findDuenio(Long idDuenio);
}
