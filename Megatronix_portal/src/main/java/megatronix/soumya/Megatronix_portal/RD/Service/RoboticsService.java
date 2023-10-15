package megatronix.soumya.Megatronix_portal.RD.Service;

import megatronix.soumya.Megatronix_portal.RD.Model.CodingModel;
import megatronix.soumya.Megatronix_portal.RD.Model.RoboticsModel;
import megatronix.soumya.Megatronix_portal.RD.Repo.RoboticsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoboticsService {
    @Autowired
    private RoboticsRepo robotics;

    @Async
    public RoboticsModel RoboticsMainRd(RoboticsModel member) {
        if(robotics.existsByGid1(member.getGid1()) || robotics.existsByGid2(member.getGid2()) || (robotics.existsByGid3(member.getGid3())&& !robotics.existsByGid3IsNull())  ||(robotics.existsByGid4(member.getGid4())&& !robotics.existsByGid4IsNull()) || (robotics.existsByGid5(member.getGid5())&& !robotics.existsByGid5IsNull()))
        {
            List<RoboticsModel> list =robotics.findByGid(member.getGid1());
            for(RoboticsModel i : list) {
                if (member.getselectedroboticsevent().equals(i.getselectedroboticsevent())) {
                    throw new RuntimeException("gid is already exists.");
                }
            }
        }
        return robotics.save(member);
    }
    @Async
    public RoboticsModel RoboticsOnSportRd(RoboticsModel member) {
        return robotics.save(member);
    }
    @Async
    public RoboticsModel RoboticsRd(RoboticsModel member) {
        if(member.getselectedroboticsevent().equals("Event5") || member.getselectedroboticsevent().equals("Event4"))
            return RoboticsOnSportRd( member);
        else
            return RoboticsMainRd(member);

    }

}
