package megatronix.soumya.Megatronix_portal.MRD.Repo;

import megatronix.soumya.Megatronix_portal.MRD.Model.MrdModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MrdRepo extends JpaRepository<MrdModel, Long> {
    MrdModel findByEmail(String email);
    MrdModel findByPhoneNumber(String phoneNumber);
}