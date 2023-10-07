package megatronix.soumya.Megatronix_portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class MegatronixPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(MegatronixPortalApplication.class, args);
		System.out.println("hi portal");
	}

}
