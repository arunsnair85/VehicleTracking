package com.org.vts.security.jwt;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.org.vts.models.ERole;
import com.org.vts.security.services.UserDetailsImpl;
import com.org.vts.security.services.UserDetailsServiceImpl;


/**
 * The Class Oauth2Filter.
 * Filtering all input request and verify if its a valid jwt token
 */
public class Oauth2Filter extends OncePerRequestFilter {
	
	/** The jwt token gen. */
	@Autowired
	private JwtTokenGenerator jwtTokenGen;

	/** The user details service. */
	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	/** The http request. */
	@Autowired
	HttpServletRequest httpRequest;

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(Oauth2Filter.class);

	/**
	 * Do filter internal.
	 *
	 * @param request the request
	 * @param response the response
	 * @param filterChain the filter chain
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			String jwt = parseJwt(request);
			if (jwt != null && jwtTokenGen.validateJwtToken(jwt)) {
				String username = jwtTokenGen.getUserNameFromJwtToken(jwt);
				UserDetailsImpl userDetails = (UserDetailsImpl) userDetailsService.loadUserByUsername(username);
				String userTpe = userDetails.getAuthorities().stream().findFirst().map(s -> s.getAuthority().toString())
						.orElse(null);

				Boolean isValid = (userTpe.equals(ERole.DEVICE.toString())
						&& (userDetails.getDeviceId().equals(request.getHeader("DeviceID")))
						&& (userDetails.getVin().equals(request.getHeader("VIN"))));
				if (userTpe.equals(ERole.ADMIN.toString())) {
					boolean matches = request.getRequestURI().matches(".*vehiclelocation/api/v1/vehicle/.*");
					isValid = matches;
				}

				if (isValid) {
					UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
							userDetails, null, userDetails.getAuthorities());
					authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(authentication);
				}
			}
		} catch (Exception e) {
			logger.error("Cannot set user authentication: {}", e);
		}

		filterChain.doFilter(request, response);
	}

	/**
	 * Parses the jwt.
	 *
	 * @param request the request
	 * @return the string
	 */
	private String parseJwt(HttpServletRequest request) {
		String headerAuth = request.getHeader("Authorization");

		if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
			return headerAuth.substring(7, headerAuth.length());
		}

		return null;
	}
}
