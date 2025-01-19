package com.clinicaveterinaria.clinicaveterinaria.controller;

import com.clinicaveterinaria.clinicaveterinaria.dto.MascoDuenioDTO;
import com.clinicaveterinaria.clinicaveterinaria.model.Duenio;
import com.clinicaveterinaria.clinicaveterinaria.model.Mascota;
import com.clinicaveterinaria.clinicaveterinaria.service.IDuenioService;
import com.clinicaveterinaria.clinicaveterinaria.service.IMascotaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClinicaVeterinariaController {
    
    @Autowired
    private final IMascotaService ims;
    
    @Autowired
    private final IDuenioService ids;
    
    public ClinicaVeterinariaController(IMascotaService ims, IDuenioService ids) {
        this.ims = ims;
        this.ids = ids;
    }
    
    @PostMapping("/duenio/crear")
    public String crearDuenio(@RequestBody Duenio duenio){
        ids.saveDuenio(duenio);
        return ids.findDuenio(duenio.getIdDuenio()).toString();
    }
    
    @GetMapping("/duenio/traer")
    @ResponseBody
    public List<Duenio> traerDuenios(){
        return ids.getDuenios();
    }
    
    @PostMapping("/mascotas/crear")
    public String crearMascota(@RequestBody Mascota mascota){
        ims.saveMascota(mascota);
        return ims.findMascota(mascota.getIdMascota()).toString();
    }
    
    @GetMapping("/mascotas/traer")
    @ResponseBody
    public List<Mascota> traerMascotas(){
        return ims.getMascotas();
    }
    
    @GetMapping("/mascotas/traerporraza/{cadena}")
    @ResponseBody
    public List<Mascota> traerMascotaPorRaza(@PathVariable String cadena){
        return ims.getMascotasPorRaza(cadena);
    }
    
    @GetMapping("/mascotas/traerporid")
    @ResponseBody
    public MascoDuenioDTO traerDTO(@RequestParam Long idmascota){
        return ims.findMascoDuenioDTO(idmascota);
    }
    
}
