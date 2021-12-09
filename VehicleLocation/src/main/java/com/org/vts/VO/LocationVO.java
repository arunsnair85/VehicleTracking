package com.org.vts.VO;

import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class LocationVO.
 */
public class LocationVO {
	
	/** The timestamp. */
	public Date timestamp;
	
	/** The latitude. */
	public double latitude;
	
	/** The longitude. */
	public double longitude;
	
	/** The speed. */
	public int speed;
	
	/**
	 * Instantiates a new location VO.
	 *
	 * @param timestamp the timestamp
	 * @param latitude the latitude
	 * @param longitude the longitude
	 * @param speed the speed
	 */
	public LocationVO(Date timestamp,double latitude,double longitude,int speed) {
		this.timestamp=timestamp;
		this.latitude=latitude;
		this.longitude=longitude;
		this.speed=speed;
	}

	/**
	 * Gets the timestamp.
	 *
	 * @return the timestamp
	 */
	public Date getTimestamp() {
		return timestamp;
	}

	/**
	 * Sets the timestamp.
	 *
	 * @param timestamp the new timestamp
	 */
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
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
	public void setLatitude(double latitude) {
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
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	/**
	 * Gets the speed.
	 *
	 * @return the speed
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * Sets the speed.
	 *
	 * @param speed the new speed
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

}