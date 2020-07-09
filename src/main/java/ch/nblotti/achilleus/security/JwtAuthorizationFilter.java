package ch.nblotti.achilleus.security;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.client.RestTemplate;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

  private static final Logger log = LoggerFactory.getLogger(JwtAuthorizationFilter.class);

  public String idpValidationUrl;

  public JwtAuthorizationFilter(AuthenticationManager authenticationManager, String idpValidationUrl) {
    super(authenticationManager);
    this.idpValidationUrl = idpValidationUrl;
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                  FilterChain filterChain) throws IOException, ServletException {
    UsernamePasswordAuthenticationToken authentication = getAuthentication(request);
    if (authentication == null) {
      filterChain.doFilter(request, response);
      return;
    }

    SecurityContextHolder.getContext().setAuthentication(authentication);
    filterChain.doFilter(request, response);
  }

  private Credentials validateToken(String token) {

    RestTemplate restTemplate = new RestTemplate();

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.add("Authorization", token);
    HttpEntity<String> entity = new HttpEntity<String>("", headers);
    ResponseEntity<Credentials> response = restTemplate.exchange(idpValidationUrl, HttpMethod.POST, entity, Credentials.class);

    if (response.getStatusCode() == HttpStatus.OK)
      return response.getBody();
    else
      return null;

  }

  private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
    String token = request.getHeader(SecurityConstants.TOKEN_HEADER);
    if (StringUtils.isNotEmpty(token)) {
      Credentials credentials = validateToken(token);

      List<SimpleGrantedAuthority> authorities = new ArrayList<>();
      credentials.getRoles().stream().map(p -> new SimpleGrantedAuthority(p)).forEach(authorities::add);
      return new UsernamePasswordAuthenticationToken(credentials.getEmail(), null, authorities);
    }

    return null;
  }

}
