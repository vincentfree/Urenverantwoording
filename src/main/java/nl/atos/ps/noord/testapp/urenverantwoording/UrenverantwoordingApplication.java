package nl.atos.ps.noord.testapp.urenverantwoording;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UrenverantwoordingApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrenverantwoordingApplication.class, args);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
  		if (!registry.hasMappingForPattern("/templates/**")) {
     			registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/");
  		}
	}
}
