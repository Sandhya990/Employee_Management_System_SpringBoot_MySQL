package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.EntityClass;
import com.example.demo.service.ServiceClass;



@RestController
@RequestMapping("/controller")
@CrossOrigin("*") // Allow requests from your frontend
public class ControllerClass {
	
	@Autowired
	private ServiceClass userService;
	
	@PostMapping("/save")
	public EntityClass savec(@RequestBody EntityClass user) {
		return userService.saves(user);
	}
	
	@GetMapping("/check")
	public String healthCheck() {
		return "Instance 1 running successfully";
	}
	
	// ✅ Get all user details (to view in the browser)
    @GetMapping("/getAll")
    public List<EntityClass> getAllEmployees() {
        return userService.getAllEmployees();
    }
    
    @PostMapping("/saveAll")
    public List<EntityClass> saveAllEmployees(@RequestBody List<EntityClass> users) {
        return userService.saveAll(users);
    }
    
    
    @GetMapping("/get/{id}")
    public ResponseEntity<EntityClass> getEmployeeById(@PathVariable Long id) {
        EntityClass user = userService.getById(id);
        return ResponseEntity.ok(user);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok("User deleted successfully!!!");
    }
    
    
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable Long id, @RequestBody EntityClass updatedUser) {
        try {
            EntityClass updated = userService.updateEmployee(id, updatedUser);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
    
    
    
    @PostMapping("/checkUser")
    public ResponseEntity<Boolean> checkUser(@RequestBody EntityClass user) {
        boolean exists = userService.existsByFirstNameAndEmailId(user.getFirstName(), user.getEmailId());
        return ResponseEntity.ok(exists);
    }
    
}
