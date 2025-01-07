package edu.cibertec.service;

import edu.cibertec.entity.PersonaEntity;
import reactor.core.publisher.Flux;

public interface PersonaService {
    
      public Flux<PersonaEntity> listarPersona();
}



