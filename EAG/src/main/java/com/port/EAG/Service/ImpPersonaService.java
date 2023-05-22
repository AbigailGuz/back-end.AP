/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.port.EAG.Service;

import com.port.EAG.Entity.Persona;
import com.port.EAG.Interface.IPersonaService;
import com.port.EAG.Repository.IpersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpPersonaService implements IPersonaService{
@Autowired IpersonaRepository iPersonaRepository;
   
    @Override
    public List<Persona> getPersona() {
        List<Persona> persona = iPersonaRepository.findAll();
    return persona;
    }

    @Override
    public void savePersona(Persona persona) {
    iPersonaRepository.save(persona);
            }

    @Override
    public void deletePersona(Long id) {
      iPersonaRepository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
       Persona persona =  iPersonaRepository.findById(id).orElse(null);
       return persona;
    }

    
}
