package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.EntityClass;

@Repository
public interface RepositoryClass extends JpaRepository<EntityClass, Long>{
    
    boolean existsByFirstNameAndEmailId(String firstName, String emailId);

}
