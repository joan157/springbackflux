package edu.cibertec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.cibertec.entity.PersonaEntity;
import edu.cibertec.service.PersonaService;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("api/v1/productor")
public class PersonaController {


    @Autowired
    private PersonaService productoService;

    @GetMapping
    public Flux<PersonaEntity> listarPersona(){
        return productoService.listarPersona();
    }
    
}
