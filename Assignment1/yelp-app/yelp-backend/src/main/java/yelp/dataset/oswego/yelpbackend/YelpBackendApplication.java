package yelp.dataset.oswego.yelpbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import yelp.dataset.oswego.yelpbackend.util.JsonToSql;

@SpringBootApplication
public class YelpBackendApplication {

	public static void main(String[] args) {
		

		SpringApplication.run(YelpBackendApplication.class, args);
	}

}
