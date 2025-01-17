package studentdbms.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import studentdbms.entity.User;
import studentdbms.service.userservice;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private userservice uss;

    // Handle login submission
    @PostMapping("")
    public String login(@ModelAttribute("theUserLogin") User user, Model model) {
        Optional<User> existingUser = uss.findByUsername(user.getUsername());

        if (existingUser.isPresent() && existingUser.get().getPassword().equals(user.getPassword())) {
            // Redirect to the home page if login is successful
            return "redirect:/home";
        } else {
            // Display error message if login fails
            model.addAttribute("message", "Invalid username or password.");
            return "login";  // Return back to login page with error message
        }
    }

    // Navigate to sign up page
    @GetMapping("/signup")
    public String showSignupForm(Model model) {
        model.addAttribute("theUser", new User());
        return "signup-form";
    }
    
}
