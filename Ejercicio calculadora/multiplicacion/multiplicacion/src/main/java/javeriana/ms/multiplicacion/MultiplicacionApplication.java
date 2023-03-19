package javeriana.ms.multiplicacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MultiplicacionApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultiplicacionApplication.class, args);
	}

}
