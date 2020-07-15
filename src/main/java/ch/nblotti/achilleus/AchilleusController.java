package ch.nblotti.achilleus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/")
public class AchilleusController {


  @Autowired
  RestTemplate restTemplate;

  @Value("${r.server.url}")
  String rServerUrl;

  String argument = "{\"strategy\":\"%s\",\"account\":%s}";

  @PostMapping(value = "/")
  public ResponseEntity<String> doForAccountAndStrategy(HttpServletResponse response, @RequestParam String account, @RequestParam String strategy) {

    HttpHeaders headers = new HttpHeaders();
    String body = String.format(argument, strategy, account);
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<String> request = new HttpEntity<String>(body, headers);

    return restTemplate.exchange(rServerUrl, HttpMethod.POST, request, String.class);

  }


}
