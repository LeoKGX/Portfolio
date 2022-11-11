
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
    
    
    @PutMapping ("/update/persona/personal")
    public ResponseEntity<?> updatePersonalName(@RequestBody editPersonalInfo persedit){
        Persona personaAActualizar = personaRepo.findByMail(persedit.getMail());
        personaAActualizar.setOcupation(persedit.getOcupation()); 
        personaAActualizar.setLocation(persedit.getCity()); 
        personaRepo.save(personaAActualizar);
        
        return ResponseEntity.ok().body("");
    }
    
    @PutMapping ("/update/persona/contacto")
    public ResponseEntity<?> updatePersonEntity(@RequestBody editPersContacto persedit){
        Persona personaAActualizar = personaRepo.findByMail(persedit.getMail());
        personaAActualizar.setMail(persedit.getNuevomail()); 
        personaAActualizar.setPhone(persedit.getNuevotelefono()); 
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
    
    public static class editPersonalInfo{
        private String mail;
        private String ocupation;
        private String city;

        public editPersonalInfo() {
        }

        public String getMail() {
            return mail;
        }

        public void setMail(String mail) {
            this.mail = mail;
        }

        public String getOcupation() {
            return ocupation;
        }

        public void setOcupation(String ocupation) {
            this.ocupation = ocupation;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }
        
    }

    public static class editPersContacto {
        private String mail;
        private String nuevomail;
        private String nuevotelefono;
        
        public editPersContacto() {
        }

        public String getMail() {
            return mail;
        }

        public void setMail(String mail) {
            this.mail = mail;
        }

        public String getNuevomail() {
            return nuevomail;
        }

        public void setNuevomail(String nuevomail) {
            this.nuevomail = nuevomail;
        }

        public String getNuevotelefono() {
            return nuevotelefono;
        }

        public void setNuevotelefono(String nuevotelefono) {
            this.nuevotelefono = nuevotelefono;
        }
        
    }
}
