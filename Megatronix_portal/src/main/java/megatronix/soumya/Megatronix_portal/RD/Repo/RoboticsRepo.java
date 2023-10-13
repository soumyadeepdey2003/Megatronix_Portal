package megatronix.soumya.Megatronix_portal.RD.Repo;

import megatronix.soumya.Megatronix_portal.RD.Model.CivilModel;
import megatronix.soumya.Megatronix_portal.RD.Model.RoboticsModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoboticsRepo extends JpaRepository<RoboticsModel, Long> {
}
