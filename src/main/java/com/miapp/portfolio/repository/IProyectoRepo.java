
package com.miapp.portfolio.repository;

import com.miapp.portfolio.model.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProyectoRepo extends JpaRepository<Proyecto, Long>{
    
    public Proyecto findByName(String nombrepro);
}
