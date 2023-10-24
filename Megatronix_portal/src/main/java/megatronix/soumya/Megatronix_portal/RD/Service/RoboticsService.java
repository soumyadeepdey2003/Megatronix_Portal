package megatronix.soumya.Megatronix_portal.RD.Service;

import megatronix.soumya.Megatronix_portal.RD.Model.RoboticsModel;
import megatronix.soumya.Megatronix_portal.RD.Repo.RoboticsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class RoboticsService {
    @Autowired
    private RoboticsRepo robotics;

    @Async
    public CompletableFuture<RoboticsModel> RoboticsMainRd(RoboticsModel member) {
        List<RoboticsModel> list =robotics.findBySelectedroboticsevent(member.getselectedroboticsevent());
        for(RoboticsModel i : list) {
            if (member.getGid1().equals(i.getGid1())||
                    member.getGid2().equals(i.getGid2()) ||
                    (member.getGid3().equals(i.getGid3()) && robotics.existsByGid3IsNull()) ||
                    (member.getGid4().equals(i.getGid4()) && robotics.existsByGid4IsNull()) ||
                    (member.getGid5().equals(i.getGid5()) && robotics.existsByGid5IsNull()) )
            {

                throw new RuntimeException("gid is already exists.");
            }
        }
        return CompletableFuture.completedFuture(robotics.save(member));
    }
    @Async
    public CompletableFuture<RoboticsModel> RoboticsOnSportRd(RoboticsModel member) {
        return CompletableFuture.completedFuture(robotics.save(member));
    }
    @Async
    public CompletableFuture<RoboticsModel> RoboticsRd(RoboticsModel member) {
        if(member.getselectedroboticsevent().equals("Event5") || member.getselectedroboticsevent().equals("Event4"))
            return RoboticsOnSportRd( member);
        else
            return RoboticsMainRd(member);

    }

}
