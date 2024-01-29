package com.JavaWebLearning.FirstSpringBootCRUD.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "User")
public class User
{

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    @Column(name = "user_firstname",nullable = false)
    private String firstName;
    @Column(name = "user_lastname",nullable = false)
    private String lastName;
    @Column(name = "user_email",unique = true,nullable = false)
    private String email;

    @Column(name = "user_password",nullable = false)
    private String password;

    @OneToMany(mappedBy = "User")
    //private Set<Task> tasks = new HashSet<>();

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId(){
        return this.id;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public String getEmail(){
        return this.email;
    }
    public String getPassword(){
        return this.password;
    }




}
