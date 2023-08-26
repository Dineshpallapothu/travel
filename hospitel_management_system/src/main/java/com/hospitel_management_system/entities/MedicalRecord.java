package com.hospitel_management_system.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Medicalrecords")
public class MedicalRecord{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "patient_id")
	private int pid;

	@Column(name = "doctor_id")
	private int did;

	@Column(name = "diagnosis")
	private String diagnosis;

	@Column(name = "treatment")
	private String trt;
	@Column(name = "prescription")
	private String presc;
	
	@ManyToOne
	@JoinColumn(name="id", updatable = false,insertable = false)
	@JsonIgnore
	private Patient patient;
	@ManyToOne
	@JoinColumn(name="id", updatable = false,insertable = false)
	@JsonIgnore
	private Doctor doctor;

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getTrt() {
		return trt;
	}

	public void setTrt(String trt) {
		this.trt = trt;
	}

	public String getPresc() {
		return presc;
	}

	public void setPresc(String presc) {
		this.presc = presc;
	}

	@Override
	public String toString() {
		return "MedicalRecord [id=" + id + ", pid=" + pid + ", did=" + did + ", diagnosis=" + diagnosis + ", trt=" + trt
				+ ", presc=" + presc + "]";
	}

}
