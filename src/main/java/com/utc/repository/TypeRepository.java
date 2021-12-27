package com.utc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utc.model.Type;

@Repository
public interface TypeRepository extends JpaRepository<Type, Integer> {

}
