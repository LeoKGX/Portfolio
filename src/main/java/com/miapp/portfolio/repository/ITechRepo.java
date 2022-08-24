
package com.miapp.portfolio.repository;

import com.miapp.portfolio.model.Tech;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITechRepo extends JpaRepository<Tech, Long>{

    public Tech findByName(Tech techName);

    
}