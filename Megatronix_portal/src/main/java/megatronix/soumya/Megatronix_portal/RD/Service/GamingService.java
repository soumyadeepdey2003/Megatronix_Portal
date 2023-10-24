package megatronix.soumya.Megatronix_portal.RD.Service;

import megatronix.soumya.Megatronix_portal.RD.Model.GamingModel;
import megatronix.soumya.Megatronix_portal.RD.Repo.GamingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class GamingService {
    @Autowired
    private GamingRepo gaming;

    @Async
    public CompletableFuture<GamingModel> GamingOnSportRd(GamingModel member) {
        return CompletableFuture.completedFuture(gaming.save(member));
    }
}
