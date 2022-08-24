
package com.miapp.portfolio.repository;

import com.miapp.portfolio.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepo extends JpaRepository<Persona , Long>{

    

    public Persona findByMail(String mail);
    
}
