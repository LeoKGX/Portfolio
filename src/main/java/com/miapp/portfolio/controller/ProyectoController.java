
package com.miapp.portfolio.controller;

import com.miapp.portfolio.model.Proyecto;
import com.miapp.portfolio.repository.IProyectoRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProyectoController {
    
    @Autowired IProyectoRepo proRepo;
    
    @GetMapping("/proyectos")
    public List<Proyecto> traerProId(){
        return proRepo.findAll();
    }
    
    @PutMapping ("/crear/proyecto")
    public ResponseEntity<?> crearPro(@RequestBody Proyecto proyecto){ 
        proRepo.save(proyecto);
        
        return ResponseEntity.ok().body("");
    }
    
    @PutMapping ("/borrar/proyecto")
    public ResponseEntity<?> borrarPro (@RequestBody String nombrepro){
        Proyecto proyectoABorrar = proRepo.findByName(nombrepro);
        proRepo.delete(proyectoABorrar);
        
        return ResponseEntity.ok().body("");
    }
}
