package com.utc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utc.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
