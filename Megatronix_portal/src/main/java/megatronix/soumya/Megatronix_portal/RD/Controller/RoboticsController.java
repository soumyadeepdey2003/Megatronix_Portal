package megatronix.soumya.Megatronix_portal.RD.Controller;

import megatronix.soumya.Megatronix_portal.RD.Model.CodingModel;
import megatronix.soumya.Megatronix_portal.RD.Model.RoboticsModel;
import megatronix.soumya.Megatronix_portal.RD.Service.RoboticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.concurrent.CompletableFuture;

@Controller
public class RoboticsController {
    @Autowired
    private RoboticsService service;

    @PostMapping("/rd/robotics")
    @Async
    public CompletableFuture<String> register(@ModelAttribute("Rduser") RoboticsModel member, Model model) {
        try {
            RoboticsModel registeredMember = service.RoboticsRd(member);
            model.addAttribute("uniqueId", registeredMember.getId());
            return CompletableFuture.completedFuture("rd-success");
        } catch (Exception e) {
            // Handle validation errors
            return CompletableFuture.completedFuture("robotics");
        }
    }
}
