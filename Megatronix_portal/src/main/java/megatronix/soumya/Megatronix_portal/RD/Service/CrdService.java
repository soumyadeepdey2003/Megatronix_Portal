package megatronix.soumya.Megatronix_portal.RD.Service;

import megatronix.soumya.Megatronix_portal.RD.Model.*;
import megatronix.soumya.Megatronix_portal.RD.Repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class CrdService {

    @Autowired
    private  CodingRepo coding;

    @Autowired
    private  ElectricalRepo electrical;

    @Autowired
    private  GamingRepo gaming;

    @Autowired
    private  GeneralRepo general;

    @Autowired
    private  RoboticsRepo robotics;

    @Autowired
    private  CivilRepo civil;

    @Async
    public  CompletableFuture<String> handleSelectedDomainforcrd(String selectedDomain) {

        String redirectionPath = "redirect:/crd/" + selectedDomain.toString();
        return CompletableFuture.completedFuture(redirectionPath);
    }

    @Async
    public  CompletableFuture<String> handleSelectedDomainforcrdfordomain(String selectedDomain, String domain) {

        String redirectionPath = "redirect:/crd/"+domain.toString()+"/" + selectedDomain.toString();
        System.out.println(redirectionPath);
        return CompletableFuture.completedFuture(redirectionPath);
    }


    @Async
    public  CompletableFuture<List<CodingModel>> getSelectedDomainforcrdeventforcoding(  String event) {
        List<CodingModel> answer = new ArrayList<CodingModel>();
        List<CodingModel> list =coding.findBySelectedcodingevent(event);
        for (CodingModel i : list) {
            if(!i.isPlayed()){
                answer.add(i);
            }
        }
        return CompletableFuture.completedFuture(answer);

    }

    @Async
    public  CompletableFuture<List<RoboticsModel>> getSelectedDomainforcrdeventforrobotics(String event) {
        List<RoboticsModel> answer = new ArrayList<RoboticsModel>();
        List<RoboticsModel> list =robotics.findBySelectedroboticsevent(event);
        for (RoboticsModel i : list) {
            if(!i.isPlayed()){
                answer.add(i);
            }
        }
        return CompletableFuture.completedFuture(answer);

    }

    @Async
    public  CompletableFuture<List<ElectricalModel>> getSelectedDomainforcrdeventforelectrical(String event) {
        List<ElectricalModel> answer = new ArrayList<ElectricalModel>();
        List<ElectricalModel> list =electrical.findBySelectedelectricalevent(event);
        for (ElectricalModel i : list) {
            if(!i.isPlayed()){
                answer.add(i);
            }
        }
        return CompletableFuture.completedFuture(answer);

    }

    @Async
    public  CompletableFuture<List<CivilModel>> getSelectedDomainforcrdeventforcivil(String event) {
        List<CivilModel> answer = new ArrayList<CivilModel>();
        List<CivilModel> list =civil.findBySelectedcivilevent(event);
        for (CivilModel i : list) {
            if(!i.isPlayed()){
                answer.add(i);
            }
        }
        return CompletableFuture.completedFuture(answer);

    }

    @Async
    public  CompletableFuture<List<GeneralModel>> getSelectedDomainforcrdeventforgeneral(String event) {
        List<GeneralModel> answer = new ArrayList<GeneralModel>();
        List<GeneralModel> list =general.findBySelectedgeneralevent(event);
        for (GeneralModel i : list) {
            if(!i.isPlayed()){
                answer.add(i);
            }
        }
        return CompletableFuture.completedFuture(answer);

    }

    @Async
    public  CompletableFuture<List<GamingModel>> getSelectedDomainforcrdeventforgaming(  String event) {
        List<GamingModel> answer = new ArrayList<GamingModel>();
        List<GamingModel> list =gaming.findBySelectedgamingevent(event);
        for (GamingModel i : list) {
            if(!i.isPlayed()){
                answer.add(i);
            }
        }
        return CompletableFuture.completedFuture(answer);

    }

    @Async
    public CompletableFuture<Optional<CodingModel>> markAsPlayedcoding(Long id) {
        // Implement the logic to update the played status based on the ID
        // You can use your repository (e.g., codingRepo) to fetch and update the entity
        // Example:
        Optional<CodingModel> optionalCodingModel = coding.findById(id);
        if (optionalCodingModel.isPresent()) {
            CodingModel codingModel = optionalCodingModel.get();
            codingModel.setPlayed(true); // Assuming 'played' is a boolean field
            coding.save(codingModel);
        }
        return CompletableFuture.completedFuture(optionalCodingModel);
    }

    @Async
    public CompletableFuture<Optional<RoboticsModel>> markAsPlayedrobotics(Long id) {
        // Implement the logic to update the played status based on the ID
        // You can use your repository (e.g., roboticsRepo) to fetch and update the entity
        // Example:
        Optional<RoboticsModel> optionalroboticsModel = robotics.findById(id);
        if (optionalroboticsModel.isPresent()) {
            RoboticsModel roboticsModel = optionalroboticsModel.get();
            roboticsModel.setPlayed(true); // Assuming 'played' is a boolean field
            robotics.save(roboticsModel);
        }
        return CompletableFuture.completedFuture(optionalroboticsModel);
    }

    @Async
    public CompletableFuture<Optional<ElectricalModel>> markAsPlayedelectrical(Long id) {
        // Implement the logic to update the played status based on the ID
        // You can use your repository (e.g., electricalRepo) to fetch and update the entity
        // Example:
        Optional<ElectricalModel> optionalElectricalModel = electrical.findById(id);
        if (optionalElectricalModel.isPresent()) {
            ElectricalModel electricalModel = optionalElectricalModel.get();
            electricalModel.setPlayed(true); // Assuming 'played' is a boolean field
            electrical.save(electricalModel);
        }
        return CompletableFuture.completedFuture(optionalElectricalModel);
    }

    @Async
    public CompletableFuture<Optional<GamingModel>> markAsPlayedgaming(Long id) {
        // Implement the logic to update the played status based on the ID
        // You can use your repository (e.g., GamingRepo) to fetch and update the entity
        // Example:
        Optional<GamingModel> optionalGamingModel = gaming.findById(id);
        if (optionalGamingModel.isPresent()) {
            GamingModel gamingModel = optionalGamingModel.get();
            gamingModel.setPlayed(true); // Assuming 'played' is a boolean field
            gaming.save(gamingModel);
        }
        return CompletableFuture.completedFuture(optionalGamingModel);
    }

    @Async
    public CompletableFuture<Optional<CivilModel>> markAsPlayedcivil(Long id) {
        // Implement the logic to update the played status based on the ID
        // You can use your repository (e.g., CivilRepo) to fetch and update the entity
        // Example:
        Optional<CivilModel> optionalCivilModel = civil.findById(id);
        if (optionalCivilModel.isPresent()) {
            CivilModel civilModel = optionalCivilModel.get();
            civilModel.setPlayed(true); // Assuming 'played' is a boolean field
            civil.save(civilModel);
        }
        return CompletableFuture.completedFuture(optionalCivilModel);
    }

    @Async
    public CompletableFuture<Optional<GeneralModel>> markAsPlayedgeneral(Long id) {
        // Implement the logic to update the played status based on the ID
        // You can use your repository (e.g., GeneralRepo) to fetch and update the entity
        // Example:
        Optional<GeneralModel> optionalGeneralModel = general.findById(id);
        if (optionalGeneralModel.isPresent()) {
            GeneralModel generalModel = optionalGeneralModel.get();
            generalModel.setPlayed(true); // Assuming 'played' is a boolean field
            general.save(generalModel);
        }
        return CompletableFuture.completedFuture(optionalGeneralModel);
    }

}
