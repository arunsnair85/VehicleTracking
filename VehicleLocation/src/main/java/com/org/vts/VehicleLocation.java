package com.org.vts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

// TODO: Auto-generated Javadoc
/**
 * The Class VehicleLocation.
 */
@SpringBootApplication
@EnableEurekaClient
public class VehicleLocation {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(VehicleLocation.class, args);
	}

}
