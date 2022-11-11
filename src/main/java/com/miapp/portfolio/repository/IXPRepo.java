package com.miapp.portfolio.repository;

import com.miapp.portfolio.model.XP;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IXPRepo extends JpaRepository<XP, Long>{
    
}
