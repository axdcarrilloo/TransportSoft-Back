package transportSoft;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TransportSoftBackApplication implements CommandLineRunner{
	
	private static Logger log = LoggerFactory.getLogger(TransportSoftBackApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TransportSoftBackApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Levantando servicios de TransportSoft...!");
	}

}
