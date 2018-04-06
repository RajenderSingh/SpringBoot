package com.example.demo1.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo1.entity.EmployeeEntity;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Long> {
	
	@Query(nativeQuery = true, value="select  empid,empname, mgrid, desigid from (select * from emp order by mgrid, empid) emps_sorted, (select @pv \\:= ?1) initialisation where find_in_set(mgrid, @pv) and length(@pv \\:= concat(@pv, ',', empid)) ")
	//@Query(nativeQuery = true, value="select  empid,empname, mgrid from emp where empid = :empid ")
    public List<EmployeeEntity> findByEmpId(@Param("empid") Long empid);
}
