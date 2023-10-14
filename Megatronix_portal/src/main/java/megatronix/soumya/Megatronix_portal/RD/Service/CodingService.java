package megatronix.soumya.Megatronix_portal.RD.Service;

import megatronix.soumya.Megatronix_portal.MRD.Model.MrdModel;
import megatronix.soumya.Megatronix_portal.RD.Model.CodingModel;
import megatronix.soumya.Megatronix_portal.RD.Repo.CodingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class CodingService {
    @Autowired
    private CodingRepo coding;

    @Async
    public CodingModel CodingMainRd(CodingModel member) {
        if((coding.existsByGid1(member.getGid1()) && !coding.existsByGid2IsNull() && coding.existsByGid2(member.getGid2())) || (coding.existsByGid1(member.getGid1()) ) )
            throw new RuntimeException("gid is already exists.");

        return coding.save(member);
    }
    @Async
    public CodingModel CodingOnSportRd(CodingModel member) {
        return coding.save(member);
    }
    @Async
    public CodingModel CodingRd(CodingModel member) {
        if(member.getSelectedcodingevent().equals("debug"))
            return CodingOnSportRd( member);
        else
            return CodingMainRd(member);

    }


}
