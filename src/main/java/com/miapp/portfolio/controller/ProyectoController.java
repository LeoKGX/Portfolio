
package com.miapp.portfolio.controller;

import com.miapp.portfolio.model.Proyecto;
import com.miapp.portfolio.model.Tech;
import com.miapp.portfolio.repository.IProyectoRepo;
import com.miapp.portfolio.repository.ITechRepo;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class ProyectoController {
    
    @Autowired IProyectoRepo proRepo;
    @Autowired ITechRepo techRepo;
    
    @GetMapping("/proyectos")
    public List<Proyecto> traerProId(){
        return proRepo.findAll();
    }
    
    @PostMapping ("/crear/xp")
    public ResponseEntity<?> crearXp(@RequestBody Proyecto xp){ 
        yourMethod(xp);
        return ResponseEntity.ok().body("");
    }      
    
    
    
    
    @Transactional
    public void yourMethod(Proyecto xp) 
{

        Proyecto r = new Proyecto();
        r.setId(xp.getId());
        r.setName(xp.getName());
        r.setDescription(xp.getDescription());

        for(int i=1; i<=3; i++) {  
            long l=i;  
            Tech p = techRepo.getById(l);
            r.getTechs().add(p);
            p.getProyecto().add(r);
        }

        proRepo.save(r);
}
}
