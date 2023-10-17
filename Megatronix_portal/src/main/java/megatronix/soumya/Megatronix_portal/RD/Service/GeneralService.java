package megatronix.soumya.Megatronix_portal.RD.Service;

import megatronix.soumya.Megatronix_portal.RD.Model.CodingModel;
import megatronix.soumya.Megatronix_portal.RD.Model.GeneralModel;
import megatronix.soumya.Megatronix_portal.RD.Repo.GeneralRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class GeneralService {
    @Autowired
    private GeneralRepo general;

    @Async
    public GeneralModel GeneralOnSportRd(GeneralModel member) {
        return general.save(member);
    }
}
