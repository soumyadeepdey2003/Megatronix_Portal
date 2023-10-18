package megatronix.soumya.Megatronix_portal.RD.Service;

import megatronix.soumya.Megatronix_portal.RD.Model.CivilModel;
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
        List<ElectrialModel> list =electrial.findBySelectedelectrialevent(member.getSelectedelectrialevent());
        for(ElectrialModel i : list) {
            if (member.getGid1().equals(i.getGid1())||
                    member.getGid2().equals(i.getGid2()) ||
                    (member.getGid3().equals(i.getGid3()) && electrial.existsByGid3IsNull()) ||
                    (member.getGid4().equals(i.getGid4()) && electrial.existsByGid4IsNull()) ||
                    (member.getGid5().equals(i.getGid5()) && electrial.existsByGid5IsNull()) )
            {

                throw new RuntimeException("gid is already exists.");
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
        if(member.getSelectedelectrialevent().equals("Event2"))
            return ElectrialOnSportRd( member);
        else
            return ElectrialMainRd(member);

    }

}
