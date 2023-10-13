package megatronix.soumya.Megatronix_portal.RD.Repo;

import megatronix.soumya.Megatronix_portal.RD.Model.CivilModel;
import megatronix.soumya.Megatronix_portal.RD.Model.ElectrialModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElectrialRepo extends JpaRepository<ElectrialModel, Long> {
}
