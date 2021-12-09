package com.org.vts.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

// TODO: Auto-generated Javadoc
/**
 * The Class Users.
 */
@Entity
@Table(name = "Users", uniqueConstraints = { @UniqueConstraint(columnNames = "username") })
public class Users extends Auditable<String> {

	/** The user id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userId;

	/** The username. */
	@NotBlank
	@Size(max = 20)
	private String username;

	/** The is active. */
	private boolean isActive;

	/** The password. */
	@NotBlank
	@Size(max = 120)
	private String password;

	/** The device. */
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_device", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "device_id"))
	private Device device;

	/** The roles. */
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	/**
	 * Gets the roles.
	 *
	 * @return the roles
	 */
	public Set<Role> getRoles() {
		return roles;
	}

	/**
	 * Sets the roles.
	 *
	 * @param roles the new roles
	 */
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets the username.
	 *
	 * @param username the new username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Gets the device.
	 *
	 * @return the device
	 */
	public Device getDevice() {
		return device;
	}

	/**
	 * Sets the device.
	 *
	 * @param device the new device
	 */
	public void setDevice(Device device) {
		this.device = device;
	}

	/**
	 * Instantiates a new users.
	 */
	public Users() {
	}

	/**
	 * Instantiates a new users.
	 *
	 * @param username the username
	 * @param isActive the is active
	 * @param password the password
	 */
	public Users(String username, boolean isActive, String password) {
		this.username = username;
		this.isActive = isActive;
		this.password = password;
		// this.userType = userType;
	}

	/**
	 * Gets the user id.
	 *
	 * @return the user id
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * Sets the user id.
	 *
	 * @param userId the new user id
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * Checks if is active.
	 *
	 * @return true, if is active
	 */
	public boolean isActive() {
		return isActive;
	}

	/**
	 * Sets the active.
	 *
	 * @param isActive the new active
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
