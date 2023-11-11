package megatronix.soumya.Megatronix_portal.RD.Service;

import megatronix.soumya.Megatronix_portal.MRD.Model.MrdModel;
import megatronix.soumya.Megatronix_portal.MRD.Repo.MrdRepo;
import megatronix.soumya.Megatronix_portal.RD.Model.CivilModel;
import megatronix.soumya.Megatronix_portal.RD.Model.CodingModel;
import megatronix.soumya.Megatronix_portal.RD.Model.RoboticsModel;
import megatronix.soumya.Megatronix_portal.RD.Repo.CivilRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class CivilService {
    @Autowired
    private CivilRepo civil;

    @Autowired
    private MrdRepo repo;

    @Async
    public CompletableFuture<CivilModel> CivilMainRd(CivilModel member) {
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
            List<CivilModel> list = civil.findBySelectedcivilevent(member.getSelectedcivilevent());
            for (CivilModel i : list) {
                if (
                        (
                          member.getGid1().equals(i.getGid1()) ||
                          member.getGid1().equals(i.getGid2()) ||
                          member.getGid1().equals(i.getGid3()) ||
                          member.getGid1().equals(i.getGid4()) ||
                          member.getGid1().equals(i.getGid5()) ||
                          member.getGid1().equals(member.getGid2())||
                          member.getGid1().equals(member.getGid3())||
                          member.getGid1().equals(member.getGid4())||
                          member.getGid1().equals(member.getGid5())
                        )||

                        (
                         member.getGid2().equals(i.getGid1()) ||
                         member.getGid2().equals(i.getGid2()) ||
                         member.getGid2().equals(i.getGid3()) ||
                         member.getGid2().equals(i.getGid4()) ||
                         member.getGid2().equals(i.getGid5()) ||
                         member.getGid2().equals(member.getGid1())||
                         member.getGid2().equals(member.getGid3())||
                         member.getGid2().equals(member.getGid4())||
                         member.getGid2().equals(member.getGid5())
                        )||

                        (
                          (
                            member.getGid3() != null && member.getGid3().equals(i.getGid3()) ||
                            member.getGid3() != null &&member.getGid3().equals(i.getGid1()) ||
                            member.getGid3() != null &&member.getGid3().equals(i.getGid2()) ||
                            member.getGid3() != null &&member.getGid3().equals(i.getGid4()) ||
                            member.getGid3() != null &&member.getGid3().equals(i.getGid5())) ||
                            member.getGid3().equals(member.getGid2())||
                            member.getGid3().equals(member.getGid1())||
                            member.getGid3().equals(member.getGid4())||
                            member.getGid3().equals(member.getGid5()
                          )
                        )||

                        (
                          (
                            (member.getGid4() != null && member.getGid4().equals(i.getGid3())) ||
                            (member.getGid4() != null && member.getGid4().equals(i.getGid1()) )||
                            (member.getGid4() != null && member.getGid4().equals(i.getGid2())) ||
                            (member.getGid4() != null && member.getGid4().equals(i.getGid4())) ||
                             (member.getGid4() != null && member.getGid4().equals(i.getGid5()) )||
                             member.getGid4().equals(member.getGid2())||
                             member.getGid4().equals(member.getGid1())||
                             member.getGid4().equals(member.getGid3())||
                             member.getGid4().equals(member.getGid5())
                          )
                        )||

                        (
                          (
                                  (member.getGid5() != null && member.getGid5().equals(i.getGid3())) ||
                                  (member.getGid5() != null && member.getGid5().equals(i.getGid1())) ||
                                  (member.getGid5() != null && member.getGid5().equals(i.getGid2())) ||
                                  (member.getGid5() != null && member.getGid5().equals(i.getGid4())) ||
                                  (member.getGid5() != null && member.getGid5().equals(i.getGid5()))||
                                  member.getGid5().equals(member.getGid2())||
                                  member.getGid5().equals(member.getGid1())||
                                  member.getGid5().equals(member.getGid3())||
                                  member.getGid5().equals(member.getGid4())
                          )
                        )
                ) {

                    throw new RuntimeException("gid  already exists.");
                }
            }
            return CompletableFuture.completedFuture(civil.save(member));
        }

        throw new RuntimeException("gid  not present");
    }

}
