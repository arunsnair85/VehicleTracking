package com.org.vts.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.vts.payload.request.LoginVO;
import com.org.vts.payload.response.JwtResponseVO;
import com.org.vts.service.AuthorizationService;


/**
 * The Class AuthorizationController.
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthorizationController {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(AuthorizationController.class);

	/** The authorization service. */
	@Autowired
	AuthorizationService authorizationService;

	/**
	 * 
	 * This method will generate JWT Token if the credentials and category of user are valid
	 * its an encrypted token.
	 * Assumptions :
	 * Users are already on-boarded to the application
	 * There are two types of users in the application DEVICE and ADMIN
	 * Future Enhancements
	 * -----------------------
	 * 1. Use distributed Cache persisent storage like Redis to persist token, it will improve the performance
	 * 2. Token expiry after stipulated time
	 * 3. Separate ZUL proxy and Authorization server for clean separation of concerns.
	 * 4. Integrate with an IDP
	 * 
	 * @param loginVO the login VO
	 * @return the response entity
	 */
	@PostMapping("/token")
	public ResponseEntity<?> generateToken(@Valid @RequestBody LoginVO loginVO) {
		try {
			JwtResponseVO jwtResponse = authorizationService.generateToken(loginVO);
			return ResponseEntity.ok(jwtResponse);
		} catch (Exception e) {
			logger.error("Generating token failed", e);
		}
		return new ResponseEntity<>("Please validate Username,password & usertype", HttpStatus.UNAUTHORIZED);

	}

}
