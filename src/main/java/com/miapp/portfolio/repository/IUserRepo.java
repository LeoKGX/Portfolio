
package com.miapp.portfolio.repository;

import com.miapp.portfolio.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepo extends JpaRepository<User, Long>{
    Optional<User> findByEmail(String email);
}
