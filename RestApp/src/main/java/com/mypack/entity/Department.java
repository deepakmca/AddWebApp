package com.mypack.entity;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="department")
public class Department {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name,loc;
	
	
	//Relation
	@OneToMany(cascade= {CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinTable(name="Emp_Dept",
	joinColumns= {@JoinColumn(name="deptId")},
	inverseJoinColumns= {@JoinColumn(name="empId")})
	Set<Emp> employees;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public Set<Emp> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Emp> employees) {
		this.employees = employees;
	}
	
	
	
}
