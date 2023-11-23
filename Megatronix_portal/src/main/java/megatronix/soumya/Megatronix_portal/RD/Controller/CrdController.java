package megatronix.soumya.Megatronix_portal.RD.Controller;

import megatronix.soumya.Megatronix_portal.RD.Model.*;
import megatronix.soumya.Megatronix_portal.RD.Service.CrdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Controller
public class CrdController {


    @Autowired
    private CrdService CrdService;

    @GetMapping("/crd")
    @Async
    public CompletableFuture<String> showForm(Model model) {
        CrdMain crdmain = new CrdMain();
        model.addAttribute("crdmain", crdmain);
        return CompletableFuture.completedFuture("crd");
    }

    @Async
    @RequestMapping(value="/crd", method = RequestMethod.POST)
    public CompletableFuture<String> processForm(@ModelAttribute("crdmain") CrdMain Crdmain, RedirectAttributes redirectAttributes) throws RuntimeException {
        try {
            return CrdService.handleSelectedDomainforcrd(Crdmain.getSelectedDomain());
        } catch (Exception e) {
            //e.printStackTrace();
            throw new RuntimeException("Error");
        }

    }


    @GetMapping("/crd/{selectedDomain}")
    @Async
    public CompletableFuture<String> showResult(@PathVariable String selectedDomain, Model model) {

        if (selectedDomain.equals("codingcrd")) {
            model.addAttribute("codingcrd", new CodingcrdModel());
        } else if (selectedDomain.equals("roboticscrd")) {
            model.addAttribute("roboticscrd", new RoboticscrdModel());
        } else if (selectedDomain.equals("civilcrd")) {
            model.addAttribute("civilcrd", new CivilcrdModel());
        } else if (selectedDomain.equals("electricalcrd")) {
            model.addAttribute("electricalcrd", new ElectricalcrdModel());
        } else if (selectedDomain.equals("gamingcrd")) {
            model.addAttribute("gamingcrd", new GamingcrdModel());
        } else if (selectedDomain.equals("generalcrd")) {
            model.addAttribute("generalcrd", new GeneralcrdModel());
        }


        model.addAttribute("selectedDomain", selectedDomain);

        System.out.println(selectedDomain);
        return CompletableFuture.completedFuture(selectedDomain);
    }


    @Async
    @RequestMapping(value="/crd/civilcrd", method = RequestMethod.POST)
    public CompletableFuture<String> processcrdFormcivil(@ModelAttribute("civilcrd") CivilcrdModel civil, RedirectAttributes redirectAttributes) throws RuntimeException {

        try {

            return CrdService.handleSelectedDomainforcrdfordomain(civil.getSelectedcivilevent(),"civilcrd");
        } catch (Exception e) {
            //e.printStackTrace();
            throw new RuntimeException("Error");
        }

    }


    @Async
    @RequestMapping(value="/crd/codingcrd", method = RequestMethod.POST)
    public CompletableFuture<String> processcrdFormcoding(@ModelAttribute("codingcrd") CodingcrdModel coding,
                                                          RedirectAttributes redirectAttributes) throws RuntimeException {

        try {

            return CrdService.handleSelectedDomainforcrdfordomain(coding.getSelectedcodingevent(),"codingcrd");
        } catch (Exception e) {
            //e.printStackTrace();
            throw new RuntimeException("Error");
        }

    }


    @Async
    @RequestMapping(value="/crd/roboticscrd", method = RequestMethod.POST)
    public CompletableFuture<String> processcrdFormrobotics(@ModelAttribute("roboticscrd") RoboticscrdModel robotics,
                                                            RedirectAttributes redirectAttributes) throws RuntimeException {

        try {

            return CrdService.handleSelectedDomainforcrdfordomain(robotics.getSelectedroboticsevent(),"roboticscrd");
        } catch (Exception e) {
            //e.printStackTrace();
            throw new RuntimeException("Error");
        }

    }


    @Async
    @RequestMapping(value="/crd/electricalcrd", method = RequestMethod.POST)
    public CompletableFuture<String> processcrdFormelectrical(@ModelAttribute("electricalcrd") ElectricalcrdModel electrical,
                                                              RedirectAttributes redirectAttributes) throws RuntimeException {

        try {

            return CrdService.handleSelectedDomainforcrdfordomain(electrical.getSelectedelectricalevent(),"electricalcrd");
        } catch (Exception e) {
            //e.printStackTrace();
            throw new RuntimeException("Error");
        }

    }

    @Async
    @RequestMapping(value="/crd/gamingcrd", method = RequestMethod.POST)
    public CompletableFuture<String> processcrdFormgaming(@ModelAttribute("gamingcrd") GamingcrdModel gaming,
                                                          RedirectAttributes redirectAttributes) throws RuntimeException {

        try {

            return CrdService.handleSelectedDomainforcrdfordomain(gaming.getSelectedgamingevent(),"gamingcrd");
        } catch (Exception e) {
            //e.printStackTrace();
            throw new RuntimeException("Error");
        }

    }

    @Async
    @RequestMapping(value="/crd/generalcrd", method = RequestMethod.POST)
    public CompletableFuture<String> processcrdFormgeneral(@ModelAttribute("generalcrd") GeneralcrdModel general,
                                                           RedirectAttributes redirectAttributes) throws RuntimeException {

        try {

            return CrdService.handleSelectedDomainforcrdfordomain(general.getSelectedgeneralevent(),"generalcrd");
        } catch (Exception e) {
            //e.printStackTrace();
            throw new RuntimeException("Error");
        }

    }

    @GetMapping("/crd/codingcrd/{selectedcodingevent}")
    @Async
    public CompletableFuture<String> showResultcoding(@PathVariable String selectedcodingevent, Model model) {
        CompletableFuture<List<CodingModel>> futureList = CrdService.getSelectedDomainforcrdeventforcoding(selectedcodingevent);
        System.out.println(selectedcodingevent);  // Add this line to print the selectedcodingevent

        // Wait for the CompletableFuture to complete and get the result
        List<CodingModel> list = futureList.join();

        model.addAttribute("codingModels", list);

        return CompletableFuture.completedFuture("crdcoding_success"); // Thymeleaf template name
    }

    @GetMapping("/crd/roboticscrd/{selectedroboticsevent}")
    @Async
    public CompletableFuture<String> showResultrobotics(@PathVariable String selectedroboticsevent, Model model) {
        CompletableFuture<List<RoboticsModel>> futureList = CrdService.getSelectedDomainforcrdeventforrobotics(selectedroboticsevent);
        System.out.println(selectedroboticsevent);  // Add this line to print the selectedroboticsevent

        // Wait for the CompletableFuture to complete and get the result
        List<RoboticsModel> list = futureList.join();

        model.addAttribute("roboticsModels", list);

        return CompletableFuture.completedFuture("crdrobotics_success"); // Thymeleaf template name
    }

    @GetMapping("/crd/civilcrd/{selectedcivilevent}")
    @Async
    public CompletableFuture<String> showResultcivil(@PathVariable String selectedcivilevent, Model model) {
        CompletableFuture<List<CivilModel>> futureList = CrdService.getSelectedDomainforcrdeventforcivil(selectedcivilevent);
        System.out.println(selectedcivilevent);  // Add this line to print the selectedcivilevent

        // Wait for the CompletableFuture to complete and get the result
        List<CivilModel> list = futureList.join();

        model.addAttribute("civilModels", list);

        return CompletableFuture.completedFuture("crdcivil_success"); // Thymeleaf template name
    }

    @GetMapping("/crd/gamingcrd/{selectedgamingevent}")
    @Async
    public CompletableFuture<String> showResultgaming(@PathVariable String selectedgamingevent, Model model) {
        CompletableFuture<List<GamingModel>> futureList = CrdService.getSelectedDomainforcrdeventforgaming(selectedgamingevent);
        System.out.println(selectedgamingevent);  // Add this line to print the selectedgamingevent

        // Wait for the CompletableFuture to complete and get the result
        List<GamingModel> list = futureList.join();

        model.addAttribute("gamingModels", list);

        return CompletableFuture.completedFuture("crdgaming_success"); // Thymeleaf template name
    }

    @GetMapping("/crd/electricalcrd/{selectedelectricalevent}")
    @Async
    public CompletableFuture<String> showResultelectrical(@PathVariable String selectedelectricalevent, Model model) {
        CompletableFuture<List<ElectricalModel>> futureList = CrdService.getSelectedDomainforcrdeventforelectrical(selectedelectricalevent);
        System.out.println(selectedelectricalevent);  // Add this line to print the selectedelectricalevent

        // Wait for the CompletableFuture to complete and get the result
        List<ElectricalModel> list = futureList.join();

        model.addAttribute("electricalModels", list);

        return CompletableFuture.completedFuture("crdelectrical_success"); // Thymeleaf template name
    }

    @GetMapping("/crd/generalcrd/{selectedgeneralevent}")
    @Async
    public CompletableFuture<String> showResultgeneral(@PathVariable String selectedgeneralevent, Model model) {
        CompletableFuture<List<GeneralModel>> futureList = CrdService.getSelectedDomainforcrdeventforgeneral(selectedgeneralevent);
        System.out.println(selectedgeneralevent);  // Add this line to print the selectedgeneralevent

        // Wait for the CompletableFuture to complete and get the result
        List<GeneralModel> list = futureList.join();

        model.addAttribute("generalModels", list);

        return CompletableFuture.completedFuture("crdgeneral_success"); // Thymeleaf template name
    }


    @PostMapping("/updatePlayedStatuscoding/{id}")
    @Async
    public CompletableFuture<Optional<CodingModel>> updatePlayedStatuscoding(@PathVariable Long id) {
        return CrdService.markAsPlayedcoding((Long) id);
    }


    @PostMapping("/updatePlayedStatusrobotics/{id}")
    @Async
    public CompletableFuture<Optional<RoboticsModel>> updatePlayedStatusrobotics(@PathVariable Long id) {
        return CrdService.markAsPlayedrobotics((Long) id);
    }

    @PostMapping("/updatePlayedStatuscivil/{id}")
    @Async
    public CompletableFuture<Optional<CivilModel>> updatePlayedStatuscivil(@PathVariable Long id) {
        return CrdService.markAsPlayedcivil((Long) id);
    }

    @PostMapping("/updatePlayedStatuselectrical/{id}")
    @Async
    public CompletableFuture<Optional<ElectricalModel>> updatePlayedStatuselectrical(@PathVariable Long id) {
        return CrdService.markAsPlayedelectrical((Long) id);
    }

    @PostMapping("/updatePlayedStatusgaming/{id}")
    @Async
    public CompletableFuture<Optional<GamingModel>> updatePlayedStatusgaming(@PathVariable Long id) {
        return CrdService.markAsPlayedgaming((Long) id);
    }

    @PostMapping("/updatePlayedStatusgeneral/{id}")
    @Async
    public CompletableFuture<Optional<GeneralModel>> updatePlayedStatusgeneral(@PathVariable Long id) {
        return CrdService.markAsPlayedgeneral((Long) id);
    }

}
