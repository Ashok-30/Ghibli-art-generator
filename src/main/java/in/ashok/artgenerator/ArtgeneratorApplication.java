package in.ashok.artgenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ArtgeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArtgeneratorApplication.class, args);
	}

}
