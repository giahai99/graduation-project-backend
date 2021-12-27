package com.utc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utc.model.LocationTrace;

@Repository
public interface LocationRepository extends JpaRepository<LocationTrace, Integer> {
}

