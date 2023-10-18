package megatronix.soumya.Megatronix_portal.RD.Controller;

import megatronix.soumya.Megatronix_portal.RD.Model.GamingModel;
import megatronix.soumya.Megatronix_portal.RD.Model.GeneralModel;
import megatronix.soumya.Megatronix_portal.RD.Repo.GamingRepo;
import megatronix.soumya.Megatronix_portal.RD.Service.GamingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.concurrent.CompletableFuture;

@Controller
public class GamingController {
    @Autowired
    private GamingService service;

    @PostMapping("/rd/gaming")
    @Async
    public CompletableFuture<String> register(@ModelAttribute("Rduser") GamingModel member, Model model) {
        try {
            GamingModel registeredMember = service.GamingOnSportRd(member);
            model.addAttribute("uniqueId", registeredMember.getId());
            return CompletableFuture.completedFuture("rd-success");
        } catch (Exception e) {
            // Handle validation errors
            return CompletableFuture.completedFuture("gaming");
        }
    }
}
