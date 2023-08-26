package com.hospitel_management_system.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.hospitel_management_system.entities.Doctor;
import com.hospitel_management_system.entities.MedicalRecord;
import com.hospitel_management_system.entities.Patient;
import com.hospitel_management_system.repo.Doctors;
import com.hospitel_management_system.repo.MedicalRecordrepo;
import com.hospitel_management_system.repo.Patientrepo;

@RestController
public class MedicalRcordController {
	@Autowired
	MedicalRecordrepo mr;

	@Autowired
	Patientrepo pr;

	@Autowired
	Doctors dr;

	@GetMapping("/getallrecords")
	public List<MedicalRecord> getall() {
		List<MedicalRecord> lr = mr.findAll();
		if (lr.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		} else {
			return lr;
		}

	}

	@GetMapping("/getalldoc")
	public List<Doctor> getalldoc() {
		List<Doctor> lr = dr.findAll();
		if (lr.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		} else {
			return lr;
		}

	}

	@GetMapping("/getallpat")
	public List<Patient> getallpat() {
		List<Patient> lr = pr.findAll();
		if (lr.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		} else {
			return lr;
		}

	}

	@GetMapping("/get/record/{pid}")
	public List<MedicalRecord> getallbypid(@PathVariable("pid") int pid) {
		List<MedicalRecord> lr = mr.findAllByPid(pid);
		if (lr.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "id not present in the table");

		} else {
			return lr;
		}
	}

	@GetMapping("/get/recordbydid/{did}")
	public List<MedicalRecord> getallbydid(@PathVariable("did") int did) {
		List<MedicalRecord> lr = mr.findAllByDid(did);
		if (lr.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		} else {
			return lr;
		}
	}

	@GetMapping("/get/recordbydiagnosis")
	public List<MedicalRecord> getallbydiagnosis(@RequestParam("dia") String dia) {
		List<MedicalRecord> lr = mr.findAllByDiagnosis(dia);
		if (lr.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		} else {
			return lr;
		}
	}

	@GetMapping("/get/allpatients")
	public List<Patient> getpatient() {
		List<Patient> lr = pr.findAll();
		if (lr.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		} else {
			return lr;
		}
	}

	@PutMapping("/update/med")
	public MedicalRecord update(@RequestParam("id") int id, @RequestParam("diagnosis") String diagnosis,
			@RequestParam("presc") String presc) {
		var obj = mr.findById(id);
		if (obj.isPresent()) {
			MedicalRecord obj1 = obj.get();
			obj1.setDiagnosis(diagnosis);
			obj1.setPresc(presc);
			return obj1;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "id doesn't exist");
		}

	}

	@PostMapping("/insert/med")
	public MedicalRecord insert(@RequestBody MedicalRecord medicalrecord) {
		if (medicalrecord != null) {

			Patient pobj = pr.findById(medicalrecord.getPid()).get();
			Doctor dobj = dr.findById(medicalrecord.getDid()).get();

			if (pobj != null && dobj != null) {
				if (medicalrecord.getDid() == dobj.getDid() && medicalrecord.getPid() == pobj.getId()) {
					mr.save(medicalrecord);
					return medicalrecord;
				} else {
					throw new NoSuchElementException("pid and did is not available in primary key");
				}
			} else {
				throw new NoSuchElementException("droom");
			}
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "check the data and re-enter");
		}
	}

	@PostMapping("/insert/doct")
	public Doctor insertdoct(@RequestBody Doctor doctor) {
		if (doctor != null) {
			dr.save(doctor);
			return doctor;
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "check the data and re-enter");
		}

	}

	@PostMapping("/insert/pat")
	public Patient insertpatient(@RequestBody Patient pat) {
		if (pat != null) {
			pr.save(pat);
			return pat;
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "check the data and re-enter");
		}

	}
}
