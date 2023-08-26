package com.hospitel_management_system.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospitel_management_system.entities.MedicalRecord;

public interface MedicalRecordrepo extends JpaRepository<MedicalRecord, Integer>{
	
	List<MedicalRecord> findAllByPid(int pid);//find the records by pid

	List<MedicalRecord> findAllByDid(int did);//find the records by did

	List<MedicalRecord> findAllByDiagnosis(String dia);
	

}
