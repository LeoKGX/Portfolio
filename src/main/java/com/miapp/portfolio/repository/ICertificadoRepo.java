
package com.miapp.portfolio.repository;

import com.miapp.portfolio.model.Certificado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICertificadoRepo extends JpaRepository<Certificado, Long>{
    
}
