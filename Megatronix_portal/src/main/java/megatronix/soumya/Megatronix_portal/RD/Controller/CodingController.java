package megatronix.soumya.Megatronix_portal.RD.Controller;

import megatronix.soumya.Megatronix_portal.MRD.Model.MrdModel;
import megatronix.soumya.Megatronix_portal.RD.Model.CodingModel;
import megatronix.soumya.Megatronix_portal.RD.Service.CodingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.concurrent.CompletableFuture;

@Controller
public class CodingController {

    @Autowired
    private CodingService service;
    @PostMapping("/rd/coding")
    @Async
    public CompletableFuture<String> register(@ModelAttribute("Rduser") CodingModel member, Model model) {
        try {
            CompletableFuture<CodingModel> registeredMember = service.CodingRd(member);
            model.addAttribute("uniqueId", registeredMember.get().getId());
            return CompletableFuture.completedFuture("rd-success");
        } catch (Exception e) {
            // Handle validation errors
            return CompletableFuture.completedFuture("coding");
        }
    }
}
