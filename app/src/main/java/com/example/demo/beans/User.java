package com.example.demo.beans;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.sql.Date;

@Entity
@Table(name = "user", schema = "public")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;

    //This validation is for severside
    @Size(min=6, message = "{username.not.empty}")  // fetch errors from validationMessages.properties
    private String username;

    //Use this expression for other project
    //@Pattern(regexp= "/^(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z])(.{8,20})$/",
      //      message = "Password must be from 8 to 20 characters. Each password must contain at least 1 lower case letter, at least 1 upper case letter, at least 1 digit")
    private String password;

    @Enumerated(EnumType.STRING)
    private Gender gender;


    private String first_name;
    private String last_name;

    @Column(name = "email")
    @NotEmpty(message = "Email can't be empty")
    private String email;

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    //CHECK OUT JSR 380 FOR MORE IMPLEMENTATION
    public int getId() {
        return user_id;
    }

    public void setId(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }


    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String firstName) {
        this.first_name = first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String lastName) {
        this.last_name = last_name;
    }



}
