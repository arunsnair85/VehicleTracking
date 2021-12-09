package com.org.vts.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.vts.model.GpsLocation;
import com.org.vts.repository.GpsLocationRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class VehicleController.
 */
@RestController
@RequestMapping("/api/v1/vehicle")
public class VehicleController {

	/** The logger. */
	Logger logger = LoggerFactory.getLogger(VehicleController.class);

	/** The gps location repository. */
	@Autowired
	GpsLocationRepository gpsLocationRepository;

	/**
	 * Gets the current location.
	 *
	 * @param vin the vin
	 * @return the current location
	 * *  This method will locate the current location of the vehicle 
	 *  for an authenticated and authorized user.
	 *  
	 *  Assumptions :
	 *  ----------------
	 * VIN is the unique identifier for a vehicle.
	 * Device installed Vehicle detail is readily available in Vehiclelocation DB
	 * 
	 */
	@GetMapping("/{vin}/locate")
	public ResponseEntity<GpsLocation> getCurrentLocation(@PathVariable String vin) {
		try {
			GpsLocation gpsLocation = gpsLocationRepository.findTopByGpsLocationIdOrderByTimestampDesc(vin)
					.orElse(null);
			return new ResponseEntity<>(gpsLocation, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("exception ..", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Gets the locations.
	 *
	 * @param vin the vin
	 * @param startTime the start time
	 * @param endTime the end time
	 * @return the locations
	 * *  This method will return the gps cordinates for a time interval of a vehicle
	 *  for a authenticated and authorized user.
	 *  
	 *  Assumptions :
	 *  ----------------
	 * VIN is the unique identifier for a vehicle.
	 * Device installed Vehicle detail is readily available in Vehiclelocation DB
	 * 
	 * Future Enhancements
	 * -----------------------
	 * 1. Asynchronous execution of this method
	 * 2. Viability of using any aggregation logic to retrieve the data
	 */
	@GetMapping("/{vin}/filter")
	public ResponseEntity<List<GpsLocation>> getLocations(@PathVariable String vin,
			@RequestParam("startTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date startTime,
			@RequestParam("endTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date endTime) {
		try {
			List<GpsLocation> gpsLocation = gpsLocationRepository.findAllByVinAndTimestampLessThanEqualAndtimestampGreaterThanEqual(vin,startTime, endTime);

			return new ResponseEntity<>(gpsLocation, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("exception ..", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
