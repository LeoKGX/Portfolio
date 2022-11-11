package com.miapp.portfolio.controller;

import com.miapp.portfolio.model.XP;
import com.miapp.portfolio.repository.IXPRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class XPController {
    @Autowired IXPRepo xpRepo;
    
    @GetMapping("/xp")
    private List<XP> getXP(){
        return xpRepo.findAll();
    }
    
    @PostMapping("/crear/xp")
    private ResponseEntity<?> crearXP(@RequestBody XP xp){
        xpRepo.save(xp);
        return ResponseEntity.ok().body("");
    }
}
