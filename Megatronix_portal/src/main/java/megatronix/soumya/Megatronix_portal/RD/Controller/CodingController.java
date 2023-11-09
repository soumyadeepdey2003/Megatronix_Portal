package megatronix.soumya.Megatronix_portal.RD.Controller;

import megatronix.soumya.Megatronix_portal.RD.Model.CodingModel;
import megatronix.soumya.Megatronix_portal.RD.Repo.CodingRepo;
import megatronix.soumya.Megatronix_portal.RD.Service.CodingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@Controller

public class CodingController {

    @Autowired
    private CodingService service;

    @Autowired
    private CodingRepo repo;

//    @PostMapping("/rd/coding")
  @Async
    @RequestMapping(value="/rd/coding", method = RequestMethod.POST)
    public CompletableFuture<String> register(@ModelAttribute("coding") CodingModel member, Model model) {
        System.out.println("hi");
        try {
            CompletableFuture<CodingModel> registeredMember = service.CodingRd(member);

            model.addAttribute("Rduser", registeredMember.get());
            // Display the "rd-success" template directly
            return CompletableFuture.completedFuture("rd-success");
        } catch (Exception e) {
            // Log the exception (consider using a proper logging framework)
            model.addAttribute("error", "Registration failed. Please check your input.");
            return CompletableFuture.completedFuture("coding");
        }
    }

    @GetMapping("/coding")
    @Async
    public CompletableFuture<String> rdSuccess(@RequestParam(name = "id") Long userId, Model model) {
        // Fetch the user by ID and display the success page
        CodingModel Rduser = repo.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        // Use "user" as the attribute name to match the success page template
        model.addAttribute("Rduser", Rduser);
        return CompletableFuture.completedFuture("rd-success");
    }
}
