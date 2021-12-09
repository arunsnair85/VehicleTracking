package com.org.vts.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.vts.models.Users;
import com.org.vts.repository.UsersRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class UserDetailsServiceImpl.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	/** The users repository. */
	@Autowired
	UsersRepository usersRepository;

	/**
	 * Load user by username.
	 *
	 * @param username the username
	 * @return the user details
	 * @throws UsernameNotFoundException the username not found exception
	 */
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = usersRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

		return UserDetailsImpl.build(user);
	}



}
