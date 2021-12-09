package com.org.vts.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import com.org.vts.model.Vehicle;

// TODO: Auto-generated Javadoc
/**
 * The Interface VehicleRepository.
 */
public interface VehicleRepository  extends CassandraRepository<Vehicle, UUID>{
	
	/**
	 * Find all.
	 *
	 * @return the list
	 */
	List<Vehicle> findAll();
	
	/**
	 * Find by vin.
	 *
	 * @param string the string
	 * @return the optional
	 */
	@Query(value = "select * from vehicle where vin = ?0", allowFiltering = true)
	Optional<Vehicle> findByVin(String string);

	

}
