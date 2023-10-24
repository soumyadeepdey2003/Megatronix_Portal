package megatronix.soumya.Megatronix_portal.RD.Service;

import megatronix.soumya.Megatronix_portal.RD.Model.GeneralModel;
import megatronix.soumya.Megatronix_portal.RD.Repo.GeneralRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class GeneralService {
    @Autowired
    private GeneralRepo general;

    @Async
    public CompletableFuture<GeneralModel> GeneralOnSportRd(GeneralModel member) {
        return CompletableFuture.completedFuture(general.save(member));
    }
}
