package megatronix.soumya.Megatronix_portal.RD.Repo;

import megatronix.soumya.Megatronix_portal.RD.Model.CivilModel;
import megatronix.soumya.Megatronix_portal.RD.Model.GamingModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GamingRepo extends JpaRepository<GamingModel, Long> {
}
