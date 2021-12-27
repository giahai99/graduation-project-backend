package com.utc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.utc.exception.ResourceNotFoundException;
import com.utc.model.Patient;
import com.utc.repository.PatientRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("CovidManagement/")
public class PatientController {
	@Autowired
	private PatientRepository patientRepository;
	
	
	@GetMapping("/patients")
	public List<Patient> getAllPatients(){
		return patientRepository.findAll();
	}
	
	//create patient rest api
	@PostMapping("/patients")
	public Patient createPatient(@RequestBody Patient patient) {
			return patientRepository.save(patient);
	}
	
	
	
	// get patient by patient_index rest api
	@GetMapping("/patients/{patient_index}")
	public ResponseEntity<Patient> getPatientById(@PathVariable Integer patient_index ){
		Patient patient = patientRepository.findById(patient_index)
				.orElseThrow(() -> new ResourceNotFoundException("Patient not exist with patient index :"+ patient_index));
		return ResponseEntity.ok(patient);
	}
	
	// update patient rest api
	@PutMapping("/patients/{patient_index}")
	public ResponseEntity<Patient> updatePatient(@PathVariable Integer patient_index, @RequestBody Patient patientDetails){
		Patient patient = patientRepository.findById(patient_index)
				.orElseThrow(() -> new ResourceNotFoundException("Patient not exist with patient index :" + patient_index));
		patient.setId(patientDetails.getId());
		patient.setName(patientDetails.getName());
		patient.setAge(patientDetails.getAge());
		patient.setGender(patientDetails.getGender());
		patient.setDistrict(patientDetails.getDistrict());
		patient.setAddress(patientDetails.getAddress());
		patient.setStatus(patientDetails.getStatus());
		patient.setInjectionNO(patientDetails.getInjectionNO());
		patient.setType(patientDetails.getType());
		patient.setLocationTrace(patientDetails.getLocationTrace());
		patient.setImage(patientDetails.getImage());
		
		Patient updatePatient = patientRepository.save(patient);
		return ResponseEntity.ok(updatePatient);
	}
	
	
	// delete patient rest api
	@DeleteMapping("/patients/{patient_index}")
	public ResponseEntity<Map<String, Boolean>> deletePatient(@PathVariable Integer patient_index){
		Patient patient = patientRepository.findById(patient_index)
				.orElseThrow(() -> new ResourceNotFoundException("Patient not exist with patient index :"+patient_index));
		patientRepository.delete(patient);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted",Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
}
