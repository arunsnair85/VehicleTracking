package com.org.vts.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class GpsLocation.
 */
@Table
public class GpsLocation implements Serializable{

	/** The gps location id. */
	@PrimaryKey
    private GpsLocationId gpsLocationId;
	//private String vin;
/** The latitude. */
	//	private Date timestamp;
	private double latitude;
	
	/** The longitude. */
	private double longitude;
	
	/** The speed. */
	private double speed;
	
	/** The location. */
	private String location;

	/**
	 * Instantiates a new gps location.
	 *
	 * @param latitude the latitude
	 * @param longitude the longitude
	 * @param speed the speed
	 * @param location the location
	 * @param gpsLocationId the gps location id
	 */
	public GpsLocation(double latitude, double longitude, double speed,
			String location,GpsLocationId gpsLocationId) {
		//this.id = id;
		// this.deviceId = deviceId;
		//this.setVin(vin);
		//this.setTimestamp(timestamp);
		this.gpsLocationId=gpsLocationId;
		this.latitude = latitude;
		this.longitude = longitude;
		this.speed = speed;
		this.location = location;
	}

	/**
	 * Gets the latitude.
	 *
	 * @return the latitude
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * Sets the latitude.
	 *
	 * @param latitude the new latitude
	 */
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	/**
	 * Gets the longitude.
	 *
	 * @return the longitude
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * Sets the longitude.
	 *
	 * @param longitude the new longitude
	 */
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	/**
	 * Gets the speed.
	 *
	 * @return the speed
	 */
	public double getSpeed() {
		return speed;
	}

	/**
	 * Sets the speed.
	 *
	 * @param speed the new speed
	 */
	public void setSpeed(double speed) {
		this.speed = speed;
	}

	/**
	 * Gets the location.
	 *
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * Sets the location.
	 *
	 * @param location the new location
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/*
	 * public String getVin() { return vin; }
	 * 
	 * public void setVin(String vin) { this.vin = vin; }
	 * 
	 * public Date getTimestamp() { return timestamp; }
	 * 
	 * public void setTimestamp(Date timestamp) { this.timestamp = timestamp; }
	 */

}
