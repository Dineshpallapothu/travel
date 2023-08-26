package com.hospitel_management_system.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospitel_management_system.entities.Doctor;

public interface Doctors extends JpaRepository<Doctor, Integer> {
	
}
