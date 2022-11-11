package com.miapp.portfolio.controller;

import com.miapp.portfolio.model.AboutMe;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.miapp.portfolio.repository.IAboutMeRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AboutMeController {
    @Autowired IAboutMeRepo AboutMeRepo;

    @GetMapping("/aboutme")
    public List<AboutMe> getAboutMe() {
        return AboutMeRepo.findAll();
    }
    
    @PutMapping("/crear/aboutme")
    public ResponseEntity<?> crearAboutMe(@RequestBody AboutMe about){
        AboutMeRepo.save(about);
        return ResponseEntity.ok().body("");
    }
    
    @PutMapping ("borrar/acercademi")
    public ResponseEntity<?> borrarAbout(@RequestBody AboutMe about){
            AboutMe aboutABorrar = AboutMeRepo.findBySobre_mi(about.getAbout());
            AboutMeRepo.delete(aboutABorrar);
            
            return ResponseEntity.ok().body("");
    }

}
