package com.webonise.weatherapp.filter;

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
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import com.webonise.weatherapp.exception.JwtTokenExpiredException;
import com.webonise.weatherapp.util.JwtUtil;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

  private static final int BEGIN_INDEX = 7;
  @Autowired
  private JwtUtil jwtUtil;
  @Autowired
  private UserDetailsService userDetailsService;
  private Logger log = (Logger) LoggerFactory.getLogger(JwtRequestFilter.class);

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {

    String authorizationHeader = request.getHeader("Authorization");
    String username = null;
    String jwt = null;

    if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
      jwt = authorizationHeader.substring(BEGIN_INDEX);
      try {
        username = jwtUtil.extractUsername(jwt);
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
          UserDetails userDetails = userDetailsService.loadUserByUsername(username);
          if (jwtUtil.validateToken(jwt, userDetails)) {
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                userDetails, null, userDetails.getAuthorities());
            usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
          }
        }
      } catch (JwtTokenExpiredException exception) {
        log.error("Jwt exception: {}", exception.getMessage());
        ((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED,
            "Unauthorized Request, Please log in again");
      }
    }
    filterChain.doFilter(request, response);
  }
}
