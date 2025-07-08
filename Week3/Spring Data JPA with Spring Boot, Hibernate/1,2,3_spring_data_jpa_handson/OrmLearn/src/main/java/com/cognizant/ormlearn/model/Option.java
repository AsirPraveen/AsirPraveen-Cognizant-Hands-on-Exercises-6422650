package com.cognizant.ormlearn.model;

import jakarta.persistence.*;

@Entity
@Table(name="options")
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String text;

    private double score;

    private boolean correct;

    @ManyToOne
    @JoinColumn(name="question_id")
    private Question question;

    // getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getText() { return text; }
    public void setText(String text) { this.text = text; }
    public double getScore() { return score; }
    public void setScore(double score) { this.score = score; }
    public boolean isCorrect() { return correct; }
    public void setCorrect(boolean correct) { this.correct = correct; }
    public Question getQuestion() { return question; }
    public void setQuestion(Question question) { this.question = question; }

    @Override
    public String toString() {
        return "Option{" + "id=" + id + ", text='" + text + '\'' + ", score=" + score + ", correct=" + correct + '}';
    }
}
