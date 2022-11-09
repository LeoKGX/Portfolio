
package com.miapp.portfolio.controller;

import com.miapp.portfolio.model.Persona;
import com.miapp.portfolio.repository.IPersonaRepo;
import java.net.URI;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*") 
@RestController
public class PersonaController {
    
    @Autowired
    IPersonaRepo personaRepo;
    
    @GetMapping ("/persona")
    public List<Persona> getPersona(){
        return personaRepo.findAll();
    }
    
    @PostMapping ("/crear/persona")
    public ResponseEntity<Persona> crearPersona(@RequestBody @Valid Persona persona){
        personaRepo.save(persona);
        URI personaUri = URI.create("/persona/" + persona.getId());
        
        return ResponseEntity.created(personaUri).body(persona);
    }
}
