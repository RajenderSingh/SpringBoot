package com.example.demo1.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo1.entity.DesignationEntity;
import com.example.demo1.entity.EmployeeEntity;

@Repository
public interface DesignationRepository extends CrudRepository<DesignationEntity, Long> {
	
	//@Query(nativeQuery = true, value="select  empid,empname, mgrid from emp where empid = :empid ")
    //public List<DesignationEntity> findByDesigId(@Param("desigid") Long desigid);
}
