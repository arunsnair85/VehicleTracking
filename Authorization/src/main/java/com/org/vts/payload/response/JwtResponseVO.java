package com.org.vts.payload.response;

// TODO: Auto-generated Javadoc
/**
 * The Class JwtResponseVO.
 */
public class JwtResponseVO {
	
	/** The token. */
	private String token;
	
	/** The type. */
	private String type = "Bearer";
	
	/** The username. */
	private String username;
	
	/** The user type. */
	private String userType;

	/**
	 * Instantiates a new jwt response VO.
	 *
	 * @param accessToken the access token
	 * @param id the id
	 * @param username the username
	 * @param userType the user type
	 */
	public JwtResponseVO(String accessToken, Long id, String username, String userType) {
		this.token = accessToken;
		this.username = username;
		this.setUserType(userType);
	}

	/**
	 * Gets the access token.
	 *
	 * @return the access token
	 */
	public String getAccessToken() {
		return token;
	}

	/**
	 * Sets the access token.
	 *
	 * @param accessToken the new access token
	 */
	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	/**
	 * Gets the token type.
	 *
	 * @return the token type
	 */
	public String getTokenType() {
		return type;
	}

	/**
	 * Sets the token type.
	 *
	 * @param tokenType the new token type
	 */
	public void setTokenType(String tokenType) {
		this.type = tokenType;
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
	 * Gets the user type.
	 *
	 * @return the user type
	 */
	public String getUserType() {
		return userType;
	}

	/**
	 * Sets the user type.
	 *
	 * @param userType the new user type
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}
}
