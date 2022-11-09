
package com.miapp.portfolio.repository;

import com.miapp.portfolio.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IPersonaRepo extends JpaRepository<Persona , Long>{
    
}
