package megatronix.soumya.Megatronix_portal.RD.Controller;


import megatronix.soumya.Megatronix_portal.RD.Model.*;
import megatronix.soumya.Megatronix_portal.RD.Service.RdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
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



    @GetMapping("/rd/{selectedDomain}")
    @Async
    public CompletableFuture<String> showResult(@PathVariable String selectedDomain, Model model) {

        if (selectedDomain.equals("coding")) {
            model.addAttribute("coding", new CodingModel());
        } else if (selectedDomain.equals("robotics")) {
            model.addAttribute("robotics", new RoboticsModel());
        } else if (selectedDomain.equals("civil")) {
            model.addAttribute("civil", new CivilModel());
        } else if (selectedDomain.equals("electrical")) {
            model.addAttribute("electrical", new ElectricalModel());
        } else if (selectedDomain.equals("gaming")) {
            model.addAttribute("gaming", new GamingModel());
        } else if (selectedDomain.equals("general")) {
            model.addAttribute("general", new GeneralModel());
        }


        model.addAttribute("selectedDomain", selectedDomain);


        return CompletableFuture.completedFuture(selectedDomain);
    }






//    @Async
//    @RequestMapping(value="/rd", method = RequestMethod.POST)
//    public CompletableFuture<String> processForm(@ModelAttribute("rdmain") Rdmain rdmain, RedirectAttributes redirectAttributes) {
//        System.out.println("hi");
//        String selectedDomain = rdmain.getSelectedDomain();
//        redirectAttributes.addAttribute("selectedDomain", selectedDomain);
//        return CompletableFuture.completedFuture("redirect:/rd/" + selectedDomain);
//    }

    @Async
    @RequestMapping(value="/rd", method = RequestMethod.POST)
    public CompletableFuture<String> processForm(@ModelAttribute("rdmain") Rdmain rdmain, RedirectAttributes redirectAttributes) throws RuntimeException {
        try {
            return rdService.handleSelectedDomain(rdmain.getSelectedDomain());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error");
        }

    }


//    @PostMapping("/rd")
//    @Async
//    public CompletableFuture<String> submitForm(@ModelAttribute("rdmain") Rdmain rdmain, Model model, RedirectAttributes redirectAttributes) {
//        String selectedDomain = rdmain.getSelectedDomain();
//
//        // Use the selected domain to construct the redirect path
//        redirectAttributes.addAttribute("selectedDomain", selectedDomain);
//
//        // Add the codingRd attribute to the model
//        model.addAttribute("codingRd", new CodingModel());
//        model.addAttribute("roboticsRd", new RoboticsModel());
//        model.addAttribute("civilRd", new CivilModel());
//        model.addAttribute("electricalRd", new ElectrialModel());
//        model.addAttribute("gamingRd", new GamingModel());
//        model.addAttribute("generalRd", new GeneralModel());
//e
//        return rdService.handleSelectedDomain(selectedDomain);
//    }




}
