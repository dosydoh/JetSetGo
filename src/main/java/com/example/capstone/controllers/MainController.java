package com.example.capstone.controllers;

import java.util.Collection;
import java.util.List;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.capstone.model.Role;
import com.example.capstone.model.User;
import com.example.capstone.services.UserService;
import com.example.capstone.services.BookingService;


@Controller
public class MainController {

    @Autowired
    private UserService userService;   //user related operations

    @Autowired
    private BookingService bookingService;    //booking account related operations


    //
    // UPDATE users_roles   user_id to point to role_id that is superuser in role table
    // to enable that id to be superuser!
    //
    // example:
    // mysql> update role set name = 'ROLE_SUPER' where id = 2;
    //
    @GetMapping("/")
    public String root(HttpSession session) {

        System.out.println("IN  MainController->root()");
        session.getAttributeNames();

        Collection<? extends GrantedAuthority> userRoles;

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            userRoles = ((UserDetails) principal).getAuthorities();

            for (GrantedAuthority userRole : userRoles) {
                if (userRole.getAuthority().equals("ROLE_SUPER")) {
                    System.out.println("USER ROLE="+userRole.getAuthority());
                    return "redirect:/admin";
                }
            }
        }

        System.out.println("USER ROLE Defaults to Regular USER");
        return "redirect:/index";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        System.out.println("IN  MainController->admin()");
        return "admin";
    }

    @GetMapping("/index")
    public String index(Model model) {
        System.out.println("IN  MainController->index()");
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        System.out.println("IN  MainController->login()");
        return "login";
    }

    @GetMapping("/user")
    public String userIndex() {
        System.out.println("IN  MainController->userIndex()");
        return "user/index";
    }

    @ResponseBody
    @GetMapping("/logoutSuccess")
    public String logoutResponse()
    {
        System.out.println("IN  MainController->logoutResponse()");
        return "Logged Out!!!!";
    }

}
