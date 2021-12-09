package com.org.vts.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.vts.models.Users;

// TODO: Auto-generated Javadoc
/**
 * The Interface UsersRepository.
 */
@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
	
	/**
	 * Find by username.
	 *
	 * @param username the username
	 * @return the optional
	 */
	Optional<Users> findByUsername(String username);
}
