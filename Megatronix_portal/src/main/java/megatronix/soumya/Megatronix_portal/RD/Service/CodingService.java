package megatronix.soumya.Megatronix_portal.RD.Service;

import megatronix.soumya.Megatronix_portal.MRD.Model.MrdModel;
import megatronix.soumya.Megatronix_portal.MRD.Repo.MrdRepo;
import megatronix.soumya.Megatronix_portal.RD.Model.CodingModel;
import megatronix.soumya.Megatronix_portal.RD.Repo.CodingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class CodingService {
    @Autowired
    private CodingRepo coding;
    @Autowired
    private MrdRepo repo;

    @Async
    public CompletableFuture<CodingModel> CodingMainRd(CodingModel member) {
        Optional<MrdModel> model=repo.findById(member.getId());
        if ( !model.get().equals(null)) {
        List<CodingModel> list =coding.findBySelectedcodingevent(member.getSelectedcodingevent());
            for(CodingModel i : list) {
                if (member.getGid1().equals(i.getGid1())||
                        member.getGid1().equals(i.getGid2()) ||
                        (member.getGid2().equals(i.getGid2()) && !coding.existsByGid2IsNull())||
                        (member.getGid2().equals(i.getGid1()) && !coding.existsByGid2IsNull())) {
                    throw new RuntimeException("gid is already exists.");
                }

            }

        return CompletableFuture.completedFuture(coding.save(member));
        }
        throw new RuntimeException("gid is not present");
    }
    @Async
    public CompletableFuture<CodingModel> CodingOnSportRd(CodingModel member) {
        Optional<MrdModel> model=repo.findById(member.getId());
        if ( !model.get().equals(null)) {
          return CompletableFuture.completedFuture(coding.save(member));
    }
            throw new RuntimeException("gid is not present");
    }
    @Async
    public CompletableFuture<CodingModel> CodingRd(CodingModel member) {
        if (member.getSelectedcodingevent() == null) {
            throw new RuntimeException("selectedcodingevent is null.");
        }
        if ("debug".equals(member.getSelectedcodingevent())) {
            return CodingOnSportRd(member);
        } else {
            return CodingMainRd(member);
        }
    }

}
