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

        Optional<MrdModel> gid1 = repo.findById(member.getGid1());
        Optional<MrdModel> gid2 = repo.findById(member.getGid2());
        Optional<MrdModel> gid3 = Optional.ofNullable(member.getGid3()).flatMap(repo::findById);
        Optional<MrdModel> gid4 = Optional.ofNullable(member.getGid4()).flatMap(repo::findById);
        Optional<MrdModel> gid5 = Optional.ofNullable(member.getGid5()).flatMap(repo::findById);
        if ( gid1.isPresent() &&
                gid2.isPresent() &&
                (gid3.isPresent() || member.getGid3() == null)  &&
                (gid4.isPresent() || member.getGid4() == null)  &&
                (gid5.isPresent() || member.getGid5() == null)
        ) {
        return CompletableFuture.completedFuture(general.save(member));
    }

        throw new RuntimeException("gid  not present");
    }
}
