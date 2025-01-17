package studentdbms.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import studentdbms.entity.User;
import studentdbms.service.userservice;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private userservice uss;

    // Handle sign-up submission
    @PostMapping("/save")
    public String saveUser(@ModelAttribute("theUser") User theUser, Model model) {
        uss.save(theUser);
        model.addAttribute("theUserLogin", new User());
        return "login";  // Redirect to login page after signup
    }
    
    
    @PostMapping("/login")
    public String login(@ModelAttribute("theUserLogin") User user, Model model) {
        Optional<User> existingUser = uss.findByUsername(user.getUsername());

        if (existingUser.isPresent() && existingUser.get().getPassword().equals(user.getPassword())) {
           // model.addAttribute("message", "Login successful!");
            return "home";
        } else {
            model.addAttribute("message", "Invalid username or password.");
            model.addAttribute("theUserLogin", new User());
            return "login";
        }
    }
}
