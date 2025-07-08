package com.cognizant.ormlearn.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="em_id")
    private int id;

    @Column(name="em_name")
    private String name;

    @Column(name="em_salary")
    private double salary;

    @Column(name="em_permanent")
    private boolean permanent;

    @Temporal(TemporalType.DATE)
    @Column(name="em_date_of_birth")
    private Date dateOfBirth;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="em_dp_id")
    private Department department;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="employee_skill",
            joinColumns = @JoinColumn(name="es_em_id"),
            inverseJoinColumns = @JoinColumn(name="es_sk_id"))
    private Set<Skill> skillList;

    public int getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }
    public boolean isPermanent() { return permanent; }
    public Date getDateOfBirth() { return dateOfBirth; }
    public Department getDepartment() { return department; }
    public Set<Skill> getSkillList() { return skillList; }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', salary=" + salary + ", permanent=" + permanent + ", dateOfBirth=" + dateOfBirth + "}";
    }
}
