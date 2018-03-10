package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.model.Information;

public interface InformationRepository extends JpaRepository<Information, Long> {

	
    @Query(value = "SELECT ID, CODE, COUNTRY FROM INFO", nativeQuery = true)
    List<Information> findByInfo();
  
}
