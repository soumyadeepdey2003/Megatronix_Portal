package megatronix.soumya.Megatronix_portal.RD.Repo;

import megatronix.soumya.Megatronix_portal.RD.Model.CivilModel;
import megatronix.soumya.Megatronix_portal.RD.Model.CodingModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CodingRepo extends JpaRepository<CodingModel, Long> {
}
