package com.example.demo.controller;

import com.example.demo.beans.Login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class LoginSessionController {
    @PostMapping("/loginsession")
    public String getUserProfile(@SessionAttribute("login") Login login, Model model){
        System.out.println("Welcome user");
        model.addAttribute("username",login.getUsername());
        return "session";
    }
}