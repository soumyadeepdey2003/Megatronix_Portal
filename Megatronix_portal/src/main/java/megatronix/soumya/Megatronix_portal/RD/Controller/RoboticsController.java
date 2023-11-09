package megatronix.soumya.Megatronix_portal.RD.Controller;

import megatronix.soumya.Megatronix_portal.RD.Model.CodingModel;
import megatronix.soumya.Megatronix_portal.RD.Model.RoboticsModel;
import megatronix.soumya.Megatronix_portal.RD.Repo.RoboticsRepo;
import megatronix.soumya.Megatronix_portal.RD.Service.RoboticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@Controller
public class RoboticsController {
    @Autowired
    private RoboticsService service;

    @Autowired
    private RoboticsRepo repo;



    @RequestMapping(value="/rd/robotics", method = RequestMethod.POST)
    @Async
    public CompletableFuture<String> register(@ModelAttribute("robotics") RoboticsModel member, Model model) {
        try {
            CompletableFuture<RoboticsModel> registeredMember = service.RoboticsRd(member);
            model.addAttribute("Rduser", registeredMember.get());
            return CompletableFuture.completedFuture("rd-success");
        } catch (Exception e) {
            // Handle validation errors
            return CompletableFuture.completedFuture("robotics");
        }
    }

    @GetMapping("/robotics")
    @Async
    public CompletableFuture<String> rdSuccess(@RequestParam(name = "id") Long userId, Model model) {
        // Fetch the user by ID and display the success page
        RoboticsModel Rduser = repo.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        // Use "user" as the attribute name to match the success page template
        model.addAttribute("Rduser", Rduser);
        return CompletableFuture.completedFuture("rd-success");
    }

}
