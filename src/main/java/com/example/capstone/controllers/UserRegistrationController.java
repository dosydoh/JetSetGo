package com.example.capstone.controllers;


import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.capstone.model.User;
import com.example.capstone.repository.UserRegistration;
import com.example.capstone.services.UserService;



@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    @Autowired
    private UserService userService;

   // @Autowired
    //private BCryptPasswordEncoder passwordEncoder;


    @ModelAttribute("user")
    public UserRegistration userRegistration() {
        System.out.println("IN  UserRegController->UserRegistration()");
        return new UserRegistration();
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        System.out.println("IN  UserRegController->showRegistrationForm()");
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistration userDto, BindingResult result){

        System.out.println("IN  POST MAPPING UserRegController->registerUserAccount()");
        User existing = userService.findByEmail(userDto.getEmail());
        if (existing != null){
            result.rejectValue("email", null, "There is already an account registered with that email");
        }

        System.out.println("ZZZZZZZZZZZZZZZ result:"+result.toString());

        if (result.hasErrors()){
            System.out.println("result:"+result.toString());
            return "registration";
        }


        userService.save(userDto);
        return "redirect:/registration?success";
    }

//        User user = new User();
//        user.setFirstName(userRegistration.getFirstName());
//        user.setLastName(userRegistration.getLastName());
//        user.setEmail(userRegistration.getEmail());
//        user.setUsername(userRegistration.getEmail()); // Assuming username is the email
//        user.setPassword(userRegistration.getPassword());
//        userService.saveUser(user);
//
//        return "redirect:/registration?success";
//    }
}