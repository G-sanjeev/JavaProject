package com.learn.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {
	
	 // Method to display the custom login page
    @GetMapping("/public/login")
    public String loginPage() {
        return "index"; // Return the name of the login view (e.g., login.html)
    }

    // Method to handle login failure
    @GetMapping("/public/authentication/login?failed")
    public String loginFailed() {
        return "index"; // Return the login view with an error message
    }

    // Method to handle login processing (optional, Spring Security handles this by default)
    @PostMapping("/public/authentication/login/process")
    public String loginProcess() {
        // Custom login processing logic (if needed)
        return "redirect:/books"; // Redirect to the home page after successful login
    }
}
