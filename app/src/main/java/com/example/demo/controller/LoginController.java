package com.example.demo.controller;

import com.example.demo.beans.Login;
import com.example.demo.beans.User;
import com.example.demo.exceptions.ApplicationException;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("login") // ensure modelAttribute has the same name
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/loginuser")
    // what get sent through login is bounded to Login class
    public String login(@ModelAttribute("login") Login login, Model model){
        User user = userRepository.searchByName(login.getUsername());
        if(user==null){
            throw new ApplicationException("User not exits");       // When this is thrown, it will trigger the
            // @ExceptionHandler tag
        }
        return "forward:/loginsession";
    }

    // This one will be invoke first not the one in global exception handler
    @ExceptionHandler(ApplicationException.class)
    public String handleException(){
        System.out.println("In Exception handler");
        return "error";
    }
}