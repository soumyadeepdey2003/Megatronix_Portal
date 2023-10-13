package megatronix.soumya.Megatronix_portal.RD.Controller;


import megatronix.soumya.Megatronix_portal.RD.Model.CodingModel;
import megatronix.soumya.Megatronix_portal.RD.Model.Rdmain;
import megatronix.soumya.Megatronix_portal.RD.Service.RdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.concurrent.CompletableFuture;

@Controller
public class RdController {

    @Autowired
    private RdService rdService;
    @GetMapping("/rd")
    @Async
    public CompletableFuture<String> showForm(Model model) {
        Rdmain rdmain = new Rdmain();
        model.addAttribute("rdmain", rdmain);
        return CompletableFuture.completedFuture("rd");
    }

    // Handle form submission
//    @PostMapping("/rd")
//    @Async
//    public CompletableFuture<String> submitForm(@ModelAttribute("rdmain") Rdmain rdmain, RedirectAttributes redirectAttributes) {
//        String selectedDomain = rdmain.getSelectedDomain();
//
//        // Use the selected domain to construct the redirect path
//
//        redirectAttributes.addAttribute("selectedDomain", selectedDomain);
//        if(rdmain.getSelectedDomain().equals("coding"))
//          return CompletableFuture.completedFuture("redirect:/rd/coding" );
//        else if (rdmain.getSelectedDomain().equals("civil"))
//          return CompletableFuture.completedFuture("redirect:/rd/civil" );
//        else if (rdmain.getSelectedDomain().equals("robotics"))
//            return CompletableFuture.completedFuture("redirect:/rd/robotics" );
//        else if(rdmain.getSelectedDomain().equals("electrical"))
//            return CompletableFuture.completedFuture("redirect:/rd/electrical" );
//        else if(rdmain.getSelectedDomain().equals("gaming"))
//            return CompletableFuture.completedFuture("redirect:/rd/gaming" );
//        else if(rdmain.getSelectedDomain().equals("general"))
//            return CompletableFuture.completedFuture("redirect:/rd/general" );
//        else
//            return CompletableFuture.completedFuture("rd");
//    }
//
//    @GetMapping("/rd/{selectedDomain}")
//    @Async
//    public CompletableFuture<String> registrationFormrd(@PathVariable String selectedDomain, Model model) {
//
//        String templateName = selectedDomain + ".html";
//
//        model.addAttribute("selectedDomain", selectedDomain);
//        return CompletableFuture.completedFuture(templateName);
//    }

    @PostMapping("/rd")
    @Async
    public CompletableFuture<String> submitForm(@ModelAttribute("rdmain") Rdmain rdmain, RedirectAttributes redirectAttributes) {
        String selectedDomain = rdmain.getSelectedDomain();

        // Use the selected domain to construct the redirect path
        redirectAttributes.addAttribute("selectedDomain", selectedDomain);

        return rdService.handleSelectedDomain(selectedDomain);
    }

    @GetMapping("/rd/{selectedDomain}")
    @Async
    public CompletableFuture<String> showResult(@PathVariable String selectedDomain, Model model) {
        // You can handle the selected domain here and render the result accordingly
        model.addAttribute("selectedDomain", selectedDomain);
        return CompletableFuture.completedFuture(selectedDomain);
    }
}
