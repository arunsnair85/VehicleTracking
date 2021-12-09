package com.org.vts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.vts.models.Device;

/**
 * The Interface DeviceReposistory.
 */
@Repository
public interface DeviceReposistory extends JpaRepository<Device, Long> {
}
