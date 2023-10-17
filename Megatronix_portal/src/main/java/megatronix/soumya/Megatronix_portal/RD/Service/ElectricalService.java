package megatronix.soumya.Megatronix_portal.RD.Service;

import megatronix.soumya.Megatronix_portal.RD.Model.ElectrialModel;
import megatronix.soumya.Megatronix_portal.RD.Model.RoboticsModel;
import megatronix.soumya.Megatronix_portal.RD.Repo.ElectrialRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElectricalService {
    @Autowired
    private ElectrialRepo electrial;

    @Async
    public ElectrialModel ElectrialMainRd(ElectrialModel member) {
        if(electrial.existsByGid1(member.getGid1()) || electrial.existsByGid2(member.getGid2()) || (electrial.existsByGid3(member.getGid3())&& !electrial.existsByGid3IsNull())  ||(electrial.existsByGid4(member.getGid4())&& !electrial.existsByGid4IsNull()) || (electrial.existsByGid5(member.getGid5())&& !electrial.existsByGid5IsNull()))
        {
            List<ElectrialModel> list =electrial.findByGid(member.getGid1());
            for(ElectrialModel i : list) {
                if (member.getselectedelectrialevent().equals(i.getselectedelectrialevent())) {
                    throw new RuntimeException("gid is already exists.");
                }
            }
        }
        return electrial.save(member);
    }
    @Async
    public ElectrialModel ElectrialOnSportRd(ElectrialModel member) {
        return electrial.save(member);
    }
    @Async
    public ElectrialModel ElectrialRd(ElectrialModel member) {
        if(member.getselectedelectrialevent().equals("Event2"))
            return ElectrialOnSportRd( member);
        else
            return ElectrialMainRd(member);

    }

}
