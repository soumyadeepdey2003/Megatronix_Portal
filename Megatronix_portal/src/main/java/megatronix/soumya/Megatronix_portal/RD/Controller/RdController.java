package megatronix.soumya.Megatronix_portal.RD.Controller;


import megatronix.soumya.Megatronix_portal.RD.Model.Rdmain;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.concurrent.CompletableFuture;

@Controller
public class RdController {
    @GetMapping("/rd")
    @Async
    public CompletableFuture<String> showForm(Model model) {
        Rdmain rdmain = new Rdmain();
        model.addAttribute("rdmain", rdmain);
        return CompletableFuture.completedFuture("rd");
    }

    // Handle form submission
    @PostMapping("/rd")
    @Async
    public CompletableFuture<String> submitForm(@ModelAttribute("rdmain") Rdmain rdmain) {
        String selectedDomain = rdmain.getSelectedDomain();
        return CompletableFuture.completedFuture("redirect:/rd/" + selectedDomain);
    }
}
