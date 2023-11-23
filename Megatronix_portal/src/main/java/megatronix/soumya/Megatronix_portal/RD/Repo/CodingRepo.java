package megatronix.soumya.Megatronix_portal.RD.Repo;

import megatronix.soumya.Megatronix_portal.RD.Model.CivilModel;
import megatronix.soumya.Megatronix_portal.RD.Model.CodingModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CodingRepo extends JpaRepository<CodingModel, Long> {

    boolean existsByGid1(Long gid1);
    boolean existsByGid2(Long gid2);

    boolean existsByGid2IsNull();


    List<CodingModel> findBySelectedcodingevent(String selectedcodingevent);
    Optional<CodingModel> findById(Long id);
}
