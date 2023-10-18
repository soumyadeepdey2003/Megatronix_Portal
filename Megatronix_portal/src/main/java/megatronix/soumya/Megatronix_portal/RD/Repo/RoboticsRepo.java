package megatronix.soumya.Megatronix_portal.RD.Repo;

import megatronix.soumya.Megatronix_portal.RD.Model.CivilModel;
import megatronix.soumya.Megatronix_portal.RD.Model.RoboticsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoboticsRepo extends JpaRepository<RoboticsModel, Long> {
    boolean existsByGid1(Long gid1);
    boolean existsByGid2(Long gid2);
    boolean existsByGid3(Long gid3);
    boolean existsByGid3IsNull();
    boolean existsByGid4(Long gid4);
    boolean existsByGid4IsNull();
    boolean existsByGid5(Long gid5);
    boolean existsByGid5IsNull();


    List<RoboticsModel> findBySelectedroboticsevent(String getselectedroboticsevent);
}
