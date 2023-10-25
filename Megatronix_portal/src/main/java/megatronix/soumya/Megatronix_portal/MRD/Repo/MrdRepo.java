package megatronix.soumya.Megatronix_portal.MRD.Repo;

import megatronix.soumya.Megatronix_portal.MRD.Model.MrdModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MrdRepo extends CrudRepository<MrdModel, Long> {
    boolean existsByEmail(String email);
    boolean existsByPhoneNumber(String phoneNumber);

    Optional<Object> findByGid(Long userId);
}