package com.cognizant.springlearn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.dao.DepartmentDao;
import com.cognizant.springlearn.model.Department;
import com.cognizant.springlearn.service.DepartmentService;

@RestController
public class DepartmentController {

	@Autowired
	DepartmentService departmentService;

	@GetMapping("/departments")
	public List<Department> getallEmployee() {
		return departmentService.getallEmployee();
	}

	@PutMapping("/departments/{id}")
	public Department update(@RequestBody Department department, @PathVariable int id) {
		for (Department d : DepartmentDao.DEPARTMENT_LIST) {
			if (d.getId() == id) {
				d.setName(department.getName());
				d.setLocation(department.getLocation());
			}
		}
		return department;
	}

}
