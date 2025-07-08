package com.cognizant.ormlearn.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="attempt")
public class Attempt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @Column(name="attempt_date")
    private Date attemptDate;

    @OneToMany(mappedBy="attempt")
    private List<AttemptQuestion> attemptQuestions;

    // getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public Date getAttemptDate() { return attemptDate; }
    public void setAttemptDate(Date attemptDate) { this.attemptDate = attemptDate; }
    public List<AttemptQuestion> getAttemptQuestions() { return attemptQuestions; }
    public void setAttemptQuestions(List<AttemptQuestion> attemptQuestions) { this.attemptQuestions = attemptQuestions; }

    @Override
    public String toString() {
        return "Attempt{" + "id=" + id + ", user=" + user + ", attemptDate=" + attemptDate + '}';
    }
}
