package com.org.vts.service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.datastax.driver.core.utils.UUIDs;
import com.org.vts.VO.RegisterVO;
import com.org.vts.model.GpsLocation;
import com.org.vts.model.GpsLocationId;
import com.org.vts.model.Vehicle;
import com.org.vts.repository.GpsLocationRepository;
import com.org.vts.repository.VehicleRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class GpsLocationService.
 */
@Service
public class GpsLocationService {

	/** The log. */
	private static Logger log = LoggerFactory.getLogger(GpsLocationService.class);

	/** The gps location repository. */
	@Autowired
	GpsLocationRepository gpsLocationRepository;

	/** The vehicle repository. */
	@Autowired
	VehicleRepository vehicleRepository;

	/**
	 * Capture cordinates.
	 *
	 * @param registerVO the register VO
	 * @param vin the vin
	 * @return the completable future
	 * @throws InterruptedException the interrupted exception
	 */
	@Async("asyncExecutor")
	public CompletableFuture<GpsLocation> captureCordinates(RegisterVO registerVO, String vin)
			throws InterruptedException {
		try {
			/**
			 * TODO aggrregation logic // Optional<GpsLocation> latestgpsLocation =
			 * gpsLocationRepository.findTopByOrderByTimestampDescAndVin(vin); //
			 * GpsLocation latestgpsLoc=latestgpsLocation.orElse(null);
			 * //if(latestgpsLoc.getLatitude()==registerVO.getLocation().getLatitude() &&)
			 **/
			GpsLocationId gs = new GpsLocationId(vin, registerVO.getLocation().getTimestamp());
			GpsLocation gls = new GpsLocation(registerVO.getLocation().getLatitude(), registerVO.getLocation().getLongitude(),
					registerVO.getLocation().getSpeed(), null, gs);
			GpsLocation gpsLocation = gpsLocationRepository.save(gls);
			return CompletableFuture.completedFuture(gpsLocation);

		} catch (Exception e) {
			log.error("Async execution failed at captureCordinates", e);
		}
		return null;
	}

	/**
	 * Register vehicle.
	 *
	 * @param registerVO the register VO
	 * @param vin the vin
	 * @return the completable future
	 * @throws InterruptedException the interrupted exception
	 */
	@Async("asyncExecutor")
	public CompletableFuture<Vehicle> registerVehicle(RegisterVO registerVO, String vin) throws InterruptedException {
		try {
			Vehicle vehicle = vehicleRepository.findByVin(vin).orElse(null);
			if (!vehicle.isRegistered()) {
				vehicle.setActive(true);
				vehicle.setRegistered(true);
				vehicle.setMake(registerVO.vehicle.getMake());
				vehicle.setModel(registerVO.vehicle.getModel());
				vehicle.setType(registerVO.vehicle.getType());
				vehicleRepository.save(vehicle);
			}
			return CompletableFuture.completedFuture(vehicle);

		} catch (Exception e) {
			log.error("Async execution failed at registerVehicle", e);
		}
		return null;
	}

}
