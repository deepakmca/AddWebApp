package com.mypack.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mypack.dao.EmpDao;
import com.mypack.entity.Emp;



@RestController
public class EmpController {

	//Dependency of the controller
	@Autowired
	EmpDao dao;
	
	
	//method to save an emp
	@PostMapping(value="/save",consumes="application/json")
	public String saveEmp(@RequestBody Emp e) throws Exception
	{
	dao.save(e);
	return "Success";
	}
	
	//method to update an emp
	@PutMapping(value="/update", consumes="application/json")
	
	public String updateEmp(
		@RequestBody Emp e) throws Exception
	{
			dao.save(e);
			return "Success";
	}
	//method to remove an emp
		@DeleteMapping(value="/remove/{id}")
		
		public String removeEmp(
			@PathVariable int id) throws Exception
		{
				dao.deleteById(id);
				return "Success";
		}
	
		//method to fetch an emp using id
		@GetMapping(value="/emp/{id}")
				
		public Emp empById(
			@PathVariable int id) throws Exception
		{
			Optional<Emp> emp = dao.findById(id);
			if(emp.isPresent())
			return emp.get();
			else
				throw new Exception("No object found for the Id: "+id);
		}
		
	//method to fetch all employees using their job
	@GetMapping(value="/empByJob/{job}")
		
	public Iterable<Emp> allEmpByJob(
		@PathVariable String job) throws Exception
		{
			return dao.findByJob(job);
		}	
		
	//method to fetch all employees using their job
		@GetMapping(value="/empByJobOrdered/{job}")
		
		public Iterable<Emp> allEmpByJobOrdered(
			@PathVariable String job) throws Exception
			{
				return dao.findByJobOrderByNameAsc(job);
			}
	
	//method to fetch all employees using their job
	@GetMapping(value="/empBySalary/{min}/{max}")
				
	public Iterable<Emp> allEmpBySalary(
	@PathVariable int min, @PathVariable int max) throws Exception
	{
			return dao.findBySalaryBetween(min, max);
	}	
	//method to fetch all employees
	@GetMapping(value="/emp")
	
	public Iterable<Emp> allEmp() throws Exception
	{
	return dao.findAll();
	}	
		
		
}

