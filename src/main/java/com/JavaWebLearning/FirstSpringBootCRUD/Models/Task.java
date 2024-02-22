package com.JavaWebLearning.FirstSpringBootCRUD.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Entity
@Table(name = "Task")
public class Task {

    @Id
    @Column(name = "task_id")
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int id;

    @Column(name = "task_text",nullable = false)
    private  String text;
    @Column (name = "task_due_date")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private Date dueDate;   //example: date = new SimpleDateFormat("yyyy-MM-dd HH:mm")


    @ManyToOne
    @JoinColumn(name="user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User author;

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public User getAuthor() {
        return author;
    }

    public void setText(String text) {
        this.text = text;
    }
}
