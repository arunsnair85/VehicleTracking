package com.org.vts.security.services;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.org.vts.models.ERole;
import com.org.vts.models.Users;

// TODO: Auto-generated Javadoc
/**
 * The Class UserDetailsImpl.
 */
public class UserDetailsImpl implements UserDetails {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	private Long id;

	/** The username. */
	private String username;

	/** The device id. */
	private String deviceId;

	/** The vin. */
	private String vin;

	/** The password. */
	@JsonIgnore
	private String password;

	/**
	 * Gets the authorities.
	 *
	 * @return the authorities
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	/** The authorities. */
	private Collection<? extends GrantedAuthority> authorities;

	/**
	 * Instantiates a new user details impl.
	 *
	 * @param id the id
	 * @param username the username
	 * @param password the password
	 * @param authorities the authorities
	 * @param deviceId the device id
	 * @param vin the vin
	 */
	public UserDetailsImpl(Long id, String username, String password,
			Collection<? extends GrantedAuthority> authorities, String deviceId, String vin) {
		this.id = id;
		this.username = username;
		this.deviceId = deviceId;
		this.password = password;
		this.authorities = authorities;
		this.vin = vin;
	}

	/**
	 * Builds the.
	 *
	 * @param user the user
	 * @return the user details impl
	 */
	public static UserDetailsImpl build(Users user) {
		List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName().name())).collect(Collectors.toList());
		String role = user.getRoles().stream().findFirst().map(s -> s.getName().toString()).orElse(null);
		if (ERole.DEVICE.toString().equals(role)) {
			return new UserDetailsImpl(user.getUserId(), user.getUsername(), user.getPassword(), authorities,
					user.getDevice().getDeviceId(), user.getDevice().getVehicle().getVin());
		}else {
			return new UserDetailsImpl(user.getUserId(), user.getUsername(), user.getPassword(), authorities,
					null, null);
		}
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
	 * Gets the password.
	 *
	 * @return the password
	 */
	@Override
	public String getPassword() {
		return password;
	}

	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	@Override
	public String getUsername() {
		return username;
	}

	/**
	 * Checks if is account non expired.
	 *
	 * @return true, if is account non expired
	 */
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	/**
	 * Checks if is account non locked.
	 *
	 * @return true, if is account non locked
	 */
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	/**
	 * Checks if is credentials non expired.
	 *
	 * @return true, if is credentials non expired
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	/**
	 * Checks if is enabled.
	 *
	 * @return true, if is enabled
	 */
	@Override
	public boolean isEnabled() {
		return true;
	}

	/**
	 * Equals.
	 *
	 * @param o the o
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsImpl user = (UserDetailsImpl) o;
		return Objects.equals(id, user.id);
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
	 * Gets the vin.
	 *
	 * @return the vin
	 */
	public String getVin() {
		return vin;
	}

}
