package megatronix.soumya.Megatronix_portal.RD.Controller;

import megatronix.soumya.Megatronix_portal.RD.Model.CodingModel;
import megatronix.soumya.Megatronix_portal.RD.Model.GeneralModel;
import megatronix.soumya.Megatronix_portal.RD.Service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.concurrent.CompletableFuture;

public class GeneralController {
    @Autowired
    private GeneralService service;

    @PostMapping("/rd/general")
    @Async
    public CompletableFuture<String> register(@ModelAttribute("Rduser") GeneralModel member, Model model) {
        try {
            GeneralModel registeredMember = service.GeneralOnSportRd(member);
            model.addAttribute("uniqueId", registeredMember.getId());
            return CompletableFuture.completedFuture("rd-success");
        } catch (Exception e) {
            // Handle validation errors
            return CompletableFuture.completedFuture("general");
        }
    }
}
