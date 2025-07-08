package com.cognizant.ormlearn.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="username")
    private String username;

    @OneToMany(mappedBy = "user")
    private List<Attempt> attempts;

    // getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public List<Attempt> getAttempts() { return attempts; }
    public void setAttempts(List<Attempt> attempts) { this.attempts = attempts; }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username='" + username + '\'' + '}';
    }
}
