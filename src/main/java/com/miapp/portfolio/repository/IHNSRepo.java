
package com.miapp.portfolio.repository;

import com.miapp.portfolio.model.HardNSoft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHNSRepo extends JpaRepository<HardNSoft, Long>{

    public HardNSoft findBySkill(String hns);
    
}
