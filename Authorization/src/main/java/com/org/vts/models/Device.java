package com.org.vts.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


/**
 * The Class Device.
 */
@Entity
@Table(name = "Device", uniqueConstraints = { @UniqueConstraint(columnNames = "deviceId") })
public class Device extends Auditable<String>  {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	/** The user. */
	@OneToOne(mappedBy = "device")
	private Users user;

	/** The device id. */
	@NotBlank
	@Size(max = 50)
	private String deviceId;

	/** The vehicle. */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "vin", referencedColumnName = "vin")
	private Vehicle vehicle;

	/**
	 * Gets the user.
	 *
	 * @return the user
	 */
	public Users getUser() {
		return user;
	}

	/**
	 * Sets the user.
	 *
	 * @param user the new user
	 */
	public void setUser(Users user) {
		this.user = user;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the device id.
	 *
	 * @return the device id
	 */
	public String getDeviceId() {
		return deviceId;
	}

	/**
	 * Sets the device id.
	 *
	 * @param deviceId the new device id
	 */
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	/**
	 * Gets the vehicle.
	 *
	 * @return the vehicle
	 */
	public Vehicle getVehicle() {
		return vehicle;
	}

	/**
	 * Sets the vehicle.
	 *
	 * @param vehicle the new vehicle
	 */
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	/**
	 * Instantiates a new device.
	 *
	 * @param deviceId the device id
	 */
	public Device(String deviceId) {
		this.deviceId = deviceId;
	}

	/**
	 * Instantiates a new device.
	 */
	public Device() {

	}
}
