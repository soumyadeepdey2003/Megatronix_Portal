package megatronix.soumya.Megatronix_portal.RD.Service;

import megatronix.soumya.Megatronix_portal.RD.Model.CodingModel;
import megatronix.soumya.Megatronix_portal.RD.Repo.CodingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class CodingService {
    @Autowired
    private CodingRepo coding;

    @Async
    public CompletableFuture<CodingModel> CodingMainRd(CodingModel member) {

        List<CodingModel> list =coding.findBySelectedcodingevent(member.getSelectedcodingevent());
            for(CodingModel i : list) {
                if (member.getGid1().equals(i.getGid1())|| (member.getGid2().equals(i.getGid2()) && coding.existsByGid2IsNull())) {
                    throw new RuntimeException("gid is already exists.");
                }
            }

        return CompletableFuture.completedFuture(coding.save(member));
    }
    @Async
    public CompletableFuture<CodingModel> CodingOnSportRd(CodingModel member) {
        return CompletableFuture.completedFuture(coding.save(member));
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
