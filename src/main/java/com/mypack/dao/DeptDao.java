package com.mypack.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mypack.entity.Department;




@Repository
public interface DeptDao extends JpaRepository<Department, Integer> {

	
}
