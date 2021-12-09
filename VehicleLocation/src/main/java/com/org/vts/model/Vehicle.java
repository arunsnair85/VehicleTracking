package com.org.vts.model;

import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;


// TODO: Auto-generated Javadoc
/**
 * The Class Vehicle.
 */
@Table
public class Vehicle {
	
	/** The id. */
	private UUID id;
	
	/** The vin. */
	@PrimaryKey
	private String vin;
	
	/** The model. */
	private String model;
	
	/** The make. */
	private String make;
	
	/** The type. */
	private String type;
	
	/** The is active. */
	private boolean isActive;
	
	/** The is registered. */
	private boolean isRegistered;

	/**
	 * Instantiates a new vehicle.
	 *
	 * @param id the id
	 * @param vin the vin
	 * @param model the model
	 * @param make the make
	 * @param type the type
	 * @param isActive the is active
	 * @param isRegistered the is registered
	 */
	public Vehicle(UUID id,String vin,String model,String make,String type,boolean isActive,boolean isRegistered) {
		this.id=id;
		this.vin=vin;
		this.model=model;
		this.make=make;
		this.type=type;
		this.isActive=isActive;
		this.isRegistered=isRegistered;
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public UUID getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(UUID id) {
		this.id = id;
	}
	
	/**
	 * Gets the vin.
	 *
	 * @return the vin
	 */
	public String getVin() {
		return vin;
	}
	
	/**
	 * Sets the vin.
	 *
	 * @param vin the new vin
	 */
	public void setVin(String vin) {
		this.vin = vin;
	}
	
	
	/**
	 * Gets the make.
	 *
	 * @return the make
	 */
	public String getMake() {
		return make;
	}
	
	/**
	 * Sets the make.
	 *
	 * @param make the new make
	 */
	public void setMake(String make) {
		this.make = make;
	}
	
	/**
	 * Checks if is active.
	 *
	 * @return true, if is active
	 */
	public boolean isActive() {
		return isActive;
	}
	
	/**
	 * Sets the active.
	 *
	 * @param isActive the new active
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	/**
	 * Gets the model.
	 *
	 * @return the model
	 */
	public String getModel() {
		return model;
	}
	
	/**
	 * Sets the model.
	 *
	 * @param model the new model
	 */
	public void setModel(String model) {
		this.model = model;
	}
	
	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * Checks if is registered.
	 *
	 * @return true, if is registered
	 */
	public boolean isRegistered() {
		return isRegistered;
	}
	
	/**
	 * Sets the registered.
	 *
	 * @param isRegistered the new registered
	 */
	public void setRegistered(boolean isRegistered) {
		this.isRegistered = isRegistered;
	}

}
