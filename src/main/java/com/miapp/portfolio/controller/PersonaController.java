
package com.miapp.portfolio.controller;

import com.miapp.portfolio.model.Persona;
import com.miapp.portfolio.repository.IPersonaRepo;
import java.net.URI;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController {
    
    @Autowired
    IPersonaRepo personaRepo;
    
    @PostMapping ("/crear/persona")
    public ResponseEntity<Persona> crearPersona(@RequestBody @Valid Persona persona){
        personaRepo.save(persona);
        URI personaUri = URI.create("/persona/" + persona.getId());
        
        return ResponseEntity.created(personaUri).body(persona);
    }
    
    @GetMapping ("/persona")
    public List<Persona> getPersona(){
        return personaRepo.findAll();
    }
    
    @PutMapping ("/update/persona/profileimg")
    public ResponseEntity<?> updatePersonaName(@RequestBody editFoto fotoedit){
        Persona personaAActualizar = personaRepo.findByMail(fotoedit.getMail());
        personaAActualizar.setProfile_img(fotoedit.getImglink()); 
        personaRepo.save(personaAActualizar);
        
        return ResponseEntity.ok().body("");
    }
    
    @PutMapping ("/update/persona/aboutme")
    public ResponseEntity<?> updatePersonaAboutMe(@RequestBody editAboutMe aboutme){
        Persona personaAActualizar = personaRepo.findByMail(aboutme.getMail());
        personaAActualizar.setSobre_mi(aboutme.getAboutme()); 
        personaRepo.save(personaAActualizar);
        
        return ResponseEntity.ok().body("");
    }
    
    public static class editFoto {
        private String mail;
        private String imglink;
        
        public editFoto() {
        }

        public String getImglink() {
            return imglink;
        }

        public void setImglink(String imglink) {
            this.imglink = imglink;
        }

        public String getMail() {
            return mail;
        }

        public void setMail(String mail) {
            this.mail = mail;
        }
        
        
    }

    public static class editAboutMe {
        private String mail;
        private String aboutme;
        
        public editAboutMe() {
        }

        public String getMail() {
            return mail;
        }

        public void setMail(String mail) {
            this.mail = mail;
        }

        public String getAboutme() {
            return aboutme;
        }

        public void setAboutme(String aboutme) {
            this.aboutme = aboutme;
        }
        
        
    }
    
    
}
