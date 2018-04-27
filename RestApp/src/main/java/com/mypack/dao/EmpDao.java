package com.mypack.dao;




import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mypack.entity.Emp;


@Repository
public interface EmpDao extends CrudRepository<Emp, Integer> {

	public Iterable<Emp> findByJob(String job);
	public Iterable<Emp> findByJobOrderByNameAsc(String job);
	public Iterable<Emp> findBySalaryBetween(int min, int max);
	public Iterable<Emp> findByNameStartingWith(String str);
	public Iterable<Emp> findByNameOrSalary(String str, int s);
	
}
