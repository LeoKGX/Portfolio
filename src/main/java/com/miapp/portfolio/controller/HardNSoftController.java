
package com.miapp.portfolio.controller;

import com.miapp.portfolio.model.HardNSoft;
import com.miapp.portfolio.repository.IHNSRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class HardNSoftController {
    
    @Autowired IHNSRepo hnsRepo;
    
    @GetMapping("/skill")
    public List<HardNSoft> traerSkills(){
        return hnsRepo.findAll();
    }
    
    @PostMapping ("/crear/hns")
    public ResponseEntity<?> crearEdu(@RequestBody HardNSoft hns){
        HardNSoft hardNSoft = hnsRepo.findBySkill(hns.getSkill());
        if(hardNSoft.getSkill().matches("null")){
            hnsRepo.save(hns);
            return ResponseEntity.ok().body("");
        }else{
          
            hardNSoft.setPorc(hns.getPorc());
            hnsRepo.save(hardNSoft);
            return ResponseEntity.ok().body("Se modifico");
        }
        
    }
    
    @PutMapping ("borrar/hns")
    public ResponseEntity<?> borrarEdu(@RequestBody HardNSoft hns){
        HardNSoft hardNSoft = hnsRepo.findBySkill(hns.getSkill());
        if(hardNSoft.getSkill() != null){
            hnsRepo.delete(hardNSoft);
            return ResponseEntity.ok().body("");
        }else{
           return ResponseEntity.badRequest().body("no se pudo"); }
        
    }
    
}
