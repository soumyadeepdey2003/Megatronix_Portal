package megatronix.soumya.Megatronix_portal.RD.Controller;

import megatronix.soumya.Megatronix_portal.RD.Model.ElectricalModel;
import megatronix.soumya.Megatronix_portal.RD.Repo.ElectricalRepo;
import megatronix.soumya.Megatronix_portal.RD.Service.ElectricalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@Controller
public class electricalController {

    @Autowired
    private ElectricalService service;

    @Autowired
    private ElectricalRepo repo;




    @Async
    @RequestMapping(value="/rd/electrical", method = RequestMethod.POST)
    public CompletableFuture<String> register(@ModelAttribute("electrical") ElectricalModel member, Model model) {
        try {
            CompletableFuture<ElectricalModel> registeredMember = service.ElectricalRd(member);
            model.addAttribute("Rduser", registeredMember.get());
            return CompletableFuture.completedFuture("rd-success");
        } catch (Exception e) {
            // Handle validation errors
            return CompletableFuture.completedFuture("electrical");
        }
    }

    @GetMapping("/electrical")
    @Async
    public CompletableFuture<String> rdSuccess(@RequestParam(name = "id") Long userId, Model model) {
        // Fetch the user by ID and display the success page
        ElectricalModel Rduser = repo.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        // Use "user" as the attribute name to match the success page template
        model.addAttribute("Rduser", Rduser);
        return CompletableFuture.completedFuture("rd-success");
    }

}
