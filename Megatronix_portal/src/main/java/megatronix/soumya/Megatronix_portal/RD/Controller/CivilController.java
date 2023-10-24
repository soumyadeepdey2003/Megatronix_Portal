package megatronix.soumya.Megatronix_portal.RD.Controller;

import megatronix.soumya.Megatronix_portal.RD.Model.CivilModel;
import megatronix.soumya.Megatronix_portal.RD.Model.RoboticsModel;
import megatronix.soumya.Megatronix_portal.RD.Service.CivilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.concurrent.CompletableFuture;

public class CivilController {

    @Autowired
    private CivilService service;

    @PostMapping("/rd/civil")
    @Async
    public CompletableFuture<String> register(@ModelAttribute("Rduser") CivilModel member, Model model) {
        try {
            CompletableFuture<CivilModel> registeredMember = service.CivilMainRd(member);
            model.addAttribute("uniqueId", registeredMember.get().getId());
            return CompletableFuture.completedFuture("rd-success");
        } catch (Exception e) {
            // Handle validation errors
            return CompletableFuture.completedFuture("civil");
        }
    }
}
