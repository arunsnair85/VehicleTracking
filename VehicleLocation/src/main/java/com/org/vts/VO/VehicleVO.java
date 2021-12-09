package com.org.vts.VO;

// TODO: Auto-generated Javadoc
/**
 * The Class VehicleVO.
 */
public class VehicleVO {

	/** The model. */
	public String model;
	
	/** The make. */
	public String make;
	
	/** The type. */
	public String type;

	/**
	 * Instantiates a new vehicle VO.
	 *
	 * @param model the model
	 * @param make the make
	 * @param type the type
	 */
	public VehicleVO(String model, String make, String type) {
		this.model = model;
		this.make = make;
		this.type = type;
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
}
