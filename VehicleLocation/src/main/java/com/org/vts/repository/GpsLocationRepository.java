package com.org.vts.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import com.org.vts.model.GpsLocation;
import com.org.vts.model.GpsLocationId;

// TODO: Auto-generated Javadoc
/**
 * The Interface GpsLocationRepository.
 */
public interface GpsLocationRepository extends CassandraRepository<GpsLocation, GpsLocationId> {

	/**
	 * Find top by gps location id order by timestamp desc.
	 *
	 * @param vin the vin
	 * @return the optional
	 */
	@Query(value = "select * from GpsLocation where vin = ?0 order by timestamp desc limit 1", allowFiltering = true)
	Optional<GpsLocation> findTopByGpsLocationIdOrderByTimestampDesc(String vin);
	
	/**
	 * Find all by vin and timestamp less than equal andtimestamp greater than equal.
	 *
	 * @param vin the vin
	 * @param startTime the start time
	 * @param endTime the end time
	 * @return the list
	 */
	@Query(value = "SELECT * FROM GpsLocation WHERE vin= ?0 AND timestamp >= ?1 AND  timestamp <= ?2", allowFiltering = true)
	List<GpsLocation> findAllByVinAndTimestampLessThanEqualAndtimestampGreaterThanEqual(String vin,Date startTime,Date endTime);
}
