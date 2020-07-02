package ch.nblotti.r;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.Arrays;

@RestController
@RequestMapping("/r")
public class RController {



  @Autowired
  RestTemplate restTemplate;

  @Value("${r.server.url}")
  String rServerUrl;

  @PostMapping(value = "/")
  public ResponseEntity<String> ftArticles(HttpServletResponse response, @RequestParam String firmName, @RequestParam LocalDate date) {


    HttpHeaders headers = new HttpHeaders();
    HttpEntity<String> request = new HttpEntity<String>(null,headers);

    return
      restTemplate.exchange(rServerUrl, HttpMethod.POST, request, String.class);


  }
}
