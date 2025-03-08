package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.EntityClass;
import com.example.demo.repository.RepositoryClass;


@Service
public class ServiceClass {
	
	@Autowired
	private RepositoryClass repo;
	
	//saves a single user details
		public EntityClass saves(EntityClass user) {
			return repo.save(user);
			//return entityClass;		
		}
		
		// ✅ Save multiple user details
	    public List<EntityClass> saveAll(List<EntityClass> users) {
	        return repo.saveAll(users);
	    }

	    // ✅ Get all user details
	    public List<EntityClass> getAllEmployees() {
	        return repo.findAll();
	    }

	    //get by id
	    public EntityClass getById(Long id) {
	        return repo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
	    }
		
	    //delete by id
	    public void deleteById(Long id) {
	        repo.deleteById(id);
	    }

	    
	    public EntityClass updateEmployee(Long id, EntityClass updatedUser) {
	        return repo.findById(id).map(person -> {
	            person.setFirstName(updatedUser.getFirstName());
	            person.setLastName(updatedUser.getLastName());
	            person.setEmailId(updatedUser.getEmailId());
	            return repo.save(person);
	        }).orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
	    }

	    
	    
	    
	    
	    public boolean existsByFirstNameAndEmailId(String firstName, String emailId) {
	        return repo.existsByFirstNameAndEmailId(firstName, emailId);
	    }

}
