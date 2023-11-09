package megatronix.soumya.Megatronix_portal.RD.Service;

import megatronix.soumya.Megatronix_portal.MRD.Model.MrdModel;
import megatronix.soumya.Megatronix_portal.MRD.Repo.MrdRepo;
import megatronix.soumya.Megatronix_portal.RD.Model.GamingModel;
import megatronix.soumya.Megatronix_portal.RD.Repo.GamingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class GamingService {
    @Autowired
    private GamingRepo gaming;
    @Autowired
    private MrdRepo repo;
    @Async
    public CompletableFuture<GamingModel> GamingOnSportRd(GamingModel member) {
        Optional<MrdModel> model=repo.findById(member.getId());
        if ( !model.get().equals(null)) {
        return CompletableFuture.completedFuture(gaming.save(member));
        }

        throw new RuntimeException("gid is not present");
    }
}
