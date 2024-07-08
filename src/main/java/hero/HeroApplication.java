package hero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.security.SecureRandom;
import java.util.Base64;
@ComponentScan
@SpringBootApplication
//@CrossOrigin(origins = "http://localhost:4200")
public class HeroApplication {

	public static void main(String[] args) {
		SpringApplication.run(HeroApplication.class, args);
	}

}
