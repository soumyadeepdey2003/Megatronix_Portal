package megatronix.soumya.Megatronix_portal.MRD.Controller;

import megatronix.soumya.Megatronix_portal.MRD.Model.MrdModel;
import megatronix.soumya.Megatronix_portal.MRD.Repo.MrdRepo;
import megatronix.soumya.Megatronix_portal.MRD.Service.MrdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.concurrent.CompletableFuture;

@Controller
@EnableAsync
public class MrdController {
    @Autowired
    private MrdService service;

    @Autowired
    private MrdRepo mrdRepository;
    @GetMapping("/registration")
    @Async
    public CompletableFuture<String> registrationForm(Model model) {
        // Use "user" as the attribute name to match the form in registration.html
        model.addAttribute("user", new MrdModel());
        return CompletableFuture.completedFuture("registration");
    }

    @GetMapping("/registration-success")
    @Async
    public CompletableFuture<String> registrationSuccess(@RequestParam(name = "id") Long userId, Model model) {
        // Fetch the user by ID and display the success page
        MrdModel user = mrdRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        // Use "user" as the attribute name to match the success page template
        model.addAttribute("user", user);
        return CompletableFuture.completedFuture("registration-success");
    }

    @PostMapping("/registration")
    @Async
    public CompletableFuture<String> register(@ModelAttribute("user") MrdModel member, Model model) {
        try {
            CompletableFuture<MrdModel> registeredMember = service.registerMember(member);
            model.addAttribute("uniqueId", registeredMember.get().getId());
            return CompletableFuture.completedFuture("registration-success");
        } catch (Exception e) {
            // Handle validation errors
            System.out.println(e);
            model.addAttribute("errorMessage", "Registration failed. Please check your input.");
            return CompletableFuture.completedFuture("registration");
        }
    }

}