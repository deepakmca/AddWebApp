package com.mypack.controller;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mypack.dao.DeptDao;
import com.mypack.entity.Department;
import com.mypack.entity.Emp;


@RestController
public class DeptController {

	//Dependency of the controller
	@Autowired
	DeptDao dao;
	
		//method to fetch a department using id
		@GetMapping(value="/dept/{id}")
		public Department deptById(
			@PathVariable int id) throws Exception
		{
			Optional<Department> dept = dao.findById(id);
			if(dept.isPresent())
			{
			 Department d=dept.get();
			 Set<Emp> set=d.getEmployees();
			 System.out.println("Following emp are loaded:");
			 for(Emp e:set)
				 System.out.println(e.getName()+"\t"+e.getJob()+"\t"+e.getSalary());
			 return d;
			}
			else
				throw new Exception("No object found for the Id: "+id);
		}
		
	//method to fetch all department using their job
	@GetMapping(value="/dept")
		
	public Iterable<Department> allDept() throws Exception
		{
			return dao.findAll();
		}	
		
	
		
}

