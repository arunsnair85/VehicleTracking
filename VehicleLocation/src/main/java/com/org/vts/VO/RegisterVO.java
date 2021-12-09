package com.org.vts.VO;

// TODO: Auto-generated Javadoc
/**
 * The Class RegisterVO.
 */
public class RegisterVO {

	/** The vehicle. */
	public VehicleVO vehicle;
    
    /** The location. */
    public LocationVO location;
    
    /**
     * Instantiates a new register VO.
     *
     * @param vehicle the vehicle
     * @param location the location
     */
    public RegisterVO(VehicleVO vehicle,LocationVO location) {
    	this.vehicle=vehicle;
    	this.location=location;
    }
	
	/**
	 * Gets the vehicle.
	 *
	 * @return the vehicle
	 */
	public VehicleVO getVehicle() {
		return vehicle;
	}
	
	/**
	 * Sets the vehicle.
	 *
	 * @param vehicle the new vehicle
	 */
	public void setVehicle(VehicleVO vehicle) {
		this.vehicle = vehicle;
	}
	
	/**
	 * Gets the location.
	 *
	 * @return the location
	 */
	public LocationVO getLocation() {
		return location;
	}
	
	/**
	 * Sets the location.
	 *
	 * @param location the new location
	 */
	public void setLocation(LocationVO location) {
		this.location = location;
	}
    
}
