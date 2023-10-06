package megatronix.soumya.Megatronix_portal.MRD.Service;

import megatronix.soumya.Megatronix_portal.MRD.Model.MrdModel;
import megatronix.soumya.Megatronix_portal.MRD.Repo.MrdRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MrdService {

    @Autowired
    private MrdRepo MrdRepository;
    public MrdModel registerUser(MrdModel user) {
        // Check if email and phone are unique
        if (MrdRepository.findByEmail(user.getEmail()) != null) {
            throw new IllegalArgumentException("error, Email already exists!");
        }
        if (MrdRepository.findByPhoneNumber(user.getPhoneNumber()) != null) {
            throw new IllegalArgumentException("error, Phone number already exists!");
        }

        // Save the user to the database
        return MrdRepository.save(user);

    }
}
