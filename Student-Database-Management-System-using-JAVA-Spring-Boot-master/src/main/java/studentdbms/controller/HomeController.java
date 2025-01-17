package studentdbms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import studentdbms.entity.User;

@Controller
public class HomeController {

    @GetMapping("/")
    public String showLoginPage(Model model) {
        model.addAttribute("theUserLogin", new User());
        return "login";  // Renders login.html as the default page
    }

    @GetMapping("/main")
    public String showHomePage() {
        return "home";  // This renders home.html after successful login
    }
    
}
