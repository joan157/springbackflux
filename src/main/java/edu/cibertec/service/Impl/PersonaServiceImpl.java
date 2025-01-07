package edu.cibertec.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cibertec.entity.PersonaEntity;
import edu.cibertec.repository.PersonaRepository;
import edu.cibertec.service.PersonaService;
import reactor.core.publisher.Flux;

@Service
public class PersonaServiceImpl implements PersonaService{

    @Autowired
    PersonaRepository personaRepository;


    @Override
    public Flux<PersonaEntity> listarPersona() {
       return personaRepository.findAll();
    }
    
}
