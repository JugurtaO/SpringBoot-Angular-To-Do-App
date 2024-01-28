package com.JavaWebLearning.FirstSpringBootCRUD.Models;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "Task")
public class Task {

    @Id
    @Column(name = "task_id")
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int id;

    @Column(name = "task_text",nullable = false)
    private  String text;

    @Column(name = "task_author")
    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private String author;

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getAuthor() {
        return author;
    }

    public void setText(String text) {
        this.text = text;
    }
}
