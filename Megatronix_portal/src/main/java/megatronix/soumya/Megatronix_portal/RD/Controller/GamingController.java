package megatronix.soumya.Megatronix_portal.RD.Controller;

import megatronix.soumya.Megatronix_portal.RD.Model.CodingModel;
import megatronix.soumya.Megatronix_portal.RD.Model.GamingModel;
import megatronix.soumya.Megatronix_portal.RD.Model.GeneralModel;
import megatronix.soumya.Megatronix_portal.RD.Repo.GamingRepo;
import megatronix.soumya.Megatronix_portal.RD.Service.GamingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@Controller
public class GamingController {
    @Autowired
    private GamingService service;

    @Autowired
    private GamingRepo repo;



    @RequestMapping(value="/rd/gaming", method = RequestMethod.POST)
    @Async
    public CompletableFuture<String> register(@ModelAttribute("gaming") GamingModel member, Model model) {
        try {
            CompletableFuture<GamingModel> registeredMember = service.GamingOnSportRd(member);
            model.addAttribute("Rduser", registeredMember.get());
            return CompletableFuture.completedFuture("rd-success");
        } catch (Exception e) {
            // Handle validation errors
            return CompletableFuture.completedFuture("gaming");
        }
    }

    @GetMapping("/gaming")
    @Async
    public CompletableFuture<String> rdSuccess(@RequestParam(name = "id") Long userId, Model model) {
        // Fetch the user by ID and display the success page
        GamingModel Rduser = repo.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        // Use "user" as the attribute name to match the success page template
        model.addAttribute("Rduser", Rduser);
        return CompletableFuture.completedFuture("rd-success");
    }

}
