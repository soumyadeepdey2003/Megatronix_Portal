package megatronix.soumya.Megatronix_portal.RD.Service;

import megatronix.soumya.Megatronix_portal.MRD.Model.MrdModel;
import megatronix.soumya.Megatronix_portal.MRD.Repo.MrdRepo;
import megatronix.soumya.Megatronix_portal.RD.Model.GeneralModel;
import megatronix.soumya.Megatronix_portal.RD.Repo.GeneralRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class GeneralService {
    @Autowired
    private GeneralRepo general;
    @Autowired
    private MrdRepo repo;
    @Async
    public CompletableFuture<GeneralModel> GeneralOnSportRd(GeneralModel member) {
        Optional<MrdModel> model=repo.findById(member.getId());
        if ( !model.get().equals(null)) {
        return CompletableFuture.completedFuture(general.save(member));
    }

        throw new RuntimeException("gid is not present");
    }
}
