package com.org.vts.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.org.vts.payload.request.LoginVO;
import com.org.vts.payload.response.JwtResponseVO;
import com.org.vts.repository.UsersRepository;
import com.org.vts.security.jwt.JwtTokenGenerator;
import com.org.vts.security.services.UserDetailsImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class AuthorizationService.
 */
@Service
public class AuthorizationService {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(AuthorizationService.class);

	/** The authentication manager. */
	@Autowired
	AuthenticationManager authenticationManager;

	/** The users repository. */
	@Autowired
	UsersRepository usersRepository;

	/** The encoder. */
	@Autowired
	PasswordEncoder encoder;

	/** The jwt tokengen. */
	@Autowired
	JwtTokenGenerator jwtTokengen;

	/**
	 * Generate token.
	 *
	 * @param loginVO the login VO
	 * @return the jwt response VO
	 * @throws Exception the exception
	 */
	public JwtResponseVO generateToken(LoginVO loginVO) throws Exception {
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(loginVO.getUsername(), loginVO.getPassword()));
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		boolean isPresent = userDetails.getAuthorities().stream()
				.filter(a -> a.getAuthority().equals(loginVO.getUserType())).findFirst().isPresent();
		if (isPresent) {
			SecurityContextHolder.getContext().setAuthentication(authentication);
			String jwt = jwtTokengen.generateJwtToken(authentication);
			return new JwtResponseVO(jwt, userDetails.getId(), userDetails.getUsername(), loginVO.getUserType());

		}
		throw new Exception("UserType mismatch");
	}
}
