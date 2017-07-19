package com.zhijia.zcms.dao.impl;

import org.springframework.stereotype.Repository;

import com.zhijia.zcms.dao.EmployeeDao;
import com.zhijia.zcms.model.tes.Employee;

@Repository("employeeDao")
public class EmployeeDaoImpl extends BaseDaoImpl<Employee> implements EmployeeDao {

}
