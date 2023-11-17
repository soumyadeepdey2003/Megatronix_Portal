package megatronix.soumya.Megatronix_portal.RD.Controller;

import megatronix.soumya.Megatronix_portal.RD.Model.CivilModel;
import megatronix.soumya.Megatronix_portal.RD.Repo.CivilRepo;
import megatronix.soumya.Megatronix_portal.RD.Service.CivilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@Controller
public class CivilController {

    @Autowired
    private CivilService service;

    @Autowired
    private CivilRepo repo;




    @Async
    @RequestMapping(value="/rd/civil", method = RequestMethod.POST)
    public CompletableFuture<String> civilregister(@ModelAttribute("civil") CivilModel member, Model model) {
        System.out.println("hi");
        try {
            CompletableFuture<CivilModel> registeredMember = service.CivilRd(member);
            model.addAttribute("Rduser", registeredMember.get());
            return CompletableFuture.completedFuture("rd-success");
        } catch (Exception e) {
            model.addAttribute("errorDetails", e.getMessage());
            return CompletableFuture.completedFuture("error");
        }
    }

    @GetMapping("/civil")
    @Async
    public CompletableFuture<String> rdSuccess(@RequestParam(name = "id") Long userId, Model model) {
        // Fetch the user by ID and display the success page
        CivilModel Rduser = repo.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        // Use "user" as the attribute name to match the success page template
        model.addAttribute("Rduser", Rduser);
        return CompletableFuture.completedFuture("rd-success");
    }
}
