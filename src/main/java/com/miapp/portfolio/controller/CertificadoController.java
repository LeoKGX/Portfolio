
package com.miapp.portfolio.controller;

import com.miapp.portfolio.model.Certificado;
import com.miapp.portfolio.repository.ICertificadoRepo;
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
public class CertificadoController {
    
    @Autowired ICertificadoRepo certificadoRepo;
    
    @GetMapping("/certificados")
    public List<Certificado> traerCert(){
        return certificadoRepo.findAll();
    }
    
    
    @PutMapping ("/crear/cert")
    public ResponseEntity<?> crearEdu(@RequestBody Certificado certificado){
        certificadoRepo.save(certificado);
        return ResponseEntity.ok().body("");
    }
}
