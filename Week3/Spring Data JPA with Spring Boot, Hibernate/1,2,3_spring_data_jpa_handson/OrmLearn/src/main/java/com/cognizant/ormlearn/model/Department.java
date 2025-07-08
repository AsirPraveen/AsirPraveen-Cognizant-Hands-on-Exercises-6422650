package com.cognizant.ormlearn.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name="department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="dp_id")
    private int id;

    @Column(name="dp_name")
    private String name;

    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    private Set<Employee> employeeList;

    public int getId() { return id; }
    public String getName() { return name; }
    public Set<Employee> getEmployeeList() { return employeeList; }

    @Override
    public String toString() {
        return "Department{id=" + id + ", name='" + name + "'}";
    }
}
