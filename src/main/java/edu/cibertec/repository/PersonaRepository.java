package edu.cibertec.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import edu.cibertec.entity.PersonaEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface PersonaRepository extends ReactiveCrudRepository<PersonaEntity,Integer>{
    
    public Flux<PersonaEntity> findAll();
    public Mono<PersonaEntity> findByIdpersona(Integer idpersona);

     // Consulta personalizada usando @Query
    /*@Query("SELECT * FROM persona_entity WHERE nombre = :nombre")
    Flux<PersonaEntity> findByNombre(@Param("nombre") String nombre);*/
        

}
