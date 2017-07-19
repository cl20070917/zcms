package com.zhijia.zcms;


import javax.inject.Inject;

import org.junit.Test;

import com.zhijia.zcms.dao.DepartmentDao;
import com.zhijia.zcms.dao.EmployeeDao;
import com.zhijia.zcms.model.tes.Department;
import com.zhijia.zcms.model.tes.Employee;

public class TestEmployeeDao extends BaseTest {
	@Inject
	private EmployeeDao employeeDao;
	@Inject
	private DepartmentDao departemntDao;
	@Test
	public void add(){
		Department p = new Department("jquery", "203", null);
		p.setId(1);
		//departemntDao.add(p);
		Employee e = new Employee(p, "前端工程师", 6000f);
		employeeDao.add(e);
	}
	@Test
	public void load(){
		/*Department p = new Department("java", "202", null);
		departemntDao.add(p);*/
		Employee e = employeeDao.load(1);
		System.out.println(e.getName()+"  "+e.getDepartment().getName());
	}
}
