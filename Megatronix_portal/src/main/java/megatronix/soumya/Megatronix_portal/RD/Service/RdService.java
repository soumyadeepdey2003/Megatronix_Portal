package megatronix.soumya.Megatronix_portal.RD.Service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.util.concurrent.CompletableFuture;

@Service
public class RdService {

    @Async
    public CompletableFuture<String> handleSelectedDomain(String selectedDomain) {
        // Your asynchronous processing for the selected domain goes here

        // Return the appropriate redirection path
        return CompletableFuture.completedFuture("redirect:/rd/" + selectedDomain);
    }
}
