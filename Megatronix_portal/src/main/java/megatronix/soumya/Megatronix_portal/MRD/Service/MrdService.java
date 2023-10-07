package megatronix.soumya.Megatronix_portal.MRD.Service;

import megatronix.soumya.Megatronix_portal.MRD.Model.MrdModel;
import megatronix.soumya.Megatronix_portal.MRD.Repo.MrdRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MrdService {

    @Autowired
    private MrdRepo MrdRepository;


    public MrdModel registerMember(MrdModel member) {
        if (MrdRepository.existsByEmail(member.getEmail()) ||
                MrdRepository.existsByPhoneNumber(member.getPhoneNumber())) {
            throw new RuntimeException("Email or phone number already exists.");
        }

        return MrdRepository.save(member);
    }

}
