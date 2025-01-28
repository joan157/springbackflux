package edu.cibertec.service;

import edu.cibertec.entity.PersonaEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonaService {
    
      public Flux<PersonaEntity> listarPersona();
      public Flux<PersonaEntity> listarPersonaporedadmayora22();
      public Mono<PersonaEntity> findByIdpersona(Integer idpersona);

      public Flux<PersonaEntity> listarPersonaxnombre(String nombre);

      public abstract Mono<Integer> cantidadNombre(String nombre);
      public abstract Flux<PersonaEntity> listarpersonaporrangoedad(Integer edadmin, Integer edadmax);
      
      public abstract Mono<PersonaEntity> insertarPersona(PersonaEntity personaMonito);



}



