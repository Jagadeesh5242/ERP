package studentdbms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import studentdbms.entity.ContactForm;

@Controller
@RequestMapping("/")
public class AboutController {

    // Show the About page
    @GetMapping("/about")
    public String about(Model model) {
        // You can add attributes to the model if needed
        return "about"; // return the name of the about.html template
    }

    // Show the Contact page
    @GetMapping("/contact")
    public String contact(Model model) {
        return "contact"; // return the name of the contact.html template
    }

    // Handle contact form submission
    @PostMapping("/contact/submit")
    public String submitContactForm(ContactForm contactForm, Model model) {
        // Here you can handle the form submission, such as saving the data or sending an email
        // For example:
        // contactService.sendContactEmail(contactForm);

        // You can add a success message to the model
        model.addAttribute("successMessage", "Thank you for contacting us!");

        return "contact"; // Redirect back to contact page or show a success page
    }
}
