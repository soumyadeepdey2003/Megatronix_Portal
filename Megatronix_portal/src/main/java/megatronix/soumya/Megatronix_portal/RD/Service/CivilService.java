package megatronix.soumya.Megatronix_portal.RD.Service;

import megatronix.soumya.Megatronix_portal.RD.Model.CivilModel;
import megatronix.soumya.Megatronix_portal.RD.Model.CodingModel;
import megatronix.soumya.Megatronix_portal.RD.Model.RoboticsModel;
import megatronix.soumya.Megatronix_portal.RD.Repo.CivilRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class CivilService {
    @Autowired
    private CivilRepo civil;

    @Async
    public CompletableFuture<CivilModel> CivilMainRd(CivilModel member) {
        List<CivilModel> list =civil.findBySelectedcivilevent(member.getSelectedcivilevent());
        for(CivilModel i : list) {
            if (member.getGid1().equals(i.getGid1())||
                    member.getGid2().equals(i.getGid2()) ||
                    (member.getGid3().equals(i.getGid3()) && civil.existsByGid3IsNull()) ||
                    (member.getGid4().equals(i.getGid4()) && civil.existsByGid4IsNull()) ||
                    (member.getGid5().equals(i.getGid5()) && civil.existsByGid5IsNull()) )
            {

                throw new RuntimeException("gid is already exists.");
            }
        }
        return CompletableFuture.completedFuture(civil.save(member));
    }


}
