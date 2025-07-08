package com.cognizant.ormlearn.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name="attempt_question")
public class AttemptQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="attempt_id")
    private Attempt attempt;

    @ManyToOne
    @JoinColumn(name="question_id")
    private Question question;

    @OneToMany(mappedBy="attemptQuestion")
    private List<AttemptOption> attemptOptions;

    // getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public Attempt getAttempt() { return attempt; }
    public void setAttempt(Attempt attempt) { this.attempt = attempt; }
    public Question getQuestion() { return question; }
    public void setQuestion(Question question) { this.question = question; }
    public List<AttemptOption> getAttemptOptions() { return attemptOptions; }
    public void setAttemptOptions(List<AttemptOption> attemptOptions) { this.attemptOptions = attemptOptions; }

    @Override
    public String toString() {
        return "AttemptQuestion{" + "id=" + id + ", question=" + question + '}';
    }
}
