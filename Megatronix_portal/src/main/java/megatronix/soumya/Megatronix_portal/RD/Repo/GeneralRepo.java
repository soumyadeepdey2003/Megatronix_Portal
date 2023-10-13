package megatronix.soumya.Megatronix_portal.RD.Repo;

import megatronix.soumya.Megatronix_portal.RD.Model.CivilModel;
import megatronix.soumya.Megatronix_portal.RD.Model.GeneralModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneralRepo  extends JpaRepository<GeneralModel, Long> {
}
