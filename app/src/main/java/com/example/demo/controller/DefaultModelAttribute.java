package com.example.demo.controller;

import com.example.demo.beans.Login;
import com.example.demo.beans.SearchHistory;
import com.example.demo.beans.User;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Arrays;
import java.util.List;

@ControllerAdvice       // This tag apply across the flow of applicaton
public class DefaultModelAttribute {
    @ModelAttribute("newsearch")
    public SearchHistory getDefaultSearchHistory(){return new SearchHistory();}

    @ModelAttribute("newuser")
    public User getDefault(){
        return new User();
    }

    @ModelAttribute("returnGenderList")
    public List<String> getGenderItem(){
        return Arrays.asList("Male","Female", "Other");
    }

    @ModelAttribute("login")
    public Login getDefaultUser(){
        return new Login();
    }


}
