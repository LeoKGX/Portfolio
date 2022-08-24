
package com.miapp.portfolio.repository;

import com.miapp.portfolio.model.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEducationRepo extends JpaRepository<Education, Long>{
    
}
