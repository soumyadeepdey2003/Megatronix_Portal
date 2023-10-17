package megatronix.soumya.Megatronix_portal.RD.Service;

import megatronix.soumya.Megatronix_portal.RD.Model.CivilModel;
import megatronix.soumya.Megatronix_portal.RD.Model.RoboticsModel;
import megatronix.soumya.Megatronix_portal.RD.Repo.CivilRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CivilService {
    @Autowired
    private CivilRepo civil;

    @Async
    public CivilModel CivilMainRd(CivilModel member) {
        if(civil.existsByGid1(member.getGid1()) || civil.existsByGid2(member.getGid2()) || (civil.existsByGid3(member.getGid3())&& !civil.existsByGid3IsNull())  ||(civil.existsByGid4(member.getGid4())&& !civil.existsByGid4IsNull()) || (civil.existsByGid5(member.getGid5())&& !civil.existsByGid5IsNull()))
        {
            List<CivilModel> list =civil.findByGid(member.getGid1());
            for(CivilModel i : list) {
                if (member.getselectedcivilevent().equals(i.getselectedcivilevent())) {
                    throw new RuntimeException("gid is already exists.");
                }
            }
        }
        return civil.save(member);
    }


}
