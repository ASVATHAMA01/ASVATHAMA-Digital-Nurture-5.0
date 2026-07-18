package com.cognizant.ormlearn.model;

import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "skill")
public class Skill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sk_id")
	private int id;

	@Column(name = "sk_name")
	private String name;

	// HO6 - many to many inverse side
	@ManyToMany(mappedBy = "skillList")
	private Set<Employee> employeeList;

	public int getId() { return id; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public Set<Employee> getEmployeeList() { return employeeList; }
	public void setEmployeeList(Set<Employee> e) { this.employeeList = e; }

	public String toString() {
		return "Skill [id=" + id + ", name=" + name + "]";
	}
}
