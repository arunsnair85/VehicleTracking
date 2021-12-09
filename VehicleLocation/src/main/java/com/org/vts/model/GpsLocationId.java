package com.org.vts.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
// TODO: Auto-generated Javadoc
//import org.springframework.cassandra.core.PrimaryKeyType;

/**
 * The Class GpsLocationId.
 */
@PrimaryKeyClass
public class GpsLocationId implements Serializable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The vin. */
	@PrimaryKeyColumn(name = "vin", ordinal = 0,type = PrimaryKeyType.PARTITIONED)
	private String vin;
	
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

	/** The timestamp. */
	@PrimaryKeyColumn(name = "timestamp", ordinal = 0)
	private Date timestamp;
	
	
	

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
	 * Instantiates a new gps location id.
	 *
	 * @param vin the vin
	 * @param timestamp the timestamp
	 */
	public GpsLocationId(String vin,Date timestamp) {
		this.vin=vin;
		this.timestamp=timestamp;		
	}
	
	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	  public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
	    result = prime * result + ((vin == null) ? 0 : vin.hashCode());
	    return result;
	  }

	  /**
  	 * Equals.
  	 *
  	 * @param obj the obj
  	 * @return true, if successful
  	 */
  	@Override
	  public boolean equals(Object obj) {
	    if (this == obj)
	      return true;
	    if (obj == null)
	      return false;
	    if (getClass() != obj.getClass())
	      return false;
	    GpsLocationId other = (GpsLocationId) obj;
	    if (timestamp == null) {
	      if (other.timestamp != null)
	        return false;
	    } else if (!timestamp.equals(other.timestamp))
	      return false;
	    if (vin == null) {
	      if (other.vin != null)
	        return false;
	    } else if (!vin.equals(other.vin))
	      return false;
	    return true;
	  }
}
