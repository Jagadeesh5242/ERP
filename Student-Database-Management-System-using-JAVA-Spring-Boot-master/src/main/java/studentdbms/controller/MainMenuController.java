package studentdbms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainMenuController {

    @GetMapping("/home")
    public String showHomePage() {
        return "home";  // This will look for home.html in the templates directory
    }
}
