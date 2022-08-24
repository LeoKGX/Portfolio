
package com.miapp.portfolio.controller;

import com.miapp.portfolio.model.HardNSoft;
import com.miapp.portfolio.repository.IHNSRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
    
    @PutMapping ("/crear/hns")
    public ResponseEntity<?> crearEdu(@RequestBody HardNSoft hns){
        HardNSoft hardNSoft = hnsRepo.findBySkill(hns.getSkill());
        if(hardNSoft.getSkill() != null){
            hardNSoft.setPorc(hns.getPorc());
            hnsRepo.save(hardNSoft);
        }else{
            hnsRepo.save(hns);}
        return ResponseEntity.ok().body("");
    }
    
    @PutMapping ("borrar/hns")
    public ResponseEntity<?> borrarEdu(@RequestBody HardNSoft hns){
        HardNSoft hardNSoft = hnsRepo.findBySkill(hns.getSkill());
        if(hardNSoft.getSkill() != null){
            hnsRepo.delete(hardNSoft);
        }else{
           return ResponseEntity.badRequest().body("no se pudo"); }
        return ResponseEntity.ok().body("");
    }
    
}
