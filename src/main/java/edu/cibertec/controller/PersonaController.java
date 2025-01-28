package edu.cibertec.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.cibertec.entity.PersonaEntity;
import edu.cibertec.service.PersonaService;
import jakarta.validation.Valid;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



@RestController
@RequestMapping("api/v1/productor")
public class PersonaController {

    @Autowired
    private PersonaService productoService;

    @GetMapping
    public Flux<PersonaEntity> listarPersona(){
        return productoService.listarPersona();
    }
    @GetMapping("/mayor22")
    public Flux<PersonaEntity> listarPersonamayoresa22(){
        return productoService.listarPersonaporedadmayora22();
    }

    @GetMapping("/{idpersona}")
    public Mono<PersonaEntity> obtenerPersona(@PathVariable Integer idpersona) {
        return productoService.findByIdpersona(idpersona);
    }
    
    @GetMapping("/buscarnombre")
    public Flux<PersonaEntity> obtenerPersona(@RequestParam String nombre) {
        return productoService.listarPersonaxnombre(nombre);
    }

    @GetMapping("/cantidad")
    public Mono<Integer> obtenerCantidadxNombre(@RequestParam String nombre) {
        return productoService.cantidadNombre(nombre);
    }
    @GetMapping("/cantidadjson")
    public Mono<Map<String, Integer>> obtenerCantidadxNombrejson(@RequestParam String nombre) {
          return productoService.cantidadNombre(nombre)
                          .map(cantidad -> {
                              Map<String, Integer> response = new HashMap<>();
                              response.put("cantidad", cantidad);
                              return response;
                          });
    }

    @PostMapping
    public Mono<ResponseEntity<PersonaEntity>> agregarPersona(@Valid @RequestBody PersonaEntity persona) {
        return productoService.insertarPersona(persona)
        //.map(savedPersona -> ResponseEntity.ok(savedPersona))
            .map( savedPersona -> ResponseEntity.status(HttpStatus.CREATED).body(savedPersona)) //
            .onErrorResume(error -> {
                if (error instanceof org.springframework.web.bind.support.WebExchangeBindException) {
                    // Este error ocurre si la validación falla (@Valid)
                    return Mono.just(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null));
                }else if (error instanceof DataIntegrityViolationException) {
                    // Manejo de conflicto por violación de integridad (409 Conflict)
                    return Mono.just(ResponseEntity.status(HttpStatus.CONFLICT).body(null));
              } else {
                    // Otros errores internos
                    return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
                }
            });
    }
    /*
     * HTTP 201 Created: Se usa cuando se crea un nuevo recurso como resultado de la solicitud.
     *  A menudo se incluye una cabecera Location que apunta al URI del nuevo recurso.
     * 
     */
}
