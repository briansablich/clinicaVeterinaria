package com.clinicaveterinaria.clinicaveterinaria.repository;

import com.clinicaveterinaria.clinicaveterinaria.model.Duenio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDuenioRepository extends JpaRepository<Duenio, Long>{
    
}
