package com.cognizant.ormlearn.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name="skill")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="sk_id")
    private int id;

    @Column(name="sk_name")
    private String name;

    @ManyToMany(mappedBy = "skillList", fetch = FetchType.LAZY)
    private Set<Employee> employeeList;

    public int getId() { return id; }
    public String getName() { return name; }
    public Set<Employee> getEmployeeList() { return employeeList; }

    @Override
    public String toString() {
        return "Skill{id=" + id + ", name='" + name + "'}";
    }
}
