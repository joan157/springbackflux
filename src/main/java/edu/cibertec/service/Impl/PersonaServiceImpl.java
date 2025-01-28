package edu.cibertec.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cibertec.entity.PersonaEntity;
import edu.cibertec.repository.PersonaRepository;
import edu.cibertec.service.PersonaService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonaServiceImpl implements PersonaService{

    @Autowired
    PersonaRepository personaRepository;


    @Override
    public Flux<PersonaEntity> listarPersona() {
       return personaRepository.findAll();
    }


   @Override
   public Flux<PersonaEntity> listarPersonaporedadmayora22() {
      return personaRepository.findAll()
                  .filter(p -> p.getEdad()>22);                      
      
   }


   @Override
   public Mono<PersonaEntity> findByIdpersona(Integer idpersona) {
      return personaRepository.findAll()
                              .filter(dato -> dato.getIdpersona().equals(idpersona))
                              .map(persona -> new PersonaEntity(idpersona, persona.getNombre(), 
                                                                  persona.getApellido(), persona.getEdad()))
                              .next();
   }


   @Override
   public Flux<PersonaEntity> listarPersonaxnombre(String nombre) {
      return personaRepository.findAll()
                              .filter(dato -> dato.getNombre().equalsIgnoreCase(nombre)); // equalIgnoreCase, ignora si es minuscula o mayus
                               

   }


   @Override
   public Mono<Integer> cantidadNombre(String nombre) {
      return personaRepository.findAll()
                              .filter(dato -> dato.getNombre().equalsIgnoreCase(nombre))
                              .count()
                              .map(Long::intValue); //conviertiendo de long a int
   }


   @Override
   public Flux<PersonaEntity> listarpersonaporrangoedad(Integer edadmin, Integer edadmax) {
     
        return personaRepository.findAll()
                                .filter(dato -> dato.getEdad()>=edadmin && dato.getEdad()<=edadmax); 

   }


   @Override
   public Mono<PersonaEntity> insertarPersona(PersonaEntity persona) {
      return personaRepository.save(persona)
                              .doOnSuccess(guardarpersona -> 
                                       System.out.println("Persona Gurdada Correctamente "+ 
                                       guardarpersona))
                              .doOnError(error -> 
                                       System.err.println("Error al gurdar -> "+
                                       error));
                              /*
                                 Accciones secundarias:
                               * son operadores de Reactive Streams 
                               * proporcionados por el proyecto Reactor, que es la base de WebFlux.
                               */
  
                            /*  2 .onErrorResume(e -> {
                                 // Log or handle the error
                                 return Mono.error(new CustomException("Error saving persona"));


                                 .onErrorResume: Este operador permite capturar un error
                                  y luego proporcionar un Mono o Flux alternativo en su lugar.
                                  .doOnError: Este operador permite ejecutar una acción secundaria (como registrar un mensaje de log)
                                   cuando ocurre un error, pero no cambia el flujo de datos en sí.
                             });
                           */
  
                              }                 
   
   




    // patron de concurrencia?
     // reguer , reverh
     // consulta anidada
     // escalabilidad lo mas sencillo de vertical horizontal.
     // patron triple para prueba, shell patron
     // wilder patron , factory patron de software
     // refactorizacion
     // que es pailas

    
}
