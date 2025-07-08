package com.cognizant.ormlearn.model;

import jakarta.persistence.*;

@Entity
@Table(name="attempt_option")
public class AttemptOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="attempt_question_id")
    private AttemptQuestion attemptQuestion;

    @ManyToOne
    @JoinColumn(name="option_id")
    private Option option;

    private boolean selected;

    // getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public AttemptQuestion getAttemptQuestion() { return attemptQuestion; }
    public void setAttemptQuestion(AttemptQuestion attemptQuestion) { this.attemptQuestion = attemptQuestion; }
    public Option getOption() { return option; }
    public void setOption(Option option) { this.option = option; }
    public boolean isSelected() { return selected; }
    public void setSelected(boolean selected) { this.selected = selected; }

    @Override
    public String toString() {
        return "AttemptOption{" + "id=" + id + ", option=" + option + ", selected=" + selected + '}';
    }
}
