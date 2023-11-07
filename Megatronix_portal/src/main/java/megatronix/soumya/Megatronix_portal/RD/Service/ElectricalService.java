package megatronix.soumya.Megatronix_portal.RD.Service;

import megatronix.soumya.Megatronix_portal.RD.Model.ElectricalModel;
import megatronix.soumya.Megatronix_portal.RD.Repo.ElectricalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class ElectricalService {
    @Autowired
    private ElectricalRepo electrical;

    @Async
    public CompletableFuture<ElectricalModel> ElectricalMainRd(ElectricalModel member) {
        List<ElectricalModel> list =electrical.findBySelectedelectricalevent(member.getSelectedelectricalevent());
        for(ElectricalModel i : list) {
            if (member.getGid1().equals(i.getGid1())  ||
                    member.getGid1().equals(i.getGid2())||
                    member.getGid1().equals(i.getGid3()) ||
                    member.getGid1().equals(i.getGid4())||
                    member.getGid1().equals(i.getGid5())||

                    member.getGid2().equals(i.getGid1())||
                    member.getGid2().equals(i.getGid2()) ||
                    member.getGid2().equals(i.getGid3())||
                    member.getGid2().equals(i.getGid4()) ||
                    member.getGid2().equals(i.getGid5())||

                    ((member.getGid3().equals(i.getGid3())||
                            member.getGid3().equals(i.getGid1() ) ||
                            member.getGid3().equals(i.getGid2())  ||
                            member.getGid3().equals(i.getGid4()) ||
                            member.getGid3().equals(i.getGid5())
                    ) && !electrical.existsByGid3IsNull()) ||

                    ((member.getGid4().equals(i.getGid3())||
                            member.getGid4().equals(i.getGid1() ) ||
                            member.getGid4().equals(i.getGid2())  ||
                            member.getGid4().equals(i.getGid4()) ||
                            member.getGid4().equals(i.getGid5())
                    )&& !electrical.existsByGid4IsNull()) ||

                    ((member.getGid5().equals(i.getGid3())||
                            member.getGid5().equals(i.getGid1() ) ||
                            member.getGid5().equals(i.getGid2())  ||
                            member.getGid5().equals(i.getGid4()) ||
                            member.getGid5().equals(i.getGid5())
                    )&& !electrical.existsByGid5IsNull()) )
            {

                throw new RuntimeException("gid is already exists.");
            }
        }
        return CompletableFuture.completedFuture(electrical.save(member));
    }
    @Async
    public CompletableFuture<ElectricalModel> ElectricalOnSportRd(ElectricalModel member) {
        return CompletableFuture.completedFuture(electrical.save(member));
    }
    @Async
    public CompletableFuture<ElectricalModel> ElectricalRd(ElectricalModel member) {
        if(member.getSelectedelectricalevent().equals("Event2"))
            return ElectricalOnSportRd( member);
        else
            return ElectricalMainRd(member);

    }

}
