package com.org.vts.security.jwt;

import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.org.vts.security.services.UserDetailsImpl;

import io.jsonwebtoken.*;

// TODO: Auto-generated Javadoc
/**
 * The Class JwtTokenGenerator.
 */
@Component
public class JwtTokenGenerator {
	
	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(JwtTokenGenerator.class);

	/** The jwt secret. */
	@Value("${vts.app.jwtSecret}")
	private String jwtSecret;

	/** The jwt expiration ms. */
	@Value("${vts.app.jwtExpirationMs}")
	private int jwtExpirationMs;

	/**
	 * Generate jwt token.
	 *
	 * @param authentication the authentication
	 * @return the string
	 */
	public String generateJwtToken(Authentication authentication) {

		UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
		String roles = userPrincipal.getAuthorities().stream().filter(s -> s.getAuthority().length()>0).findFirst().toString();
		 
		return Jwts.builder()
				.setSubject((userPrincipal.getUsername()))
				.setAudience(roles)
				.setIssuedAt(new Date())
				.setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
				.signWith(SignatureAlgorithm.HS512, jwtSecret)
				.compact();
	}

	/**
	 * Gets the user name from jwt token.
	 *
	 * @param token the token
	 * @return the user name from jwt token
	 */
	public String getUserNameFromJwtToken(String token) {
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
	}
	
	  /**
  	 * Gets the user type from jwt token.
  	 *
  	 * @param token the token
  	 * @return the user type from jwt token
  	 */
  	public String getUserTypeFromJwtToken(String token) { return
	  Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().
	  getAudience(); }
	 
	

	/**
	 * Validate jwt token.
	 *
	 * @param authToken the auth token
	 * @return true, if successful
	 */
	public boolean validateJwtToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
			return true;
		} catch (SignatureException e) {
			logger.error("Invalid JWT signature: {}", e.getMessage());
		} catch (MalformedJwtException e) {
			logger.error("Invalid JWT token: {}", e.getMessage());
		} catch (ExpiredJwtException e) {
			logger.error("JWT token is expired: {}", e.getMessage());
		} catch (UnsupportedJwtException e) {
			logger.error("JWT token is unsupported: {}", e.getMessage());
		} catch (IllegalArgumentException e) {
			logger.error("JWT claims string is empty: {}", e.getMessage());
		}

		return false;
	}
}
