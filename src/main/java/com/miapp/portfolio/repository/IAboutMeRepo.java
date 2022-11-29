package com.miapp.portfolio.repository;

import com.miapp.portfolio.model.AboutMe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAboutMeRepo extends JpaRepository<AboutMe, Long>{
    
    public AboutMe findByAbout(String about);
}