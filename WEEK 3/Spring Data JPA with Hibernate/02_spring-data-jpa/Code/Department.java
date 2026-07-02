package com.cognizant.ormlearn.model;

import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "department")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dp_id")
	private int id;

	@Column(name = "dp_name")
	private String name;

	// HO5 - one to many, eager so we can access employees outside transaction
	@OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
	private Set<Employee> employeeList;

	public int getId() { return id; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public Set<Employee> getEmployeeList() { return employeeList; }
	public void setEmployeeList(Set<Employee> employeeList) { this.employeeList = employeeList; }

	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}
}
