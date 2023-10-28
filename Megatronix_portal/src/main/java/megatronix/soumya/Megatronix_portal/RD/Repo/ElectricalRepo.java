package megatronix.soumya.Megatronix_portal.RD.Repo;

import megatronix.soumya.Megatronix_portal.RD.Model.ElectricalModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ElectricalRepo extends JpaRepository<ElectricalModel, Long> {
    boolean existsByGid1(Long gid1);
    boolean existsByGid2(Long gid2);
    boolean existsByGid3(Long gid3);
    boolean existsByGid3IsNull();
    boolean existsByGid4(Long gid4);
    boolean existsByGid4IsNull();
    boolean existsByGid5(Long gid5);
    boolean existsByGid5IsNull();


    List<ElectricalModel> findBySelectedelectricalevent(String selectedelectricalevent);
}
