package megatronix.soumya.Megatronix_portal.MRD.Controller;

import megatronix.soumya.Megatronix_portal.MRD.Model.MrdModel;
import megatronix.soumya.Megatronix_portal.MRD.Repo.MrdRepo;
import megatronix.soumya.Megatronix_portal.MRD.Service.MrdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.concurrent.Future;

@Controller
public class MrdController {
    @Autowired
    private MrdService service;

    @Autowired
    private MrdRepo mrdRepository;

    @Async
    @GetMapping("/register")
    public Future<String> showRegistrationFormAsync(Model model) {
        model.addAttribute("user", new MrdModel());
        return new AsyncResult<>("registration");
    }

//    @Async
//    @GetMapping("/registration-success")
//    public Future<String> registrationSuccessAsync(@RequestParam(name = "id") Long userId, Model model) {
//        // Fetch the user by ID and display the success page
//        MrdModel user = mrdRepository.findById(userId)
//                .orElseThrow(() -> new IllegalArgumentException("User not found"));
//        model.addAttribute("user", user);
//        return new AsyncResult<>("registration-success");
//    }

    @Async
    @PostMapping("/register")
    public Future<String> processRegistrationAsync(@ModelAttribute("user") MrdModel user, Model model) {
        try {
            // Call the registerUser method
            MrdModel registeredUser = service.registerUser(user);
            return new AsyncResult<>("redirect:/registration-success?id=" + registeredUser.getId());
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return new AsyncResult<>("registration");
        }
    }
}
