package com.org.vts.controller;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.vts.VO.RegisterVO;
import com.org.vts.model.GpsLocation;
import com.org.vts.model.Vehicle;
import com.org.vts.service.GpsLocationService;

// TODO: Auto-generated Javadoc
/**
 * The Class GpsController.
 */
@RestController
@RequestMapping("/api/v1/device")
public class GpsController {

	/** The logger. */
	Logger logger = LoggerFactory.getLogger(GpsController.class);

	/** The gps service. */
	@Autowired
	GpsLocationService gpsService;	

	/**
	 * Capture cordinates.
	 *
	 * @param registerVO the register VO
	 * @param headers the headers
	 *  This method will register a vehicle and capture the gps cordinates 
	 *  for a authenticated and authorized user.
	 *  both are asynchronous operations to improve the throughput.
	 *  Using cassandra with timestamp and vin as clustering for better DB performance
	 *  
	 *  Assumptions :
	 *  ----------------
	 * VIN is the unique identifier for a vehicle.
	 * Device installed Vehicle detail is readily available in Vehiclelocation DB
	 * 
	 * Future Enhancements
	 * -----------------------
	 * 1. A new aysnc task (CompletableFuture) needs to be developed to capture place from google api
	 * 2. Data ingestion business logics if any
	 */
	@PostMapping("/gpscordinates")
	public void captureCordinates(@RequestBody RegisterVO registerVO, @RequestHeader Map<String, String> headers) {
		try {
			CompletableFuture<Vehicle> vehicle = gpsService.registerVehicle(registerVO, headers.get("vin"));
			CompletableFuture<GpsLocation> gpsLocation = gpsService.captureCordinates(registerVO, headers.get("vin"));
			CompletableFuture.allOf(gpsLocation, vehicle).join();
		} catch (InterruptedException e) {
			logger.error("CaptureCordinates exception ..", e);
		}

	}

}
