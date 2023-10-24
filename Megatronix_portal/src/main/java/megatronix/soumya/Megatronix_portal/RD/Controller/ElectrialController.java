package megatronix.soumya.Megatronix_portal.RD.Controller;

import megatronix.soumya.Megatronix_portal.RD.Model.ElectrialModel;
import megatronix.soumya.Megatronix_portal.RD.Model.RoboticsModel;
import megatronix.soumya.Megatronix_portal.RD.Service.ElectricalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.concurrent.CompletableFuture;

public class ElectrialController {

    @Autowired
    private ElectricalService service;

    @PostMapping("/rd/electrial")
    @Async
    public CompletableFuture<String> register(@ModelAttribute("Rduser") ElectrialModel member, Model model) {
        try {
            CompletableFuture<ElectrialModel> registeredMember = service.ElectrialRd(member);
            model.addAttribute("uniqueId", registeredMember.get().getId());
            return CompletableFuture.completedFuture("rd-success");
        } catch (Exception e) {
            // Handle validation errors
            return CompletableFuture.completedFuture("electrial");
        }
    }
}
