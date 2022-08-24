
package com.miapp.portfolio.controller;

import com.miapp.portfolio.model.Education;
import com.miapp.portfolio.repository.IEducationRepo;
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
public class EducationController {
    
    @Autowired IEducationRepo eduRepo;
    
    @GetMapping("/educacion")
    public List<Education> traerEdu(){
        return eduRepo.findAll();
    }
    
    @PutMapping ("/crear/edu")
    public ResponseEntity<?> crearEdu(@RequestBody Education edu){
        eduRepo.save(edu);
        return ResponseEntity.ok().body("");
    }
}
