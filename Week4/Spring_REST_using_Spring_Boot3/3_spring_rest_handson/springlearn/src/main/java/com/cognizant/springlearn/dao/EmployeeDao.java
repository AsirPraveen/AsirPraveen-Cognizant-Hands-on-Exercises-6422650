package com.cognizant.springlearn.dao;

import com.cognizant.springlearn.model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeDao {
    public static List<Employee> EMPLOYEE_LIST;

    public EmployeeDao(ApplicationContext context) {
        EMPLOYEE_LIST = (List<Employee>) context.getBean("employeeList");
    }

    public List<Employee> getAllEmployees() {
        return EMPLOYEE_LIST;
    }
}
