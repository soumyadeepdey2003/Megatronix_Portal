package megatronix.soumya.Megatronix_portal.RD.Controller;

import megatronix.soumya.Megatronix_portal.RD.Model.CodingModel;
import megatronix.soumya.Megatronix_portal.RD.Model.GeneralModel;
import megatronix.soumya.Megatronix_portal.RD.Repo.GeneralRepo;
import megatronix.soumya.Megatronix_portal.RD.Service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;
@Controller
public class GeneralController {
    @Autowired
    private GeneralService service;

    @Autowired
    private GeneralRepo repo;



    @RequestMapping(value="/rd/general", method = RequestMethod.POST)
    @Async
    public CompletableFuture<String> register(@ModelAttribute("general") GeneralModel member, Model model) {
        try {
            CompletableFuture<GeneralModel> registeredMember = service.GeneralRd(member);
            model.addAttribute("Rduser", registeredMember.get());
            return CompletableFuture.completedFuture("rd-success");
        } catch (Exception e) {
            model.addAttribute("errorDetails", e.getMessage());
            return CompletableFuture.completedFuture("error");
        }
    }

    @GetMapping("/general")
    @Async
    public CompletableFuture<String> rdSuccess(@RequestParam(name = "id") Long userId, Model model) {
        // Fetch the user by ID and display the success page
        GeneralModel Rduser = repo.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        // Use "user" as the attribute name to match the success page template
        model.addAttribute("Rduser", Rduser);
        return CompletableFuture.completedFuture("rd-success");
    }

}
