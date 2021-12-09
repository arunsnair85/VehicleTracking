package com.org.vts.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

// TODO: Auto-generated Javadoc
/**
 * The Class Vehicle.
 */
@Entity
@Table(name = "Vehicle", uniqueConstraints = { @UniqueConstraint(columnNames = "vin") })
public class Vehicle extends Auditable<String> implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** The vin. */
	@NotBlank
	@Size(max = 100)
	private String vin;

	/**
	 * Instantiates a new vehicle.
	 *
	 * @param vin the vin
	 */
	public Vehicle(String vin) {
		this.vin = vin;
	}

	/**
	 * Instantiates a new vehicle.
	 */
	public Vehicle() {

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

}
