package com.zhijia.zcms.model.tes;

// Generated 2016-10-21 16:55:23 by Hibernate Tools 3.2.2.GA

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


/**
 * Employee generated by hbm2java
 */
@Entity
@Table(name = "tes_employee")
public class Employee implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Department department;
	private String name;
	private Float salary;

	public Employee() {
	}

	public Employee(Department department, String name, Float salary) {
		this.department = department;
		this.name = name;
		this.salary = salary;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	//不连接的写法
	 @ManyToOne(fetch = FetchType.LAZY)
	//这个本表中的外键
	@JoinColumn(name = "department_id")
	@Cascade(CascadeType.ALL)
	public Department getDepartment() {
		return this.department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}

	@Column(name = "name", length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "salary", precision = 8)
	public Float getSalary() {
		return this.salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}

}